package tw.lab.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
	刻意展示了 Servlet 的整個生命週期與 service() 方法的行為差異
	Servlet 的運作順序：建構式 -> 初始化 -> 接收請求

*/


@WebServlet("/lab08")
public class lab08 extends HttpServlet {
//	先建構式
//	只在第一次有人請求/Brad08(建立實例)時會呼叫(只有一次)
	public lab08() {
		System.out.println("Brad08()");
	}
	
//	再初始化
//	當Servlet被建立後，會呼叫這裡
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init(ServletConfig)");
//		幫忙把 ServletConfig 存起來，讓 getServletConfig() 有東西用
		super.init(config);	// 呼叫父類別的init方法(初始化邏輯)
	}

//	最後接受請求
	@Override
//	HttpServlet 會將它轉型成 HttpServletRequest/Response 然後交給下一層
//	每次有請求來（不論 GET/POST）都會從這裡先進入
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("service(ServletRequest,ServletResponse)");
//		透過 instanceof 檢查是否是 HTTP 請求(通常都是)，就會是 HttpServletRequest
		if (request instanceof HttpServletRequest) {
			System.out.println("Y");
		}else {
			System.out.println("N");
		}
//		最後呼叫 super.service()，才會往下轉型到 service(HttpServletRequest, HttpServletResponse)
		super.service(request, response);
	}
	
//	這裡覆寫了 HttpServlet 專用的 service()
//	HTTP版本，會依照 GET / POST 轉交給 doGet() / doPost()
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service(HttpServletRequest,HttpServletResponse)");

//		呼叫父類別的 service(...) 方法，讓它繼續幫我們「自動分流」到 doGet() 或 doPost()
		//super.service(arg0, arg1);
		
//		method：請求方式（GET、POST、PUT、DELETE...）
		String method =  request.getMethod();
		System.out.println(method);
		if (method.equals("POST")) {
			
		}
		
	}

//	簡化版init
	@Override
	public void init() throws ServletException {
		System.out.println("init()");
		super.init();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()");
	}
}
