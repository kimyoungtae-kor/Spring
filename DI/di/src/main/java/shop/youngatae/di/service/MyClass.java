package shop.youngatae.di.service;

import java.util.stream.Stream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import shop.youngatae.di.vo.Post;

@Configuration
public class MyClass {
    
    
    @Bean(name = "PostServiceImplnotice")
    public PostService postService(){
        return () -> Stream.of(Post.builder().pno(7L).title("익명").build()).toList();
    };
}
