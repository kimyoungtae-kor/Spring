package shop.youngatae.member_post.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import lombok.extern.log4j.Log4j2;
import shop.youngatae.member_post.vo.Attach;

@SpringBootTest
@Log4j2
public class AttachMapperTests {
  @Autowired
  private AttachMapper mapper;
  String data = "2024/12/20";
  @Test
  public void testSelectAttach(){

    

    List<Attach> list = mapper.selectListByPath("2024/12/19" );
    list.forEach(log::info);
    log.info("=================================");
    List<File> files = new ArrayList<>(Arrays.asList(new File("c:/upload",data).listFiles()));
    //
    files.forEach(log::info);
    List<File> list2 =list.stream().map(Attach::toFile).toList();
    list2.forEach(log::info);
    log.info(list2.size());

    log.info("========================");
    files.removeAll(list2);
    files.forEach(log::info);
    log.info(files.size());
  }
  @Test
  public void testConvert2Attach(){
    List<Attach> files = new ArrayList<>(Arrays.asList(new File("c:/upload",data).listFiles())
    .stream()
    .map(Attach::fromFile)
    .toList());
    files.forEach(log::info);
    
    log.info("==================================");
    List<Attach> dbs = new ArrayList<>(mapper.selectListByPath(data));
    List<Attach> thumbs = dbs.stream().filter(Attach::isImage).map(a-> Attach.builder().uuid("t_"+a.getUuid()).build()).toList();
    
    dbs.forEach(log::info);
    log.info(thumbs);
    log.info(thumbs.size());
    dbs.addAll(thumbs);
    log.info("==================================");
    files.removeAll(dbs);
    // files.forEach(log::info);
    log.info(files.size());

  }

  @Test
  @DisplayName("Attach 객체의 equals() 와 hashcode()의 재정의 확인용도")
  public void testAttachEqualsAndHashcode(){
      Attach attach1 = Attach.builder().uuid("1.jpg").build();
      Attach attach2 = Attach.builder().uuid("1.jpg").build();
      Attach attach3 = Attach.builder().uuid("2.jpg").build();
      Attach attach4 = attach1;


      log.info(attach1.equals(attach2));
      log.info(attach2.equals(attach3));
      log.info(attach3.equals(attach1));
      log.info("=============================================");
      assertTrue(attach1.equals(attach2));
      assertTrue(attach1.equals(attach4));
      log.info("=============================================");
      assertEquals(attach1, attach2);
      assertSame(attach1, attach4);
      log.info("=============================================");
      log.info(attach1.hashCode());
      log.info(attach2.hashCode());
      log.info(attach3.hashCode());
      log.info("=============================================");
      log.info(attach1.getUuid().hashCode());
      log.info("=============================================");
      Set<Attach> set = new HashSet<>(Stream.of(attach1,attach2,attach3,attach4).collect(Collectors.toSet()));
      
      set.add(attach1);
      set.add(attach2);
      set.add(attach3);
      set.add(attach4);
      
      log.info(set);
      log.info(set.size());
  }
}
