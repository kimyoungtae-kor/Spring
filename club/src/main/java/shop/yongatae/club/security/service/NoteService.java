package shop.yongatae.club.security.service;

import java.util.List;
import java.util.Optional;

import shop.yongatae.club.entity.Member;
import shop.yongatae.club.entity.Note;
import shop.yongatae.club.security.dto.NoteDto;

public interface NoteService {
  default Note toEntity(NoteDto dto){
    return Note.builder()
    .num(dto.getNum())
    .title(dto.getTitle())
    .content(dto.getContent())
    .member(Member.builder()
      .email(dto.getWriter())
      .mno(dto.getMno())
    .build())
    .build();
  }

  default NoteDto toDto(Note note){
    // String email = Optional.ofNullable(note.getMember())
    //         .map(Member::getEmail)
    //         .orElse("No Writer");
    // if (note == null) {
    //     throw new IllegalArgumentException("Note 객체가 null입니다.");
    // }


    
    return NoteDto.builder()
    .num(note.getNum())
    .title(note.getTitle())
    .content(note.getContent())
    .writer(note.getMember().getEmail())
    .mno(note.getMember().getMno())
    .regDate(note.getRegDate())
    .modDate(note.getModDate())
    .build();
  }
  Long register(NoteDto dto);
  NoteDto get(Long num);
  int modify(NoteDto noteDto);
  int remove(Long num);
  List<NoteDto> list(String email);
}
