package shop.youngatae.member_post.survlet.post;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import shop.youngatae.member_post.dto.Criteria;
import shop.youngatae.member_post.service.PostService;
import shop.youngatae.member_post.service.PostServiceImpl;
import shop.youngatae.member_post.utils.Commons;
import shop.youngatae.member_post.vo.Member;

@WebServlet("/post/remove")
public class Remove extends HttpServlet{

	private PostService service = new PostServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pnoStr = req.getParameter("pno");
		Object memberObj = req.getSession().getAttribute("member");
		Criteria cri = new Criteria(req);
		
		String redirectUrl = "list?" + cri.getQs2();
		
		if(pnoStr == null || memberObj == null) {
			Commons.printMsg("비정상적인 접근입니다",redirectUrl,resp);
			return;
		}
		Long pno = Long.valueOf(pnoStr);
		Member m = (Member) memberObj;
		if(!m.getId().equals(service.findBy(pno).getWriter()) ) {
			Commons.printMsg("본인이 작성한 글만 삭제할 수 있습니다",redirectUrl, resp);
			return;
		}
		service.remove(pno);
		
		

		
		
		resp.sendRedirect("list" + "?" + cri.getQs2());
		//오류메시지
		//이동할페이지
	}
}
