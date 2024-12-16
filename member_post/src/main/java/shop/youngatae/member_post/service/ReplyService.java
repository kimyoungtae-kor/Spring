package shop.youngatae.member_post.service;

import java.util.List;
import java.util.Map;
import shop.youngatae.member_post.dto.ReplyCri;
import shop.youngatae.member_post.vo.Reply;

public interface ReplyService {
	int write(Reply reply);
	int modify(Reply reply);
	int remove(Long rno);
	int removeAll(Long pno);
	Reply findBy(Long rno);
	
	Map<String, List<Reply>> selectList(Long pno,ReplyCri cri,Object writer);
}
