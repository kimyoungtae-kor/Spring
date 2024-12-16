package shop.youngatae.member_post.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;
import shop.youngatae.member_post.dto.Criteria;
import shop.youngatae.member_post.mapper.PostMapper;

@SpringBootTest
@Log4j2
public class PostServiceTests {
  @Autowired
  PostServiceImpl serviceImpl;
  @Autowired
  PostMapper mapper;


  @Test
  public void testOne(){
    log.info(mapper.selectOne(3L));
  }
  @Test
  public void testlist(){
    log.info(mapper.selectList(new Criteria()));
  }
  @Test
  public void testimpl(){
    log.info(serviceImpl.list(new Criteria()));
  }

}
