package shop.youngatae.member_post.vo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@Alias("attach")
public class Attach {
	private String uuid;
	private String origin;
	private String path;
	private boolean image;
	private Long pno;
}
