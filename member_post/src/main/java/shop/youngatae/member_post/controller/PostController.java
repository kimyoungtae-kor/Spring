package shop.youngatae.member_post.controller;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.context.annotation.SessionScope;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import shop.youngatae.member_post.aop.MyPost;
import shop.youngatae.member_post.aop.SigninCheck;
import shop.youngatae.member_post.dto.Criteria;
import shop.youngatae.member_post.dto.PageDto;
import shop.youngatae.member_post.service.PostService;
import shop.youngatae.member_post.vo.Member;
import shop.youngatae.member_post.vo.Post;







@Controller
@RequestMapping("post")
@AllArgsConstructor
@Log4j2
public class PostController {
  @Autowired
  private PostService service; 
  @GetMapping("list")
  public void list(Criteria cri,Model model) {
    model.addAttribute("posts", service.list(cri));
		model.addAttribute("pageDto", new PageDto(cri,service.count(cri)));
  }
  
  @GetMapping("view")

  public void view(@ModelAttribute("cri") Criteria cri,Long pno,Model model) {
      log.info(pno);
      model.addAttribute("post", service.view(pno));
  }
  @GetMapping("write")
  @SigninCheck
  public void getMethodName(@ModelAttribute("cri") Criteria cri) {}

  @PostMapping("write")
  @SigninCheck
  public String postWrite(Post post, Criteria cri) { 
    log.info(post);
    log.info(cri);
    post.setCno(cri.getCategory());
    service.write(post);
    return "redirect:list?" + cri.getQs2();

  }
  
  
  @GetMapping("modify")
  // @MyPost(id = "writer")
  @SigninCheck
  public void modify(@RequestParam("pno") Long pno,Model model,Criteria cri,
  @SessionAttribute(name = "member",required = false) Member member,String writer) {
    log.info(member + "dddddddd");
    Post post = service.findBy(pno);
    log.info(pno);
    log.info(cri);
    // if(member != null && member.getId().equals(post.getWriter())){
      
    // }
    if(member == null || !member.getId().equals(post.getWriter())){
      throw new RuntimeException("동일하지 않은 혹은 비로그인");
    }

    model.addAttribute("post", post);
  }
  @PostMapping("modify")
  @SigninCheck @MyPost
  public String postMethodName(Post post,Criteria cri) {
      log.info(post);
      log.info(cri);
      service.modify(post);
      return "redirect:list?"+cri.getQs();
  }
  @RequestMapping("remove")
  @MyPost
  public String requestMethodName(@RequestParam("pno")Long pno,Criteria cri) {
    service.remove(pno);   
    return "redirect:list?"+cri.getQs();
  }

  
}
