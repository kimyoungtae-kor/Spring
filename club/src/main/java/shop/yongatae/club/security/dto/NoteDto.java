package shop.yongatae.club.security.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder.Default;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NoteDto {
  private Long num;
  private String title;
  private String content;
  private String writer;
  private Long mno;
  private LocalDateTime regDate,modDate;

  private long likesCnt;
  private long attachCnt;

  @Default
  private List<AttachDto> attachDtos = new ArrayList<>();
}
