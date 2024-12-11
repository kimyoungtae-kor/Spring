package shop.youngatae.di.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import shop.youngatae.di.vo.Post;
//컨트롤 . 오버라이팅메서드
@Log4j2
@Service("gallery")
public class PostServiceImplGallery implements PostService{

    @Override
    public List<Post> list() {
        List<Post> list = new ArrayList<>();
        list.add(Post.builder().pno(3L).title("갤러리 게시판 제목").writer("작성자").build());
        list.add(Post.builder().pno(4L).title("갤러리 게시판 제목").writer("작성자").build());
        return list;
    }

    @Override
    public void write(Post post) {
        log.info(getClass().getSimpleName()+".write() call");
        
    }
}