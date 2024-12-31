package shop.youngatae.guestbook.controller;

import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import shop.youngatae.guestbook.domain.dto.BoardDto;
import shop.youngatae.guestbook.domain.dto.PageRequestDto;
import shop.youngatae.guestbook.service.BoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("api/v1/board")
@Log4j2
@AllArgsConstructor
@ComponentScan
public class BoardRestController {
  @Autowired
  private BoardService service;
  //목록조회
  @GetMapping("list")
  public ResponseEntity<?> list (PageRequestDto dto) {
      return ResponseEntity.ok().body(service.list(dto));
  }
  
  @GetMapping("{bno}")
  public ResponseEntity<?> get(@PathVariable("bno") Long bno) {
      return ResponseEntity.ofNullable(service.get(bno));
  }
  
  

  @DeleteMapping({"{bno}"})
  public ResponseEntity<?> delete(@PathVariable(required = false,value = "bno") Long bno) {
      service.remove(bno);
      return ResponseEntity.ok().body("success");
  }

  @PostMapping
  public ResponseEntity<?> register(@RequestBody BoardDto dto) {
      //TODO: process POST request
      service.register(dto);
 
      return ResponseEntity.ok().body("success");
  }
  
  @PutMapping("{bno}")
  public ResponseEntity<?> modify(@RequestBody BoardDto dto) {
      //TODO: process POST request
      service.modify(dto);
      return ResponseEntity.ok().body("success");
  }  
  @GetMapping("test")
  public String test() {
      return "test";
  }
  @GetMapping("search")
  public String getMethodName(@RequestParam String param) {
      return new String();
  }
  
  
}
