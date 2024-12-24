package shop.youngatae.guestbook.domain.dto;

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
public class GuestbookWriteDto {
  private Long gno;//게시글번호
  private String title;
  private String content;
  private String writer;


  public GuestbookEntity toEntity(){
    return GuestbookEntity.builder()
    .title(title)
    .content(content)
    .writer(writer)
    .build();
  }
}
