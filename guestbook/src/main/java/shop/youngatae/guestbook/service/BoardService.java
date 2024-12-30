package shop.youngatae.guestbook.service;

import java.time.LocalDateTime;
import java.util.Arrays;

import shop.youngatae.guestbook.domain.dto.BoardDto;
import shop.youngatae.guestbook.domain.entity.Board;
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
  default BoardDto toDto(Object[] arr){
    System.out.println(Arrays.toString(arr));
    if(arr == null) return null;
      BoardDto.BoardDtoBuilder builder = BoardDto.builder();
    for(Object o : arr){
      Class<?> cls = o.getClass();
      System.out.println(o);
      System.out.println(cls);
      if(cls == int.class || cls == Integer.class){
        builder.replyCnt(Integer.parseInt(o.toString()));
      }else if (cls == Member.class) {
        builder.memberEmail(((Member) o).getEmail());
        builder.memberName(((Member) o).getName());
      }
      else if (cls == Board.class) {
        Board b = (Board)o;
        builder.bno(b.getBno());
        builder.title(b.getTitle());
        builder.content(b.getContent());
        builder.regDate(b.getRegDate());
        builder.modDate(b.getModDate());
      }
    }
    // return BoardDto.builder().build();
    
    return builder.build();
    // .bno(.getBno())
    // .title(board.getTitle())
    // .content(board.getContent())
    // .memberEmail(board.getMember().getEmail())
    // .memberName(board.getMember().getName())
  }
  Long register(BoardDto dto);

  BoardDto get(Long bno);


}
