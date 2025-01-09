package shop.yongatae.club.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.ToString;

@MappedSuperclass
@EntityListeners(value = AuditingEntityListener.class)//메인 즉 어플리케이션 런돌리는곳에 연결해야함 @EnbleJpaAuditing
@Getter
@ToString
public class BaseEntity {
  @CreatedDate
  @Column(name = "regdate",updatable = false)
  private LocalDateTime regDate;
  @LastModifiedDate
  @Column(name = "moddate")
  private LocalDateTime modDate;
}
