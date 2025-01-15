package shop.yongatae.club.repository;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import jakarta.transaction.Transactional;
import shop.yongatae.club.entity.Attach;
import shop.yongatae.club.entity.Member;
import shop.yongatae.club.entity.Note;

@SpringBootTest
public class AttachRepositoryTests {
  @Autowired
  AttachRepository repository;
  
  @Test
  @Transactional
  @Rollback(false)
  public void testinsert() {

    for(int i = 0 ; i< 5; i++){
      Attach attach = Attach.builder()
      .uuid(""+i)
      .origin("1.png")
      .image(true)
      .note(Note.builder().num(1L).build())
      .build();
      repository.save(attach);
    }

    // String uuid = UUID.randomUUID().toString(); 
    // Attach attach = Attach.builder()
    // .uuid(uuid)
    // .origin("1.png")
    // .image(true)
    // .note(Note.builder().num(1L).build())
    // .build();
    // repository.save(attach);
  }
  @Test
  @Transactional
  @Rollback(false)
  public void testList() {
    repository.findAll().forEach(System.out::println);
  }
}
