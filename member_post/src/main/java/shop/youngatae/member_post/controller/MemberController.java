package shop.youngatae.member_post.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.micrometer.common.lang.Nullable;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import shop.youngatae.member_post.service.MemberService;
import shop.youngatae.member_post.vo.Member;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("member")
@Log4j2
@AllArgsConstructor
public class MemberController {
  // /member/signin
  // return type
  // String : '해당위치의 jsp (ex: /WEB-INF/views/member/signin.jsp)로 forward'
  // void : 접속 requestURI 위치를 반환 forward

  private MemberService service;
  @RequestMapping(value = "signin",method = RequestMethod.GET)
  public void signin(){}

  @PostMapping("signin")
  public String postSignin(Member member,@RequestParam(required = false,value = "remember-id")String remember,
  HttpSession session) {
    log.info(remember);
    log.info(member);

    if(service.login(member.getId(), member.getPwd())){
      //성공
      //1. 세션에 member라는 이름의 attribute
      session.setAttribute("member", service.findBy(member.getId()));
      //2. redirect index
      return "redirect:/";
    }else{
      //실패
    }

    return null;
  }
  
}
