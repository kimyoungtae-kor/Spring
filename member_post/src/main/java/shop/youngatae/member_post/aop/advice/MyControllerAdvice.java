package shop.youngatae.member_post.aop.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import shop.youngatae.member_post.exception.NotMyPostException;
import shop.youngatae.member_post.exception.UnsignedAuthException;

@ControllerAdvice
public class MyControllerAdvice {
  @ExceptionHandler({UnsignedAuthException.class,NotMyPostException.class})
  public String unsignedAuthException(Exception ex) {
    return "redirect:/msg="+ ex.getMessage() + "&url=/member/signin";
  }
}
