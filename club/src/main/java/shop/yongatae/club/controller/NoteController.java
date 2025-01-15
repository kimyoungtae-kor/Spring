package shop.yongatae.club.controller;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import shop.yongatae.club.security.dto.NoteDto;
import shop.yongatae.club.security.service.NoteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/notes")
@Log4j2
@CrossOrigin
public class NoteController {
  private final NoteService service;

  @GetMapping("list")
  public List<NoteDto> list(String email) {
      return service.list(email);
  }
  
  @PostMapping("register")
  public Long PostMethod(@RequestBody NoteDto dto) {
      log.info(dto+ "=============================");
      return service.register(dto);
  }
  @SuppressWarnings("unchecked")
  @GetMapping("{num}")
  public ResponseEntity<?> get(@PathVariable Long num) {
      return service.get(num).map(ResponseEntity::ok)
      .orElseGet(() -> {
        Map<String,Object> ret = new HashMap<>();
        ret.put("code",404);
        ret.put("message","Not_Found");
        ResponseEntity<?> entity = new ResponseEntity<>(ret,HttpStatus.NOT_FOUND);
        return (ResponseEntity<NoteDto>) entity;
      });
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
  @GetMapping("listall")
  public List<NoteDto> listAll() {
      return service.listAll();
  }
  
  
}
