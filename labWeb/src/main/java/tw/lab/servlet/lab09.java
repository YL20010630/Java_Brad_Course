package tw.lab.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
//	MultipartConfig 是為了讓 Servlet 支援檔案上傳
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
//	Part 代表單一個上傳檔案

import java.io.IOException;

/*
	上傳使用者選的檔案到指定資料夾中，
	檔案會加上使用者的 IP 當作檔名前綴

*/


@WebServlet("/lab09")

//	指定儲存路徑
//	location 是儲存上傳的暫存檔案的位置，實際存檔會用 part.write(...)

@MultipartConfig( location = "C:\\Users\\User\\eclipse-workspace\\BradWeb\\src\\main\\webapp\\upload")
public class lab09 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String urip = request.getRemoteAddr();
		try {
//			接收檔案
			Part part = request.getPart("upload");
//			Part：Servlet處理上傳檔案的物件
//			request.getPart("upload")：從表單中取得使用者上傳的檔案(欄位名是 "upload")

//			檔案資訊
//			getContentType()：取得檔案類型
			String type = part.getContentType();
//			getSize()：檔案大小
			long len = part.getSize();
//			getSubmittedFileName()：使用者原本上傳的檔名
			String fileName = part.getSubmittedFileName();

			System.out.println(type);
			System.out.println(len);
			System.out.println(urip + "_" + fileName);
			
//			實際儲存檔案的動作
			part.write(fileName);
		}catch(Exception e) {
			System.out.println(e);
			response.setContentType("text/html; charset=utf-8");
			response.getWriter().print("ERROR");
			response.flushBuffer();
		}
		
	}

}
