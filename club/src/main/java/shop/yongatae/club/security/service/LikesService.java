package shop.yongatae.club.security.service;

import shop.yongatae.club.entity.Likes;
import shop.yongatae.club.entity.Member;
import shop.yongatae.club.entity.Note;
import shop.yongatae.club.security.dto.LikesDto;

public interface LikesService {
  
  boolean toggle(LikesDto dto);
  boolean get(LikesDto dto);
  void insert(Likes like);

  default Likes toEntity(LikesDto dto) {
    return Likes.builder()
        .member(Member.builder().mno(dto.getMno()).build())
        .note(Note.builder().num(dto.getNum()).build()) 
        .build();
  }

  default LikesDto toDto(Likes likes) {
    return LikesDto.builder()
        .num(likes.getNote().getNum()) 
        .mno(likes.getMember().getMno()) 
        .email(likes.getMember().getEmail())
        .regdate(likes.getRegDate()) 
        .moddate(likes.getModDate())
        .build();
  }
}
