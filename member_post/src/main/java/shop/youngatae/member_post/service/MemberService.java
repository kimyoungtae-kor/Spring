package shop.youngatae.member_post.service;

import java.util.List;

import shop.youngatae.member_post.vo.Member;

public interface MemberService {
	//회원 가입
	int register(Member member);
	
	//회원 단일조회
	Member findBy(String id);
	//로그인
	boolean login(String id,String pw);
	//회원 전제초회
	List<Member> list();
	
	//회원 삭제,탈퇴
	boolean remove(String id);
	
	//회원정보수정
	boolean modify(Member member);
	//회원 로그아웃
	boolean logout(String id);
	
}
