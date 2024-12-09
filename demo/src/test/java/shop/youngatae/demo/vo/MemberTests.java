package shop.youngatae.demo.vo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
// @Log4j2
public class MemberTests {

    // // private Member member = Member.builder().build();
    // Member m1 = new Member("abcd", "1234", "새똥이");
    // Member m2 = new Member("abcd", "1234", "새똥이");
    // @Test
    // public void testMember() {
    //     //given

        
    //     // Member.builder().id("abcd").pw("1234").name("새똥이").build();
    //     // Member m2 = Member.builder().id("abcd").pw("1234").name("새똥이").build();
    //     //when ~ then
        
    //     // log.info(String.format("%s@%X",m1.getClass().getName(),m1.hashCode()));
    //     // log.info(String.format("%s@%X",m2.getClass().getName(),m2.hashCode()));
        

    //     // assertNull(member.getId());
        
    //     // expect / assert
        
    //     assertEquals(m1, m2);
    //     System.out.println(m1.equals(m2));
    //     assertSame(m1, m2);
    // } 
    // @Autowired
    // @Qualifier("member")
    // private Member member;
    // @Test
    // public void testDI(){
    //     System.out.println(member);
    // }
}
