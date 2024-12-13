package shop.youngatae.jdbc.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;
import shop.youngatae.jdbc.vo.Member;

@SpringBootTest
@Log4j2
public class MemberDaoTests {
  @Autowired
  private MemberDao dao;
  
  @Test
  public void testGetTime(){
    log.info(dao.getTime());
  }

  @Test
  public void testRegister(){
    Member member = Member.builder().id("test001").pw("1234").name("스프링부트").build();
    dao.register(member);
  }
  

  @Test
  public void testOne(){
    log.info(dao.selectOne("dydxo4423"));
  }

  @SuppressWarnings({"unchecked","rawtypes"})
  @Test
  public void testList(){
      dao.selectList().forEach(log::info);

  //   dao.selectList().forEach(map -> {
  //   if(map instanceof Map){
  //     Object id = ((Map)map).get("id");
  //     if(id instanceof String){
  //       String idStr = (String)id;
  //     }
  //   }
  // });
  }
  //매우중요
  @Test
  public void testObject(){
    Object o = null;
    try{
      String s = (String)o;
      long l = Long.valueOf(s);
      log.info(l + 2000);
    }catch(ClassCastException e){
      log.info("cast 과정의 문제");
    }catch(NumberFormatException e){
      log.info("숫자 cas 과정의 문제");
    }
    
  }
  @Test
  public void testdelete(){
    log.info(dao.delete("dydxo4423456"));
  }
  @Test
  public void testUpdate(){
    Member member = dao.selectOne("test000");
    log.info(member);
    member.setRoad_addr("디지털로 306");
    member.setDetail_addr("2층 더조은 아카데미");
    member.setEmail("kyt1234@mioaw.com");
    int result = dao.modify(member);
    assertEquals(1, result);
    log.info(dao.selectOne("test000"));
  }
  //forgine key 들은 null값처리 update
  //회원은 delete 

}
