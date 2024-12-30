package shop.youngatae.guestbook.repository;

import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import shop.youngatae.guestbook.domain.entity.Board;
import shop.youngatae.guestbook.domain.entity.Reply;

@SpringBootTest
@Log4j2
public class ReplyRepositoryTests {

  @Autowired
  private ReplyRepository repository;

 @Test
  @Transactional
 @Rollback(false)
  public void testInsert() {
    // IntStream.rangeClosed(1, 20).forEach(i -> {
    //   Reply reply = Reply.builder()
    //   .text("text"+ "1234")
    //   .replyer("replyer" + i)
    //   .board(Board.builder().bno(800L+((int)Math.random() * 97)).build())
    //   .build();
    //   repository.save(reply);
    // });
    IntStream.rangeClosed(1, 500).forEach(i-> {
      Reply reply = Reply.builder()
        .text("text"+"1234")
        .replyer("replyer"+i)
        .board(Board.builder().bno( 800L+((int)(Math.random() * 96+1))).build())
        .build();
      repository.save(reply);
    });
  }
  @Test
  public void testSelectOne(){
    Reply reply =repository.findById(6L).orElse(null);
    log.info(reply);
    //댓글의 작성글의 작성자 이름 출력
    log.info(reply.getBoard().getMember().getName());

  }
   
}
