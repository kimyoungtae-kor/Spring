package shop.youngatae.member_post.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import shop.youngatae.member_post.dto.Criteria;
import shop.youngatae.member_post.dto.ReplyCri;
import shop.youngatae.member_post.vo.Post;
import shop.youngatae.member_post.vo.Reply;

public interface ReplyMapper {
	int insert(Reply reply);
	int update(Reply reply);
	int delete(Long rno);
	int deleteAll(Long pno);
	
	
	Reply selectOne(Long rno);
	List<Reply> selectList(@Param("pno") Long pno, @Param("cri") ReplyCri cri);
	List<Reply> selectListByMe(Reply reply);
}
