package shop.youngatae.chating.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@Document(collection = "student")
public class Student {

  @Id
  private Long no;
  private String name;
  private Integer score;
  
}
