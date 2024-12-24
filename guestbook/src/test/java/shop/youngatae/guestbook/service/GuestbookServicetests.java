package shop.youngatae.guestbook.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class GuestbookServicetests {
  @Autowired
  GuestbookServiceImpl service;
  @Test
  public void list(){
    service.list();
    log.info(service.list());
  }
}
