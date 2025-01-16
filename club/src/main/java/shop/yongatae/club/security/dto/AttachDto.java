package shop.yongatae.club.security.dto;

import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import shop.yongatae.club.entity.Note;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AttachDto {
  private String uuid;
  private boolean image;
  private String origin;
  private String path;

  private long size;
  private String mime;
  private String fileName;
  private String ext;
  private String url;

  private Long num;//noteNum
}
