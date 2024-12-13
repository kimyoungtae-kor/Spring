package shop.youngatae.member_post.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class MemberServiceTests {
  @Autowired
  MemberServiceImpl service;

  @Test
  public void testFindby(){
    log.info(service.findBy("dydxo4423"));
  }
}
