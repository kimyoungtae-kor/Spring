package shop.yongatae.club.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import shop.yongatae.club.entity.Likes;
import shop.yongatae.club.entity.Member;
import shop.yongatae.club.entity.composite.LikesId;

public interface LikesRepository extends JpaRepository<Likes,LikesId>{

  // boolean findById();
  
}
