package shop.youngatae.guestbook.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shop.youngatae.guestbook.domain.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member,String>{
  
}
