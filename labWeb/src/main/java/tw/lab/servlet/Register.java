package tw.lab.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.lab.apis.MemberDB;

import java.io.IOException;

/*
	連接lab24.jsp、MemberDB.java
 */


@WebServlet("/Register")
public class Register extends HttpServlet {
	private MemberDB memberDB;
	
    public Register() {
    	try {
			memberDB = new MemberDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String account = request.getParameter("account");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		
//		帳號不重複
		if (!memberDB.isAccountExist(account)) {
//			新增成功跳轉到lab25.jsp頁面
			if (memberDB.addMember(account, passwd, name)) {
				response.sendRedirect("lab25.jsp");
//			新增失敗，跳轉到lab24.jsp錯誤類型1
			}else {
				response.sendRedirect("lab24.jsp?errType=1");
			}
			
//		帳號重複
		}else {
			response.sendRedirect("lab24.jsp?errType=2");
		}
		
		
	}

}
