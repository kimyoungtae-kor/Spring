package shop.youngatae.member_post.vo;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;


@Data
@Alias("member")
public class Member {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String roadAddr;
	private String detailAddr;
	private Date regdate;
	
	public static M builder() {
		return new M();
	}
	
	public Member() {
		
	}
	private Member( String id,String pwd,String name,String email,String roadAddr,String detailAddr,Date regdate) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.roadAddr = roadAddr;
		this.detailAddr = detailAddr;
		this.regdate = regdate;
	}
	
	public int getNum() {
		return 10;
	}
	public static class M {
		 String id;
		 String pwd;
		 String name;
		 String email;
		 String roadAddr;
		 String detailAddr;
		 Date regdate;
		 
		 public Member build() {
			 return new Member(id,pwd,name,email,roadAddr,detailAddr,regdate);
		 }
		public M id(String id) {
			this.id = id;
			return this;
		}
		public M pw(String pw) {
			this.pwd = pw;
			return this;
		}
		public M name(String name) {
			this.name = name;
			return this;
		}
		public M email(String email) {
			this.email = email;
			return this;
		}
		public M roadAddr(String roadAddr) {
			this.roadAddr = roadAddr;
			return this;
		}
		public M detailAddr(String detailAddr) {
			this.detailAddr = detailAddr;
			return this;
		}
		public M regdate(Date regdate) {
			this.regdate = regdate;
			return this;
		}
			
		
	}
	
	
	
}
