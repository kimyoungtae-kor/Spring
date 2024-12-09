package shop.youngatae.demo.vo;

import java.lang.System.Logger.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

@Data
@Builder
// @Slf4j
// @Log4j2
@Component
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private String id;
    private String pw;
    private String name;


    private static final Logger logger = Logger.getLogger("shop.youngatae.demo.vo");
    private static final java.lang.System.Logger logger2 = System.getLogger("shop.youngatae.demo.vo");


    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger("shop.youngatae.demo.vo");
    public static void main(String[] args) {
        Member member = Member.builder().id("abcd").pw("1234").name("새똥이").build();
        System.out.println(member);

        logger.info(member.toString());
        logger2.log(Level.INFO, member);

        log.info(member);
    }
}
