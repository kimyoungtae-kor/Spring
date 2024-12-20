package shop.youngatae.member_post.mapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.matches;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import lombok.extern.log4j.Log4j2;
import shop.youngatae.member_post.dto.Criteria;
import shop.youngatae.member_post.vo.Post;

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
  @Test
  public void testWrite(){
    // Post post = Post.builder().title("123").writer("test002").content("1132").cno(2).build();
    // log.info(mapper.write(post));
  }
}
