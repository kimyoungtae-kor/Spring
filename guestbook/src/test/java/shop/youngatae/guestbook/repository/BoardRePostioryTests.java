package shop.youngatae.guestbook.repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Rollback;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import shop.youngatae.guestbook.domain.dto.PageRequestDto;
import shop.youngatae.guestbook.domain.entity.Board;
import shop.youngatae.guestbook.domain.entity.Member;
import shop.youngatae.guestbook.domain.entity.Reply;

@SpringBootTest
@Log4j2
public class BoardRePostioryTests {
  @Autowired
  private BoradRepository repository;
   @Test
  @Transactional
 @Rollback(false)
  public void testInsert() {
  //   Board board = Board.builder()
  //   .title("title" )
  //     .content("content"+ "1234")
  //     .member(Member.builder().email("t@s.c").build())
  //   .build();
  // repository.save(board);
    IntStream.rangeClosed(2, 100).forEach(i -> {
      Board board = Board.builder()
      .title("title" + i)
      .content("content"+ "1234")
      .member(Member.builder().email(i+"t@s.c").build())
      .build();
      repository.save(board);
    });
  }
  @Test
  @Transactional
  public void testSelectOne(){
    Board board = repository.findById(800L).orElse(null);
    log.info(board);

    log.info(board.getMember());
  }
  @Test
  public void getBoradWithMember(){
    Object result = repository.getBoradWithMember(800L);
    Object[] arr = (Object[]) result;
    log.info(Arrays.toString(arr));
  }
  @Test
  public void getBoardWithReply(){
    List<Object[]> result = repository.getBoardWithReply(800L);
    result.forEach(arr -> log.info(Arrays.toString(arr)));
  }
  @Test
  public void testGetBoardWithReplyCount(){
    Pageable pageable = PageRequest.of(1, 10,Sort.by(Direction.DESC,"bno"));
    Page<Object[]> result = repository.getBoardWithReplyCount(pageable);
    result.forEach(arr -> log.info(Arrays.toString(arr)));
  }
  @Test
  public void testgetBoardByBno(){
    Object[] arr = (Object[])repository.getBoardByBno(801L);
    log.info(arr);
  }
  @Test
  public void testSearch1(){
    repository.search1();
  }
  @Test
  public void testSearchPage(){
    repository.searPage("TC", "1",PageRequest.of(0,10,Sort.by(Direction.DESC,"bno","title")));
  }
}
