package shop.yongatae.club.repository;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;
import shop.yongatae.club.entity.Attach;
import shop.yongatae.club.entity.Likes;
import shop.yongatae.club.entity.Member;
import shop.yongatae.club.entity.Note;
import shop.yongatae.club.security.service.LikesService;

@SpringBootTest
@Log4j2
public class LikeRepositoryTests {
  @Autowired
  LikesRepository likesRepository;

  @Autowired
  private LikesService service;
  @Autowired
  MemberRepository memberRepository;
  @Autowired
  NoteRepository noteRepository;


  @Test
  public void testExist(){
    log.info(likesRepository);
  }
  @Test
  public void inserttest(){
  
    Likes likes = Likes.builder()
    .member(Member.builder().mno(100L).build())
    .note(Note.builder().num(1L).build())
    .build();
    likesRepository.save(likes);
  }
  @Test
  public void deleteTest(){
    likesRepository.delete(Likes.builder().member(Member.builder().mno(100L).build()).note(Note.builder().num(1L).build()).build());
  }
  
}
