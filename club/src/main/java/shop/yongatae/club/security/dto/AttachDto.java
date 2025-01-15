package shop.yongatae.club.security.dto;

import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import shop.yongatae.club.entity.Note;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AttachDto {
  private Long num;
  private String uuid;
  private boolean image;
  private String origin;
  private String path;
  private Note note;
}
