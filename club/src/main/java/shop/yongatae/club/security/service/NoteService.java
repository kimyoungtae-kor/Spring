package shop.yongatae.club.security.service;

import java.util.List;
import java.util.Optional;

import shop.yongatae.club.entity.Attach;
import shop.yongatae.club.entity.Member;
import shop.yongatae.club.entity.Note;
import shop.yongatae.club.security.dto.AttachDto;
import shop.yongatae.club.security.dto.NoteDto;

public interface NoteService {
  default Note toEntity(NoteDto dto){
    Note note = Note.builder()
      .num(dto.getNum())
      .title(dto.getTitle())
      .content(dto.getContent())
      .member( Member.builder()
        .mno(dto.getMno())
        .email(dto.getWriter())

      .build())
    .build();

    note.setAttachs(dto.getAttachDtos().stream().map(a -> 
      Attach.builder()
        .uuid(a.getUuid())
        .origin(a.getOrigin())
        .image(a.isImage())
        .path(a.getPath())
        .size(a.getSize())
        .mime(a.getMime())
        .fileName(a.getFileName())
        .ext(a.getExt())
        .url(a.getUrl())
        .note(note)
      .build())
    .toList());
    return note;
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
    .attachDtos(note.getAttachs().stream().map(a -> AttachDto.builder()
    .ext(a.getExt())
    .fileName(a.getFileName())
    .image(a.isImage())
    .mime(a.getMime())
    .num(a.getNote().getNum())
    .origin(a.getOrigin())
    .path(a.getPath())
    .size(a.getSize())
    .url(a.getUrl())
    .uuid(a.getUuid())
    .build()).toList())
    .build();
  }
  Long register(NoteDto dto);
  Optional<NoteDto> get(Long num);
  
  int modify(NoteDto noteDto);
  int remove(Long num);
  List<NoteDto> list(String email);
  List<NoteDto> listAll();
}
