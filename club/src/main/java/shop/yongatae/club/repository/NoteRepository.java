package shop.yongatae.club.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import shop.yongatae.club.entity.Note;

public interface NoteRepository extends JpaRepository<Note,Long>{
  Note findByNum(Long num);
  
  List<Note> findByMemberMno(Long mno);

  List<Note> findByMemberEmail(String email);
  
 @Query("select n,count(distinct l) as likescnt,count(distinct a.uuid) as attachCnt from tbl_note n left join tbl_likes l on l.note.num = n.num left join tbl_attach a on a.note.num = n.num where n.member.email = :email group by n")
//  @Query(value = "select n.*,COUNT(DISTINCT l.note_num, l.member_mno) as likecount,COUNT(DISTINCT uuid) as attachcnt from tbl_note n \r\n" + //
//       "left join tbl_member m on m.mno = n.member_mno\r\n" + //
//       "left join tbl_attach a on a.note_num = n.num\r\n" + //
//       "left join tbl_likes l on l.note_num = n.num GROUP  BY  n.num;",nativeQuery = true)
 List<Object[]> findNote(@Param("email") String email);
 @Query("select n,count(distinct l) as likescnt,count(distinct a.uuid) as attachCnt from tbl_note n left join tbl_likes l on l.note.num = n.num left join tbl_attach a on a.note.num = n.num  group by n") 
 List<Object[]> findNotes();
}
