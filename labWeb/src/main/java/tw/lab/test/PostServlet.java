package tw.lab.test;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;


@WebServlet("/Post")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		從 request 中取得留言表單資料
		String username = request.getParameter("username");		
// 		錯誤，getAttribute() 是伺服器端傳遞資料用的，拿表單的輸入資料應用 getParameter()
		String message = request.getParameter("message");
		
//		建立留言物件
		Post post = new Post(username, message);		// 錯誤，new不要再寫型別
		
//		想把留言存在 application 作用域，應該這樣寫
//		創立公共作用域application，儲存所有使用者共用的公共資料，例如留言牆
		ServletContext application = getServletContext();
		
//		創立私人作用域session，儲存使用者個人的狀態或資料，例如登入或私人訊息
		HttpSession session = request.getSession();
		
		
//		取得留言清單
		ArrayList<Post> postList = application.getAttribute(post);
		session.getAttribute();
		ArrayList<Post>postList = new ArrayList<>();
		postList.add(post);
		
//		跳轉到主葉面
		response.sendRedirect("index.jsp");
		
		
		
	}

}
