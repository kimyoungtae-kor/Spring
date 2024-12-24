package shop.youngatae.guestbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import com.querydsl.jpa.impl.JPAQueryFactory;

import shop.youngatae.guestbook.domain.entity.GuestbookEntity;

public interface GuestbookRepository extends JpaRepository<GuestbookEntity,Long>{
  // @Modifying
  // @Query("update tbl_guestbook t set t.content = content where t.gno= :gno")
  // int updateGuestById(Long gno,String content);
}
