package tw.lab.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;					// 畫布，拿來在圖片上畫圖或文字
import java.awt.geom.AffineTransform;		// 做旋轉、縮放等變形
import java.awt.image.BufferedImage;		// 圖片物件
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;				// 用來讀寫圖片檔案，把圖片輸出成檔案或輸出串流

/*
	在圖片上加上旋轉文字的範例
 */


@WebServlet("/lab12")
public class lab12 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String source = "C:\\Users\\皮\\eclipse-workspace\\labWeb3\\src\\main\\webapp\\upload\\圖片2.jpg";
		BufferedImage img = ImageIO.read(new File(source));
		
		if (img == null) {
		    System.out.println("圖片讀取失敗！");
		    response.getWriter().write("圖片讀取失敗！");
		    return;
		}
		
Graphics2D g2d = img.createGraphics();
		
		Font font = new Font(null, Font.BOLD, 300);
		
		AffineTransform transform = new AffineTransform();
		transform.rotate(Math.toRadians(-10));
		Font font2 = font.deriveFont(transform);
		
		g2d.setColor(Color.YELLOW);
		g2d.setFont(font2);
		g2d.drawString("Hello, World, lab12.java", 100, 300);		// 100, 300是座標
		
//		把圖片直接輸出到瀏覽器，(前端看起來會像是圖片)
		response.setContentType("image/jpeg");
		ImageIO.write(img, "JPEG", response.getOutputStream());
		response.flushBuffer();
		
//		覆蓋原來的圖片檔案，把加了文字的新圖片儲存起來
		ImageIO.write(img, "JPEG", new File("C:\\Users\\皮\\eclipse-workspace\\labWeb3\\src\\main\\webapp\\upload\\圖片2.jpg"));
		
		
	}

}
