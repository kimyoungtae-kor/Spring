package shop.yongatae.club.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.log4j.Log4j2;
import shop.yongatae.club.security.dto.AuthMemberDto;


@Controller
@Log4j2
@RequestMapping("sample")
public class SampleController {
  
  @GetMapping("all")
  public void exAll(@AuthenticationPrincipal AuthMemberDto dto) {
    UsernamePasswordAuthenticationToken token;
    AuthenticationManager manager ;
    AuthenticationProvider provider;
    log.info(dto);
    log.info("ex all");
  }
  @GetMapping("member")
  public void exMember(@AuthenticationPrincipal AuthMemberDto dto) {
    log.info(dto);
    log.info("ex member");
  }
  @GetMapping("admin")
  @PreAuthorize("hasRole('ADMIN')")
  public void exAdmin(@AuthenticationPrincipal AuthMemberDto dto) {
    log.info(dto);
    log.info("ex admin");
  }

  @GetMapping("api")
  @PreAuthorize("isAuthenticated()")
  // @PreAuthorize("isAnonymous()") <<비회원만
  @ResponseBody
  public AuthMemberDto getMethodName(@AuthenticationPrincipal AuthMemberDto dto) {
      return dto;
  }
  
  @GetMapping("exMemberOnly")
  @ResponseBody
  @PreAuthorize("#dto != null && #dto.username eq \"user100@youngatae.shop\"")
  public String exMemberOnly(@AuthenticationPrincipal AuthMemberDto dto) {
    log.info(dto.getUsername());  
    return dto.getEmail();
  }


  
  
  
  
  
}