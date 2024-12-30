package shop.youngatae.guestbook.repository;

import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import shop.youngatae.guestbook.domain.entity.Guestbook;
// import shop.youngatae.guestbook.domain.entity.QGuestbook;
import shop.youngatae.guestbook.domain.entity.QGuestbook;

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
  @Transactional
  public void testInsert(){
    repository.saveAll(IntStream.rangeClosed(1, 300).mapToObj(i->{
      return Guestbook.builder()
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
  @Transactional
  public void testupdate(){
    // Long gno = 1L;
    // Optional<Guestbook> opt = repository.findById(gno);
    // if(!opt.isPresent()){
    //   return;
    // }
    // // Guestbook entity = opt.get();
    // Guestbook modifiedEntity = Guestbook.builder()
    // .gno(1L)
    // .title("수정제목")
    // .content("느아아앙")
    // .writer("작성자2")
    // .build();
    // repository.save(modifiedEntity);
    
    // // 이건안됌
    Long gno = 1L;
    Optional<Guestbook> opt = repository.findById(gno);
    opt.ifPresent(entity -> {
        Guestbook modifiedEntity = Guestbook.builder()
            .gno(entity.getGno())
            .title("수정제목")
            .content("느아아앙")
            .writer("작성자2")
            .build();
        log.info(repository.save(modifiedEntity));
    });
    
    
    // repository.save(GuestbookEntity.builder()
    // .gno(1L)
    // .title("수정제목")
    // .content("느아아앙")
    // .writer("작성자2")
    // .build());

    // repository.updateGuestById(1L,"느아아앙");
  }




  //검색
  @Test
  public void testQuerydsl() {
    Guestbook.GuestbookBuilder builder1 = Guestbook.builder();
    Guestbook entity = builder1.build();
    builder1.content("콘텐트");
    builder1.title("타이틀");

    Pageable pageable = PageRequest.of(0,10,Sort.by(Direction.DESC, "gno"));
    //Qclass 엔티티에 정의되어있는 객체들을가져옴(싱글턴)
    QGuestbook qGuestbookEntity = QGuestbook.guestbook;

    String keyword = "1";
    //Where 절에 평가하기위한(검색) 빌더패턴
    BooleanBuilder builder = new BooleanBuilder();
    //실제 조건에 해당하는 where 조건식
    BooleanExpression expression = qGuestbookEntity.title.contains(keyword);


    // BooleanExpression expression2 = qGuestbookEntity.content.contains(keyword);
    // BooleanExpression expression3 = qGuestbookEntity.writer.contains(keyword);
    //
    builder.and(expression);
    builder.or(qGuestbookEntity.writer.contains(keyword));

    Page<Guestbook> result = repository.findAll(builder, pageable); 
    result.forEach(log::info);
  }

  
  // @Test
  // public void testQuerydsl() {
  //   Pageable pageable = PageRequest.of(0,10,Sort.by(Direction.DESC, "gno"));
  //   //
  //   QGuestbook qGuestbookEntity = QGuestbook.guestbook;

  //   String keyword = "1";

  //   BooleanBuilder builder = new BooleanBuilder();
  //   BooleanExpression expression = qGuestbookEntity.title.contains(keyword);

  //   builder.and(expression);

  //   Page<Guestbook> result = repository.findAll(builder, pageable); 
  //   result.forEach(log::info);
  // }
}
