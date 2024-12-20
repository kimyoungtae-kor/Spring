package shop.youngatae.mysecondpratice.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;


import lombok.Builder;
import lombok.Data;


@Data
@Builder
// @Slf4j
// @Log4j2
@Component
public class Post {
    private Long id;
    private String title;
    private String content;
    private String author;
    private Date createdAt;
}
