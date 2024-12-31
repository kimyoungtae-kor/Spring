package shop.youngatae.guestbook.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import shop.youngatae.guestbook.domain.dto.BoardDto;

import shop.youngatae.guestbook.domain.dto.PageRequestDto;
import shop.youngatae.guestbook.domain.dto.PageResultDto;

@SpringBootTest
@Log4j2
public class BoardServicetests {
  @Autowired
  private BoardServiceImpl service;
  

  @Test
  public void gettest(){
    log.info(service.get(904L));
  }
  @Test
  @Transactional
  @Rollback(false)
  public void register(){
    //given
    BoardDto dto = BoardDto.builder().title("게시글제목")
    .content("게시글내용")
    .memberEmail("5t@s.c")
    .build(); 
    //when
    Long result = service.register(dto);
    //then
    assertNotNull(result);
  }
  @Test
  public void delete(){
    service.remove(802L);
  }
  @Test
  public void modify(){
    // BoardDto dto = service.get(908L);
    // dto.setMemberEmail("5t@s.c");

    // service.modify(dto);
    service.modify(BoardDto.builder()
    .bno(908L)
    .title("게시글제목2222")
    .content("게시글내용")
    .memberEmail("5t@s.c")
    .build());
  }
  @Test
  public void testList(){
    PageResultDto<BoardDto,Object[]> dto = service.list(PageRequestDto.builder().page(1).size(10).build());
    log.info(dto);
    dto.getDtoList().forEach(log::info);
    
  }
}
