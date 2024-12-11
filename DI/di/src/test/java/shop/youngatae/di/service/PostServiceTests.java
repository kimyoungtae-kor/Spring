package shop.youngatae.di.service;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class PostServiceTests {
    @Autowired(required = false)
    @Qualifier(value = "PostServiceImplnotice")
    private PostService service;

    @Test
    public void testExist(){
        assertNotNull(service);
    }
    @Test
    public void testList(){
        service.list().forEach(log::info);
    }
}
