package shop.yongatae.club.security.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import shop.yongatae.club.entity.Member;
import shop.yongatae.club.entity.Note;
import shop.yongatae.club.repository.MemberRepository;
import shop.yongatae.club.repository.NoteRepository;
import shop.yongatae.club.security.dto.NoteDto;

@Service
public class NoteServiceImpl implements NoteService{
  @Autowired
  private NoteRepository repository;
  @Autowired
  private EntityManager manager;
  @Autowired
  MemberRepository repository2;
  @Override
  @Transactional
  public NoteDto get(Long num) {
    return toDto(repository.findByNum(num));
  }

  @Override
  public int modify(NoteDto noteDto) {
    repository.save(toEntity(noteDto));
    return 1;
  }

  @Override
  public Long register(NoteDto dto) {
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
    return repository.findByMemberEmail(email)
            .stream()
            .map(note -> toDto(note))
            .collect(Collectors.toList());
}

  
}
