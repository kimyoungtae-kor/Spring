package shop.youngatae.member_post.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import shop.youngatae.member_post.dao.PostDao;
import shop.youngatae.member_post.dto.Criteria;
import shop.youngatae.member_post.mapper.AttachMapper;
import shop.youngatae.member_post.mapper.MemberMapper;
import shop.youngatae.member_post.mapper.PostMapper;
import shop.youngatae.member_post.utils.MybatisInit;
import shop.youngatae.member_post.vo.Post;

public class PostServiceImpl implements PostService{
		private PostDao postDao = new PostDao();
		public static void main(String[] args) {
			new PostServiceImpl().write(Post.builder().title("제목").content("abcd").writer("dydxo4423").cno(2).build());
		}
	@Override
	public int write(Post post) {
		try(SqlSession session = MybatisInit.getInstance().sqlSessionFactory().openSession(true)){
			PostMapper mapper = session.getMapper(PostMapper.class);
			AttachMapper attachMapper = session.getMapper(AttachMapper.class);
			System.out.println(post);// null
			mapper.write(post);
			
			System.out.println(post);//not null
			post.getAttachs().forEach(a -> {
				a.setPno(post.getPno());
				attachMapper.insert(a);
			});
			
			
			return 0;
		}
	}

	@Override
	public int modify(Post post) {

		try(SqlSession session = MybatisInit.getInstance().sqlSessionFactory().openSession(true)){
			PostMapper mapper = session.getMapper(PostMapper.class);
			return mapper.update(post);
		}
	}

	@Override
	public int remove(Long pno) {

		try(SqlSession session = MybatisInit.getInstance().sqlSessionFactory().openSession(true)){
			PostMapper mapper = session.getMapper(PostMapper.class);
			AttachMapper attachMapper = session.getMapper(AttachMapper.class);
			attachMapper.delete(pno);
			return mapper.delete(pno);
		}
	}
	
	@Override
	public Post findBy(Long pno) {

		try(SqlSession session = MybatisInit.getInstance().sqlSessionFactory().openSession(true)){
			PostMapper mapper = session.getMapper(PostMapper.class);
			AttachMapper attachMapper = session.getMapper(AttachMapper.class);
			Post post = mapper.selectOne(pno);
			post.setAttachs(attachMapper.selectList(pno));
			
			return post;
		}
	}
	
	
	
	@Override
    public Post view(Long pno) {
        try(SqlSession session = MybatisInit.getInstance().sqlSessionFactory().openSession(true)) {
            PostMapper mapper = session.getMapper(PostMapper.class);
            AttachMapper attachMapper = session.getMapper(AttachMapper.class);
            mapper.increaseviewCount(pno);
            Post post = mapper.selectOne(pno);
            post.setAttachs(attachMapper.selectList(pno));
            return post;
        }
    }

	@Override
	public List<Post> list(Criteria cri) {

		try(SqlSession session = MybatisInit.getInstance().sqlSessionFactory().openSession(true)){
			PostMapper mapper = session.getMapper(PostMapper.class);
			return mapper.selectList(cri);
		}
	}

	@Override
	public int count(Criteria cri) {

		try(SqlSession session = MybatisInit.getInstance().sqlSessionFactory().openSession(true)){
			PostMapper mapper = session.getMapper(PostMapper.class);
			return mapper.getCount(cri);
		}
	}
	
	
}
