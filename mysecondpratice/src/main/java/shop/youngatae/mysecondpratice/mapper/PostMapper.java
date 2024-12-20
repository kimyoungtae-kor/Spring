package shop.youngatae.mysecondpratice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shop.youngatae.mysecondpratice.vo.Post;

@Mapper
public interface PostMapper {
    List<Post> findAll();

}
