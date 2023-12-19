import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/servlet2")
public class Servlet2 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		Cookie[] cookies = req.getCookies();
		
		boolean f = false;
		String name = "";
		
		if(cookies == null) {
			out.println("<h1>You are a new user, go to home page and submit your name.</h1>");
			return;
		}else {
			for(Cookie cookie: cookies) {
				if(cookie.getName().equals("name")) {
					f = true;
					
					name = cookie.getValue();
				}
			}
		}
		
		if(f) {
			out.println("<h1>Hello, " + name + " welcome back my website...</h1>");
			out.println("<h2>Thank you</h2>");
		}

	}
}
