package shop.youngatae.mysecondpratice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.youngatae.mysecondpratice.mapper.PostMapper;
import shop.youngatae.mysecondpratice.vo.Post;

@Service
public class PostService {
    @Autowired
    private PostMapper mapper;

    public List<Post> getAllPosts() {
        return mapper.findAll();
    }
    
}