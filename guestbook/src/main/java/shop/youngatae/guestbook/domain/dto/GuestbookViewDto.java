package shop.youngatae.guestbook.domain.dto;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import shop.youngatae.guestbook.domain.entity.Guestbook;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GuestbookViewDto {
  private Long gno;//게시글번호
  private String title;
  private String content;
  private String writer;
  private LocalDateTime regDate;
  private LocalDateTime modDate;
  
  public GuestbookViewDto(Guestbook entity){
    gno = entity.getGno();
    title = entity.getTitle();
    content = entity.getContent();
    writer = entity.getWriter();
    regDate = entity.getRegDate();
    modDate = entity.getModDate();
  } 
  // public GuestbookEntity guestEntity(){
  //   return GuestbookEntity.builder()
  //   .gno(gno)
  //   .title(title)
  //   .writer(writer)
  //   .build();
  // }
}
