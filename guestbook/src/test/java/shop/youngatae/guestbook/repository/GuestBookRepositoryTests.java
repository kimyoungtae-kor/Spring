package shop.youngatae.guestbook.repository;

import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;
import shop.youngatae.guestbook.domain.entity.GuestbookEntity;

@SpringBootTest
@Log4j2
public class GuestBookRepositoryTests {
  @Autowired
  private GuestbookRepository repository;
  @Test
  public void testExist(){
    log.info(repository);
  }
  @Test
  public void testInsert(){
    repository.saveAll(IntStream.rangeClosed(1, 300).mapToObj(i->{
      return GuestbookEntity.builder()
      .title("제목"+i)
      .content("내용"+i)
      .writer("작성자" + (i % 10))
      .build();
    }).toList()
    );
  }
  @Test
  public void testSelect(){
    repository.findAll().forEach(log::info);
  }
  @Test
  public void testSelectone(){
    log.info(repository.findById(1L));
  }
  @Test
  public void testupdate(){
    // Long gno = 1L;
    // Optional<GuestbookEntity> opt = repository.findById(gno);
    // if(!opt.isPresent()){
    //   return;
    // }
    // GuestbookEntity entity = opt.get();
    // GuestbookEntity modifiedEntity = GuestbookEntity.builder()
    // .gno(1L)
    // .title("수정제목")
    // .content("느아아앙")
    // .writer("작성자2")
    // .build();
    // repository.save(modifiedEntity);
    
    //이건안됌
    // Long gno = 1L;
    // Optional<GuestbookEntity> opt = repository.findById(gno);
    // opt.isPresent(e -> GuestbookEntity modifEntity = GuestbookEntity.builder()
    // .gno(1L)
    // .title("수정제목")
    // .content("느아아앙")
    // .writer("작성자2")
    // .build());
    
    
    // repository.save(GuestbookEntity.builder()
    // .gno(1L)
    // .title("수정제목")
    // .content("느아아앙")
    // .writer("작성자2")
    // .build());

    // repository.updateGuestById(1L,"느아아앙");
  }
}
