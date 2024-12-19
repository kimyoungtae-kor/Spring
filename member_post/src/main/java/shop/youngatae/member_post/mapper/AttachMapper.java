package shop.youngatae.member_post.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import shop.youngatae.member_post.vo.Attach;

@Mapper
public interface AttachMapper {
	@Insert("insert into tbl_attach values(#{uuid},#{origin},#{path},#{image},#{pno})")
	int insert(Attach attach);
	
	
	@Select("SELECT * FROM tbl_attach where pno = #{pno}")
	List<Attach> selectList(Long pno);
	
	@Select("SELECT * FROM tbl_attach where path = #{path}")
	List<Attach> selectListByPath(String path);
	
	@Delete("DELETE FROM tbl_attach Where pno = #{pno}")
	int delete(Long pno);
}
