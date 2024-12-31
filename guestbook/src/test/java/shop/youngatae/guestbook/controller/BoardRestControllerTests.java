package shop.youngatae.guestbook.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import jakarta.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import lombok.extern.log4j.Log4j2;

//@WebMvcTest()//클래스타입 예)BoardRestController.class 선언
@SpringBootTest
@AutoConfigureMockMvc
@Log4j2
public class BoardRestControllerTests {

  //mock : 프로토타입 으로 컨트롤러 테스트할때 필요함 @WEBMvcTest <<필요
  //MOckMVC 빌더패턴으로 생성하는게 첫번째 테스트루트 SpringBootTest 에노테이션으로 테스트를할려할때
  @Autowired
  private MockMvc mockMvc;
  // WebMvcTest() 를 선언했을때에는 빈만찾아와서 필요함
  // @BeforeEach
  // public void init(WebApplicationContext ctx){
  //   mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
  // };

  @Test
  public void testtest() throws Exception{
    // mockMvc.perform(get("/api/v1/board/test"));//import static으로 직접접근을함 .get까지선언해서 get만으로호출가능 
    mockMvc.perform(get("/api/v1/board/test"))
    .andExpect(status().isOk())
    .andExpect(content().string("test"));
    
  }

  @Test
  public void testList() throws Exception{
    mockMvc.perform(get("/api/v1/board/list")
    .param("page", "1")
    .param("size", "10")
    .param("type", "TC")
    .param("keyword", "8"))
    .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
  }
  
  @Test
  public void registertest() throws Exception{
    String jsonStr = ""+
            "{\r\n" + //
            "    \"content\" : \"sdsdupdatetest\",\r\n" + //
            "    \"memberEmail\" : \"5t@s.c\",\r\n" + //
            "    \"title\" : \"컨트롤러 테스트 등록제목\"\r\n" + //
            "}";    
    mockMvc.perform(post("/api/v1/board").content(jsonStr).contentType(MediaType.APPLICATION_JSON_VALUE))
    .andDo(print())
    .andExpect(status().isOk())
    .andExpect(content().string("success"));
  }
}
