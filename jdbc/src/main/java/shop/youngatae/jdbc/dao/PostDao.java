package shop.youngatae.jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class PostDao {
  private JdbcTemplate jdbcTemplate;

  public int updateToWriterNull(String id){
    return jdbcTemplate.update("update tbl_post set writer = null Where writer = ?", id);
  }
}
