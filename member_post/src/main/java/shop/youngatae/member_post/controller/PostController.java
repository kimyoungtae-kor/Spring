package shop.youngatae.member_post.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import shop.youngatae.member_post.dto.Criteria;
import shop.youngatae.member_post.dto.PageDto;
import shop.youngatae.member_post.service.PostService;
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
  public void getMethodName(@ModelAttribute("cri") Criteria cri) {}
  
  @PostMapping("write")
  public String posWrite(Post post) {
      
      return "list?";
  }
  
}
