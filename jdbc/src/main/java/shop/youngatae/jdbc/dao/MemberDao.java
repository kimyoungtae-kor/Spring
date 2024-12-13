package shop.youngatae.jdbc.dao;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;



import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
  // select
  public List<?> selectList() {
    return jdbcTemplate.query("select * from tbl_member",new MyMapper());
  }

  // select
  public Member selectOne(String id){
    return jdbcTemplate.queryForObject("select * from tbl_member where id = ?", new MyMapper(),id);
    
  }
 //update
 public int modify(Member member) {
  return jdbcTemplate.update("update tbl_member set pwd = ?, name= ?, email= ?, road_addr = ?, detail_addr = ?, regdate = now()  where id = ?" , member.getPw(), member.getName(),member.getEmail(), member.getRoad_addr(), member.getDetail_addr(), member.getId());
  }
  //delete
  public int delete(String id){
    return jdbcTemplate.update("delete from tbl_member Where id = ?",id);
  }
  //중요!!
  class MyMapper implements RowMapper<Member> {
    @Override
    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
      return Member.builder()
          .id(rs.getString("id"))
          .pw(rs.getString("pwd"))
          .name(rs.getString("name"))
          .email(rs.getString("email"))
          .road_addr(rs.getString("road_addr"))
          .detail_addr(rs.getString("detail_addr"))
          // .regdate(LocalDateTime.ofInstant(rs.getDate("regdate").toInstant(),ZoneId.systemDefault()))
          .regdate(rs.getTimestamp("regdate").toLocalDateTime())
          .build();
    }

  }
}
