package shop.yongatae.club.security.service;

import java.util.Optional;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import shop.yongatae.club.entity.Likes;
import shop.yongatae.club.entity.Member;
import shop.yongatae.club.entity.Note;
import shop.yongatae.club.entity.composite.LikesId;
import shop.yongatae.club.repository.LikesRepository;
import shop.yongatae.club.repository.MemberRepository;
import shop.yongatae.club.repository.NoteRepository;
import shop.yongatae.club.security.dto.LikesDto;

@Service
@Log4j2
public class LikesServiceImpl implements LikesService{
  @Autowired
  private LikesRepository repository;
  @Autowired
  private NoteRepository noteService;
  @Autowired
  private MemberRepository memberRepository;
  @Override
  public boolean get(LikesDto dto) {
    if(dto.getMno() == null){
      Long mno = memberRepository.findByEmail(dto.getEmail()).getMno();
      dto.setMno(mno);
    }
    
    return repository.findById(new LikesId(dto)).isPresent();
  }

  @Override
  public boolean toggle(LikesDto dto) {
    if(dto.getMno() == null){
      Long mno = memberRepository.findByEmail(dto.getEmail()).getMno();
      dto.setMno(mno);
    }
    boolean ret = get(dto);
    if(ret){
      repository.delete(toEntity(dto));
    }else{
      repository.save(toEntity(dto));
    }
    return ret;
  }

  @Override
  public void insert(Likes like) {
    repository.save(like);
  }
  
  
}
