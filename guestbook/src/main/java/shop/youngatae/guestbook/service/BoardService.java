package shop.youngatae.guestbook.service;

import java.time.LocalDateTime;
import java.util.Arrays;

import shop.youngatae.guestbook.domain.dto.BoardDto;
import shop.youngatae.guestbook.domain.dto.GuestbookDto;
import shop.youngatae.guestbook.domain.dto.PageRequestDto;
import shop.youngatae.guestbook.domain.dto.PageResultDto;
import shop.youngatae.guestbook.domain.entity.Board;
import shop.youngatae.guestbook.domain.entity.Guestbook;
import shop.youngatae.guestbook.domain.entity.Member;

public interface BoardService {
  //   private String memberEmail;
  // private String memberName;
  // private LocalDateTime regDate;
  // private LocalDateTime modDate;
  // private int replyCnt;
  default Board toEntity(BoardDto dto){
    return Board.builder()
    .bno(dto.getBno())
    .title(dto.getTitle())
    .content(dto.getContent())
    .member(Member.builder().email(dto.getMemberEmail()).name(dto.getMemberName()).build())
    .build();
  }
  default BoardDto toDto(Object[] arr) {
    if(arr == null) return null;

    BoardDto.BoardDtoBuilder builder = BoardDto.builder();
    boolean containBoard = false;

    for(Object o : arr) {
      if(o == null) continue;

      Class<?> cls = o.getClass();
      if(cls == Long.class || cls == long.class) {
        builder.replyCnt(Integer.parseInt(o.toString()));
      }
      else if(cls == Member.class) {
        builder.memberEmail(((Member)o).getEmail());
        builder.memberName(((Member)o).getName());
      }
      else if(cls == Board.class) {
        containBoard = true;
        Board b = (Board)o;
        builder.bno(b.getBno());
        builder.title(b.getTitle());
        builder.content(b.getContent());
        builder.regDate(b.getRegDate());
        builder.modDate(b.getModDate());
      }
    }
    return containBoard ? builder.build() : null;
  }
  Long register(BoardDto dto);

  BoardDto get(Long bno);

  void remove(Long bno);

  void modify(BoardDto dto);

  PageResultDto<BoardDto,Object[]> list(PageRequestDto dto);
}
