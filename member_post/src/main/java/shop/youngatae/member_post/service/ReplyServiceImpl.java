package shop.youngatae.member_post.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import shop.youngatae.member_post.dto.ReplyCri;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.youngatae.member_post.mapper.MemberMapper;
import shop.youngatae.member_post.mapper.ReplyMapper;
import shop.youngatae.member_post.utils.MybatisInit;
import shop.youngatae.member_post.vo.Member;
import shop.youngatae.member_post.vo.Reply;


@Service
@AllArgsConstructor
public class ReplyServiceImpl implements ReplyService{
	private ReplyMapper mapper;
	// @Getter
	// private static ReplyService instance = new ReplyServiceImpl();
	@Override
	public int write(Reply reply) {
		return mapper.insert(reply);
	}

	@Override
	public int modify(Reply reply) {
		return mapper.update(reply);
	}

	@Override
	public int remove(Long rno) {
		return mapper.delete(rno);
	}

	@Override
	public int removeAll(Long pno) {
		return mapper.deleteAll(pno);
	}

	@Override
	public Reply findBy(Long rno) {
		return mapper.selectOne(rno);
	}

	@Override
	public Map<String,List<Reply>> selectList(Long pno,ReplyCri cri,Object writer) {
		
			Map<String,List<Reply>> map = new HashMap<>();
			map.put("list", mapper.selectList(pno, cri));
			
			if(writer != null) {
				Reply reply = new Reply();
				reply.setWriter(((Member)writer).getId());
				reply.setPno(pno);
				map.put("myList", mapper.selectListByMe(reply));	
			}
			
			return map;
		
	}
	
}
