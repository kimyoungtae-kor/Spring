package shop.youngatae.member_post.survlet.post;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import shop.youngatae.member_post.dto.Criteria;
import shop.youngatae.member_post.service.PostService;
import shop.youngatae.member_post.service.PostServiceImpl;
@WebServlet("/post/view")
public class View extends HttpServlet{
	private PostService service = new PostServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Criteria cri = new Criteria(req);
		
		
		
		String pnoString = req.getParameter("pno");
		Long bno = pnoString == null ? 1L : Long.valueOf(pnoString);
		
		
		
		
		req.setAttribute("post", service.view(bno));
		req.setAttribute("cri", cri);
		req.getRequestDispatcher("/WEB-INF/jsp/post/view.jsp").forward(req, resp);
	}
	
}
