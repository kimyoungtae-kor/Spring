package shop.youngatae.guestbook.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import shop.youngatae.guestbook.domain.entity.Board;


public interface BoradRepository extends JpaRepository<Board,Long>{
  @Query("select b,m from tbl_board b left join member m where b.bno = :bno")
  Object getBoradWithMember(@Param("bno") Long bno);
  
  @Query("select b,r from tbl_board b left join tbl_reply r on b = r.board where bno = :bno")
  List<Object[]> getBoardWithReply(@Param("bno") Long bno);

  @Query(value = "select count(r),b,m from tbl_board b \r\n" + //
        "left join member m \r\n" + //
        "left join tbl_reply r  on b = r.board group by b"
  , countQuery = "select count(b) from tbl_board b")
  //반드시 테이블의 별칭을줘야한다
  //테이블의 게시글
  Page<Object[]> getBoardWithReplyCount(Pageable pageable);
  //재료 게시글 번호 bno
  //회원,게시글,댓글갯수
  
  // @Query(value = "select count(r),b,m from tbl_board b \r\n" + //
  //       "left join member m \r\n" + //
  //       "left join tbl_reply r  on b = r.board group by b having b = :bno"
  //       , countQuery = "select count(r) from tbl_reply r")
  @Query(value = "select count(r),b,m from tbl_board b \r\n" + //
  "left join member m \r\n" + //
  "left join tbl_reply r  on b = r.board \r\n"+ 
  "where b.bno = :bno\r\n"
  , countQuery = "select count(b) from tbl_board b")
  Object[] getBoardByBno(@Param("bno") Long bno);
  
}
