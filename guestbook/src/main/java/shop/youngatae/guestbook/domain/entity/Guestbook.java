package shop.youngatae.guestbook.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Table(name = "tbl_guestbook")
@Setter
//setter를 안넣으면 final 선언안해도된다
public class Guestbook extends BaseEntity{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)//strategy : 전략
  private Long gno;//게시글번호
  @Column(nullable = false,length = 100)
  private String title;
  @Column(nullable = false,length = 1500)
  private String content;
  @Column(nullable = false,length = 50)
  private String writer;  
}
