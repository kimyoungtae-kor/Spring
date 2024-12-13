package shop.youngatae.member_post.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import shop.youngatae.member_post.mapper.MemberMapper;

import shop.youngatae.member_post.utils.MybatisInit;
import shop.youngatae.member_post.vo.Member;


@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService{
	private MemberMapper mapper;

	@Override
	public int register(Member member) {
		try(SqlSession session = MybatisInit.getInstance().sqlSessionFactory().openSession(true)){
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			return mapper.insert(member);
		}
	}

	@Override
	public Member findBy(String id) {
			return mapper.selectOne(id);
	}
	@Override
	public boolean login(String id, String pw) {
		Member m = findBy(id);
		return m != null && m.getPwd().equals(pw);
	}
	
	@Override
	public boolean logout(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Member> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modify(Member member) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
