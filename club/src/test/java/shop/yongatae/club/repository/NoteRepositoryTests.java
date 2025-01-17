package shop.yongatae.club.repository;

import java.rmi.server.LogStream;
import java.util.Arrays;
import java.util.stream.LongStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.log4j.Log4j2;
import shop.yongatae.club.entity.Member;
import shop.yongatae.club.entity.Note;

@SpringBootTest
@Log4j2
@Transactional
public class NoteRepositoryTests {
  @Autowired
  private NoteRepository repository;

  @Test
  public void testExist(){
    log.info(repository);
  }

  @Test

  public void testOne(){
    log.info(repository.findByNum(1L));
  }

  @Test
  @Rollback(false)
  public void testSave(){
    LongStream.rangeClosed(1, 5).boxed().map(l->
    Note.builder()
    .title("제목"+ l)
    .content("내용" + l)
    .member(Member.builder().mno(100L).build())
    .build()).forEach(repository::save);;
  }
  @Test
  public void testList() {
    repository.findByMemberMno(100L).forEach(log::info);
  }
  @Test
  public void testList2() {
    repository.findByMemberEmail("user99@youngatae.shop").forEach(log::info);
  }
  @Test
  public void testListJPQL(){
    repository.findNote("user100@youngatae.shop").forEach(n -> {log.info(Arrays.toString(n));});
  }
}
