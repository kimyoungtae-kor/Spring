package shop.youngatae.member_post.servlet.common;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
@WebServlet({"/index"})
public class Index extends HttpServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/common/index.jsp").forward(req, res);
	}
	
}
