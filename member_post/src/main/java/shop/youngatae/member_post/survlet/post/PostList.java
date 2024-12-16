// package shop.youngatae.member_post.survlet.post;


// import java.io.IOException;

// import jakarta.servlet.ServletException;
// import jakarta.servlet.annotation.WebServlet;
// import jakarta.servlet.http.HttpServlet;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// import shop.youngatae.member_post.dto.Criteria;
// import shop.youngatae.member_post.dto.PageDto;
// import shop.youngatae.member_post.service.PostService;
// import shop.youngatae.member_post.service.PostServiceImpl;

// @WebServlet("/post/list")
// public class PostList extends HttpServlet{
// 	private PostService service = new PostServiceImpl();
// 	@Override
// 	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

// 		Criteria cri = new Criteria(req);
// 		System.out.println(cri);
// 		req.setAttribute("posts", service.list(cri));
// 		req.setAttribute("pageDto", new PageDto(cri,service.count(cri)));
//         req.getRequestDispatcher("/WEB-INF/jsp/post/list.jsp").forward(req, resp);
// 	}
// }
