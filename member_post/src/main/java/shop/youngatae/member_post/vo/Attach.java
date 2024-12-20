package shop.youngatae.member_post.vo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;

import java.util.UUID;

import org.apache.ibatis.type.Alias;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnailator;
import shop.youngatae.member_post.utils.Commons;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "uuid")
@Builder
@AllArgsConstructor
@Alias("attach")
@Log4j2
@NoArgsConstructor
public class Attach {
	private String uuid;
	private String origin;
	private String path;
	private boolean image;
	private Long pno;
	@Value("${upload.path}")
	private static String UPLOAD_PATH = "c:/upload";
	public Attach(MultipartFile file){
		this.origin = file.getOriginalFilename();
		int dotIdx = origin.lastIndexOf(".");
		String ext = "";
		if(dotIdx != -1) {
			ext = origin.substring(dotIdx);
		}
		log.info(UPLOAD_PATH);

		uuid = UUID.randomUUID().toString();
		String realName = uuid = uuid + ext;
		path = getTodayStr();
		File parentPath= new File(Commons.UPLOAD_PATH, path);
		if(!parentPath.exists()) {
			parentPath.mkdirs();
		}
		try {
			File f = new File(parentPath,realName);
			Files.probeContentType(f.toPath());
			file.transferTo(f);
			String mime = Files.probeContentType(f.toPath());
			image = mime !=null && mime.startsWith("image");
			//Thumbnailator
			//new
			if(image){
				File thumb = new File(parentPath,"t_"+realName);
				Thumbnailator.createThumbnail(f, thumb,100, 100);
			}
			
	} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
}
	public File toFile(){
		return new File(new File(UPLOAD_PATH,path),uuid);
	}
	public String getTodayStr() {
    return new SimpleDateFormat("yyyy/MM/dd").format(System.currentTimeMillis());
  }
	public static Attach fromFile(File file){
		
		return Attach.builder().uuid(file.getName()).build();
	}
	//위에 어노테이션 equls랑똑같은 하드코딩
	@Override
	public boolean equals(Object obj){
		return obj != null && obj instanceof Attach && uuid.equals(((Attach)obj).uuid);
	}
	//확인하는목적으로만쓰임
	@Override
	public int hashCode(){
		return uuid.hashCode();
	}
	
}
