package web.booking.service;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/captcha")
public class BookingCaptcha extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BookingCaptcha() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpeg");
		
		String password = String.valueOf((int)(Math.random()*(10000-999))+1000);

		ImageIO.write(
                getPasswordImage(password), 
                "JPG", 
                response.getOutputStream()
            );
	}
	
	public BufferedImage getPasswordImage(String password) {

		BufferedImage bufferedImage = new BufferedImage(60, 25, BufferedImage.TYPE_INT_RGB);
		Graphics graphics = bufferedImage.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.drawString(password, 10, 15);

		return bufferedImage;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
