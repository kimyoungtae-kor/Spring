package shop.youngatae.guestbook.repository.search;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import shop.youngatae.guestbook.domain.entity.Board;

public interface SearchBoardRepository {
  public Board search1();

  Page<Object[]> searPage(String type,String keyword,Pageable pageable);
}
