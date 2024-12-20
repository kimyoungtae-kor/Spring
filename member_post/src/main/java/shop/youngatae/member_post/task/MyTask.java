package shop.youngatae.member_post.task;


import java.text.SimpleDateFormat;

import java.util.Date;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
@EnableScheduling
public class MyTask {
  //scheduled 가 지정된 메서드는 파라미터X,반환 X
  // @Scheduled(cron = "0 0 5 * * 4")
  // @Scheduled(cron = "0 0 0 * * *")
  //Async는 작업 멀티쓰레드 전작업이있어도 돌릴수있게함
  
  
  
  
  
  
  
  // @Async
  // @Scheduled(cron = "0/5 * * * * *")
  // // @Scheduled(cron = "8 0 0 * * *")
  // // @Scheduled(cron = "13 0 0 * * *")
  // public void printTime(){
  //   log.info(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS").format(new Date()));
  //   }
}
