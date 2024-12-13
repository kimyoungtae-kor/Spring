package shop.youngatae.member_post.servlet.reply;

import java.io.IOException;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import shop.youngatae.member_post.dto.ReplyCri;
import shop.youngatae.member_post.service.ReplyService;
import shop.youngatae.member_post.service.ReplyServiceImpl;
import shop.youngatae.member_post.vo.Reply;

@WebServlet("/reply/*")
public class ReplyController extends HttpServlet{
	
	private ReplyService service = ReplyServiceImpl.getInstance();
	// private Gson gson = new GsonBuilder().setDateFormat("yyyy/MM/dd - HH:mm:ss").create();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		
		uri = uri.replace(req.getContextPath() + "/reply/", "");
		System.out.println(uri);
		Object ret = null;
		if(uri.startsWith("list")) {//목록조회
			// /reply/list/#{pno}
			ReplyCri cri = new ReplyCri();
			int tmpIdx = uri.indexOf("/");
			Long pno =  0L;
			if(tmpIdx != -1) {
				String tmp = uri.substring(tmpIdx+1);
				String[] tmpArr = tmp.split("/");
				System.out.println(Arrays.toString(tmpArr));

				switch(tmpArr.length) {
				
					
				case 3:
					cri.setAmount(Integer.parseInt(tmpArr[2]));
					break;
				case 2:
					cri.setLastRno(Long.parseLong(tmpArr[1]));
					break;
				case 1:
					pno = Long.valueOf(tmpArr[0]);
				default:
					break;
				}
				System.out.println(cri);
				
//				pno = Long.valueOf(uri.substring(tmpIdx+1));
			
			
			}
			ret = service.selectList(pno,cri,req.getSession().getAttribute("member"));
		}else {
			Long rno = Long.valueOf(uri);
			ret = service.findBy(rno);
		}
        resp.setContentType("application/json; charset=utf-8");
        // resp.getWriter().print(gson.toJson(ret));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		// service.write(gson.fromJson(req.getReader(), Reply.class));
	}

	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		char[] chs =new char[req.getContentLength()];
//		System.out.println(chs);
//		req.getReader().read(chs);
//		String str = new String(chs);
//		System.out.println(str);
		

		// Reply reply =  gson.fromJson(req.getReader(), Reply.class);
		// System.out.println(reply);
//		JsonNode node = mapper.readTree(str);
//        System.out.println(node);
		
		// service.modify(reply);
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		
		uri = uri.replace(req.getContextPath() + "/reply/", "");
		System.out.println(uri);
		if(uri.startsWith("delete")) {
			int tmpIdx = uri.lastIndexOf("/");
			Long pno =  0L;
			if(tmpIdx != -1) {
				pno = Long.valueOf(uri.substring(tmpIdx+1));
			}
			service.removeAll(pno);
		}else {
			Long rno = Long.valueOf(uri);
			service.remove(rno);
		}
	}
	
}
