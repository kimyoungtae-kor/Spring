package shop.youngatae.guestbook.domain.dto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class PageRequestDto {
  private int page;
  private int size;
  private String type;
  private String keyword;
  
  public PageRequestDto(){
    page = 1;
    size = 10;
  }
  public Pageable getPageable(Sort sort){
    return PageRequest.of(page - 1, size,sort);
  }
}
