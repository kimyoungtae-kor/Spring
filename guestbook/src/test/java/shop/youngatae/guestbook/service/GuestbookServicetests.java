package shop.youngatae.guestbook.service;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;
import shop.youngatae.guestbook.domain.dto.GuestbookDto;
import shop.youngatae.guestbook.domain.dto.GuestbookModifyDto;
import shop.youngatae.guestbook.domain.dto.PageRequestDto;
import shop.youngatae.guestbook.domain.dto.PageResultDto;
import shop.youngatae.guestbook.domain.entity.Guestbook;





@SpringBootTest
@Log4j2
public class GuestbookServicetests {
  @Autowired
  GuestbookServiceImpl service;

  // @Test
  // public void list(){
  //   service.list();
  //   log.info(service.list());
  // }
  @Test
  public void writer2(){
    GuestbookDto dto = GuestbookDto.builder()
    .title("작성글테스트")
    .content("느아아악")
    .writer("나는작성자다")
    .build();

    Long gno = service.write(dto);
    assertNotNull(gno);
  //   private Long gno;
  // private String title, content,writer;
  // private LocalDateTime regDate,modDate;  
  }
  @Test
  public void update(){
    GuestbookModifyDto dto = GuestbookModifyDto.builder()
        .gno(1L)
        .title("수정제목12")
        .content("수정 내용")
        .writer("수정 작성자")
        .build();

      service.modify(dto);
  }


  @Test
  public void testListPage(){
        // PageRequestDto dto = new PageRequestDto(99,3);
    // log.info(service.list(dto));


    // service.list(new PageRequestDto(2,10)).getDtoList().forEach(log::info);
    
    
    PageResultDto<GuestbookDto,Guestbook> dto = service.list(new PageRequestDto(2,10));
    log.info(dto);
    dto.getPageList().forEach(log::info);
  }
  @Test
  public void testResultDto(){

  }
}
