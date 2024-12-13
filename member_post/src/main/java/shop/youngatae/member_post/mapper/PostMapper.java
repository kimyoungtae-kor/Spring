package shop.youngatae.member_post.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import shop.youngatae.member_post.dto.Criteria;
import shop.youngatae.member_post.vo.Member;
import shop.youngatae.member_post.vo.Post;

public interface PostMapper {
	List<Post> selectList(Criteria cri);
	
	Post selectOne(Long pno);
	@Select("select now()")
	String now();
	
	int write(Post post);
	
	int  getCount(Criteria cri);

	int update(Post post);

	int increaseviewCount(Long pno);
	int delete(Long pno);

	List<Post> selectList();
}
