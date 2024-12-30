package shop.youngatae.guestbook.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class BoardServicetests {
  @Autowired
  private BoardServiceImpl boardServiceImpl;

  @Test
  public void gettest(){
    log.info(boardServiceImpl.get(801L));
  }
}
