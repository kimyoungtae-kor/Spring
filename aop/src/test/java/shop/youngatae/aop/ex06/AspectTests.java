package shop.youngatae.aop.ex06;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AspectTests {
    @Autowired
    private MyBean bean;

    @Test
    public void testBean(){
        bean.run();
    }
}
