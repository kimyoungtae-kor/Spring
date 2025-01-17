package shop.yongatae.club.security.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.log4j.Log4j2;
import shop.yongatae.club.entity.Likes;
import shop.yongatae.club.entity.Member;
import shop.yongatae.club.entity.Note;
import shop.yongatae.club.entity.composite.LikesId;
import shop.yongatae.club.repository.LikesRepository;
import shop.yongatae.club.repository.MemberRepository;
import shop.yongatae.club.repository.NoteRepository;
import shop.yongatae.club.security.dto.NoteDto;

@Service
@Log4j2
public class NoteServiceImpl implements NoteService{
  @Autowired
  private NoteRepository repository;
  @Autowired
  private MemberRepository memberRepository;
  @Autowired
  private LikesRepository likesRepository;

  @Override
  @Transactional
  public Optional<NoteDto> get(Long num) {
    Long count = likesRepository.count(Example.of(Likes.builder().note(Note.builder().num(num).build()).build()));
    log.info(count);
    return repository.findById(num).map(this::toDto).map(d -> {d.setLikesCnt(count);return d;});
  }

  @Override
  public int modify(NoteDto noteDto) {
    repository.save(toEntity(noteDto));
    return 1;
  }

  @Override
  public Long register(NoteDto dto) {
    Member member = memberRepository.findByEmail(dto.getWriter());
    dto.setMno(member.getMno());
    Note note = toEntity(dto);
    repository.save(note);
    return note.getNum();
  }

  @Override
  public int remove(Long num) {
    repository.deleteById(num);
    return 1;
  }

  @Override
  public List<NoteDto> list(String email) {
    return repository.findNote(email).stream().map(p -> {
    NoteDto dto = toDto((Note)p[0]);
    dto.setLikesCnt((Long)p[1]);
    dto.setAttachCnt((Long)p[2]);
    return dto;
    }).toList();
  }

  @Override
  public List<NoteDto> listAll() {
    return repository.findNotes().stream().map(p -> {
      NoteDto dto = toDto((Note)p[0]);
      dto.setLikesCnt((Long)p[1]);
      dto.setAttachCnt((Long)p[2]);
      return dto;
      }).toList();
  }

  
}
