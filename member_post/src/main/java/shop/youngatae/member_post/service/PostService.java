package shop.youngatae.member_post.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import shop.youngatae.member_post.dto.Criteria;
import shop.youngatae.member_post.vo.Post;


public interface PostService {
	
	int write(Post post);
	
	int modify(Post post);
	
	int remove(Long pno);
	
	Post findBy(Long pno);
	
	Post view(Long pno);
	
	List<Post> list(Criteria cri);
	
	int count(Criteria cri);
	
	
}
