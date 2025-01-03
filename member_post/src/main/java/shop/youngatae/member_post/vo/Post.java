package shop.youngatae.member_post.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;


@Data
@Alias("post")
public class Post {
	private  Long pno;
	private  String title;
	private  String writer;
	private  String content;
	private  Long viewCount;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private  Date regdate;
	private  Date updatedate;
	private  Integer cno;
	private  boolean attachFlag;

	private List<Attach> attachs = new ArrayList<>(); //얘는 파이널 붙이면 안됨 셋터 써야함 대조해야함
}
