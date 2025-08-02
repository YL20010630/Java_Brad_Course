package tw.lab.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.util.Collection;


@WebServlet("/lab10")
@MultipartConfig( location = "C:\\Users\\User\\eclipse-workspace\\lebWeb3\\src\\main\\webapp\\upload")
public class lab10 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String account = request.getParameter("account");
		
//		因為 name="upload" 都一樣，會對應到 Servlet 裡的 getParts()，每個都是一個 Part
		Collection<Part> parts =  request.getParts();
		int i = 1;
		for (Part part : parts) {
			String name = part.getName();		// 欄位名稱
			String type = part.getContentType();		// 檔案類型，如：png、pdf
			long len =  part.getSize();
			System.out.printf("%s, %s, %d\n", name, type, len);
			
			if (name.equals("upload") && len > 0) {
				part.write(String.format("%s_%d_%s", account, i++, part.getSubmittedFileName()));
//				檔名格式為：[account]_[檔案編號]_[原始檔名]
//				例如：brad_1_photo.jpg
			}
			
		}
	
	
	}
	
}
