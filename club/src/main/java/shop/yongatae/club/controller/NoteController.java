package shop.yongatae.club.controller;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import shop.yongatae.club.entity.Note;
import shop.yongatae.club.security.dto.NoteDto;
import shop.yongatae.club.security.service.NoteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/notes")
@Log4j2
public class NoteController {
  private final NoteService service;

  @GetMapping("list")
  public List<NoteDto> list(String email) {
      return service.list(email);
  }
  
  @PostMapping("register")
  public Long PostMethod(@RequestBody NoteDto dto) {
      return service.register(dto);
  }
  @GetMapping("{num}")
  public NoteDto get(@PathVariable Long num) {
      return service.get(num);
  }
  @PutMapping("{num}")
  public void putMethodName(@PathVariable Long num, @RequestBody NoteDto dto) {
      log.info(dto);
      service.modify(dto);
  }
  @DeleteMapping("{num}")
  public void remove(@PathVariable Long num){
    service.remove(num);
  }
  
}
