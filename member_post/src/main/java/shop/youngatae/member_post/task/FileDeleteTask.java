package shop.youngatae.member_post.task;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import shop.youngatae.member_post.mapper.AttachMapper;
import shop.youngatae.member_post.vo.Attach;

@Component
@EnableScheduling
@Log4j2
@AllArgsConstructor
public class FileDeleteTask {
//@Autowired
  private AttachMapper mapper;
  @Scheduled(cron = "0 33 14 * * *")
  public void deleteFile(){
    String data = "2024/12/20";
     List<Attach> files = new ArrayList<>(Arrays.asList(new File("c:/upload",data).listFiles())
    .stream()
    .map(Attach::fromFile)
    .toList());

    

    List<Attach> dbs = new ArrayList<>(mapper.selectListByPath(data));
    List<Attach> thumbs = dbs.stream().filter(Attach::isImage).map(a-> Attach.builder().uuid("t_"+a.getUuid()).build()).toList();
    


    dbs.addAll(thumbs);

    files.removeAll(dbs);

    files.stream().peek(a -> a.setPath(data)).map(Attach::toFile)
    //.forEach(File::delete);
    .forEach((file) -> {file.delete();});
    
    log.info("=================================로그남기기 실행완료");
    log.info(files.size());

    //Stream
    //최종연산
    //forEach(consumer),Count(),Collect(Collect.toList())
    //중간연산 
    //filter(predicate),map(function),peek(consumer)
    //supplier
      log.info(() -> {return "sss";});
  }
  public void testBi(){
    Map<String, Integer> map = new HashMap<>();
    map.put("A",1);
    map.put("B",2);
    map.put("C",3);
    map.replaceAll((k,v) -> v * v);
    
    map.forEach((k,v) -> log.info((k + "::" + v)));
    map.forEach(log::info);
    };
  }
