package shop.yongatae.club.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.log4j.Log4j2;

import shop.yongatae.club.security.dto.NoteDto;
import shop.yongatae.club.security.service.NoteService;


@SpringBootTest
@Log4j2
public class NoteServiceImplTests {
  @Autowired
  private NoteService service;
  @Test
  @Rollback(false)
  @Transactional
  public void register(){

    NoteDto dto = NoteDto.builder()
    .title("내용")
    .content("1234")
    .writer("user100@youngatae.shop")
    .mno(100L)
    .build();
   service.register(dto);
  }
  @Test
  @Transactional
  public void testGet(){
    log.info(service.get(5L));
  }
  @Test
  @Transactional
  public void List(){
    log.info(service.list("user100@youngatae.shop"));
  }
  // @Test
  @Test
  @Rollback(false)
  @Transactional
  public void modifytest(){

    NoteDto dto = NoteDto.builder()
    .num(6L)
    .title("내용")
    .content("12345")
    .writer("user100@youngatae.shop")
    .mno(100L)
    .build();
   service.register(dto);
  }
  @Test
  @Rollback(false)
  @Transactional
  public void testREmove(){
    service.remove(6L);
  }
  }