package shop.youngatae.di.service;

import java.util.List;

import shop.youngatae.di.vo.Post;

public interface PostService {
    default void write(Post post){
        
    };
    List<Post> list();
}
