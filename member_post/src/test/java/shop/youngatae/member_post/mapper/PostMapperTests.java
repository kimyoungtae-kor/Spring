package shop.youngatae.member_post.mapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.matches;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import lombok.extern.log4j.Log4j2;
import shop.youngatae.member_post.dto.Criteria;

@SpringBootTest
@Log4j2
public class PostMapperTests {
  @Autowired
  private PostMapper mapper;

  @Test
  public void testExist(){
    assertNotNull(mapper);
  }

  @Test
  public void testlist(){
    Criteria cri = new Criteria();
    log.info(cri);

    mapper.selectList(cri);
  }

  @Test
  public void testView() {
    log.info(mapper.selectOne(126L));
  }
}
