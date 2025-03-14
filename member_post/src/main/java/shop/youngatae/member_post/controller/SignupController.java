package shop.youngatae.member_post.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class SignupController {
  @GetMapping("/signup")
  public String index(){
    log.info("login");
    return "member/signup";
  }
}
