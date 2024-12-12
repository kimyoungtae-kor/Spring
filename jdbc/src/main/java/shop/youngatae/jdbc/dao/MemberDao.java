package shop.youngatae.jdbc.dao;



import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import shop.youngatae.jdbc.vo.Member;

@Component
@AllArgsConstructor
public class MemberDao {
  private JdbcTemplate jdbcTemplate;

  public String getTime(){
    return jdbcTemplate.queryForObject("select now()", String.class);
  }

  public int register(Member member){
    return jdbcTemplate.update("insert into tbl_member (id,pwd,name) values(?,?,?)",
    member.getId(),member.getPw(),member.getName());
  }
}
