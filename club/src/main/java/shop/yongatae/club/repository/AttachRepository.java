package shop.yongatae.club.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import shop.yongatae.club.entity.Attach;

public interface AttachRepository extends JpaRepository<Attach,String>{
  List<Attach> findByNote_Num(Long noteNum);
  Attach findByUuid(String uuid);
  List<Attach> findByImageTrue();
  List<Attach> findByPath(String path);
}
