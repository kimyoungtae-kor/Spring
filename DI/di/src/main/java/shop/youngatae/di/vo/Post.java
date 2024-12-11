package shop.youngatae.di.vo;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private Long pno;
    private String title;
    private String writer;
    private LocalDateTime regdate;
}
