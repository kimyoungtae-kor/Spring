package shop.yongatae.club.service;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;
import shop.yongatae.club.entity.Member;
import shop.yongatae.club.entity.Note;
import shop.yongatae.club.entity.composite.LikesId;
import shop.yongatae.club.repository.MemberRepository;
import shop.yongatae.club.repository.NoteRepository;
import shop.yongatae.club.security.dto.LikesDto;
import shop.yongatae.club.security.service.LikesService;

@SpringBootTest
@Log4j2
public class LikesServiceImplTests {
  @Autowired
  private LikesService likesService;
    @Autowired
  private NoteRepository noteRepository;
  @Autowired
  private MemberRepository memberRepository;
  @Test
  public void get() {
    LikesDto dto = LikesDto.builder().mno(100L).num(1L).build();
    likesService.get(dto);
  }
  @Test
  public void toggle(){
    LikesDto dto = LikesDto.builder().mno(100L).num(32L).build();
    likesService.toggle(dto);
  }
  @Test
  public void insert(){
    List<Long> mnos = new ArrayList<>(memberRepository.findAll().stream().map(Member::getMno).toList());
    List<Long> nums = new ArrayList<>(noteRepository.findAll().stream().map(Note::getNum).toList());
    
    Collections.shuffle(mnos);
    Collections.shuffle(nums);

    // mnos.subList(0,(int)(mnos.size() * .2));

    List<LikesDto>likesDtos = new ArrayList<>();
    for(int i = 0; i<mnos.size();i++){
      for(int j = 0; j < nums.size() ; j++){
        likesDtos.add(LikesDto.builder().mno(mnos.get(i)).num(nums.get(j)).build());
      }
    }
    log.info(likesDtos.size());

    //사이즈조절

    likesDtos = likesDtos.subList(0, likesDtos.size()/5);
    log.info(likesDtos.size());

    likesDtos.forEach(likesService::toggle);

  }
}
