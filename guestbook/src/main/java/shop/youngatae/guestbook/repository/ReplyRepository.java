package shop.youngatae.guestbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shop.youngatae.guestbook.domain.entity.Reply;

@Repository
public interface ReplyRepository extends JpaRepository<Reply,Long>{
  void deleteByBoardBno(Long bno);
}
