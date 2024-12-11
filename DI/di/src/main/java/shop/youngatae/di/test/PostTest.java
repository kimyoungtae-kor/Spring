package shop.youngatae.di.test;


import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.log4j.Log4j2;
import shop.youngatae.di.service.PostService;
import shop.youngatae.di.service.PostServiceImplNormal;

@SpringBootApplication
@Log4j2
public class PostTest {
    // public static void main(String[] args) {
    //     SpringApplication application = new SpringApplication(PostTest.class);
    //     ConfiApplicationContext ctx = application.run(args);
    //     PostService service =ctx.getBean(PostServiceImplNormal.class);
    //     service.list().forEach(log::info);
    // }
}
