package tw.lab.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
//	ImageIO: 把圖片輸出成檔案或輸出串流

/*
	建立一張400*20的黃色圖片，將它轉成jpeg格式，回傳給前端(瀏覽器)顯示
 */


@WebServlet("/lab11")
public class lab11 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		從網址取得 rate 的數值，比如 lab11?rate=54.2
		double rate = 0;	// 50 => 50%
		try {
			String r = request.getParameter("rate");
//			把字串轉成 double 數值
			rate = Double.parseDouble(r);
		}catch(Exception e) {}
		
//		把畫好的圖當成圖片輸出給瀏覽器
		BufferedImage img = new BufferedImage(400, 20, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = img.createGraphics();		// 取得圖片的畫布（畫筆），可以在上面畫東西
		g2d.setColor(Color.YELLOW);
		g2d.fillRect(0, 0, 400, 20);

		g2d.setColor(Color.RED);
		g2d.fillRect(0, 0, (int)(400*rate/100), 20);

//		告訴瀏覽器這是一張 JPEG 圖片
		response.setContentType("image/jpeg");
//		把你畫好的圖片，直接輸出到瀏覽器
		ImageIO.write(img, "JPEG", response.getOutputStream());	
		response.flushBuffer();
		
	}


}
