package shop.youngatae.guestbook.domain.dto;


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
@NoArgsConstructor
@AllArgsConstructor
public class GuestbookModifyDto {
  private Long gno;//게시글번호
  private String title;
  private String content;
  private String writer;


  public Guestbook toEntity(){
    return Guestbook.builder()
    .gno(gno)
    .title(title)
    .content(content)
    .writer(writer)
    .build();
  }
}
