package shop.youngatae.member_post.mapper;

import org.apache.ibatis.annotations.Mapper;

import shop.youngatae.member_post.vo.Member;

@Mapper
public interface MemberMapper {
	 public int insert(Member member);
	 
	 public Member selectOne(String id);
	 
}
