package shop.youngatae.member_post.service;

import java.util.List;

import shop.youngatae.member_post.vo.Post;

public interface TestService {
	List<Post> list();
	
	Post findBy(Long pno);
	
	String now();
	
	int write(Post post);
}