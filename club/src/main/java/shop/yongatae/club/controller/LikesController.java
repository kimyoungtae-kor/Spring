package shop.yongatae.club.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
import shop.yongatae.club.security.dto.LikesDto;
import shop.yongatae.club.security.service.LikesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/v1/likes")
@Log4j2
public class LikesController {
  @Autowired
  private LikesService service;
  @GetMapping
  public boolean get(LikesDto dto){
    log.info(dto);
    return service.get(dto);
  }
  
  @PostMapping()
  public ResponseEntity<?> toggle(@RequestBody LikesDto dto,@AuthenticationPrincipal String email) {
      log.info(dto);
      log.info(email);
      return ResponseEntity.ok().body(Map.of("result",service.toggle(dto)));
  }
  
}
