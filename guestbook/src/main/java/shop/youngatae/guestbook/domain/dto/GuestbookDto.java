package shop.youngatae.guestbook.domain.dto;


import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GuestbookDto {
  private Long gno;
  private String title, content,writer;
  private LocalDateTime regDate,modDate;  
}
