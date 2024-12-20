package shop.youngatae.mysecondpratice.servicee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;
import shop.youngatae.mysecondpratice.service.PostService;
@Log4j2
@SpringBootTest
public class PostServiceTests {
    @Autowired
    private PostService postService;
    @Test
    void contextLoads() {
        assertNotNull(postService); // 주입 여부 테스트
    }
}
