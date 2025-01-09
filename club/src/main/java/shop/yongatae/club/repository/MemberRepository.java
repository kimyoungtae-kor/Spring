package shop.yongatae.club.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import shop.yongatae.club.entity.Member;
import java.util.List;


public interface MemberRepository extends JpaRepository<Member,Long>{
  Member findByEmail(String email);

  Member findByEmailAndFromSocial(String email, boolean fromSocial);
}
