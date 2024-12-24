package shop.youngatae.guestbook.domain.dto;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import shop.youngatae.guestbook.domain.entity.GuestbookEntity;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GuestbookListDto {
  private Long gno;//게시글번호
  private String title;
  private String content;
  private String writer;
  private LocalDateTime regDate;
  private LocalDateTime modDate;

  public GuestbookListDto(GuestbookEntity entity){
    gno = entity.getGno();
    title = entity.getTitle();
    content = entity.getContent();
    writer = entity.getWriter();
    regDate = entity.getRegDate();
    modDate = entity.getModDate();
  } 
}
