package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDAO;
import com.db.DBConnect;
import com.entity.User;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String em=req.getParameter("em");
			String ps=req.getParameter("ps");
			User u=new User();
			HttpSession session=req.getSession();
			
			if("naveen@gmail.com".equals(em) && "12345678".equals(ps)) {
				session.setAttribute("userobj",u);
				u.setRole("admin");
				resp.sendRedirect("admin.jsp");
				
			}else {
				
				UserDAO dao=new UserDAO(DBConnect.getCon());
				User user=dao.login(em, ps);
				
				if(user != null) {
					session.setAttribute("userobj", user);
					resp.sendRedirect("home.jsp");
					
				}
				else {
					session.setAttribute("succMsg", "Invalid Email & Password");
					resp.sendRedirect("login.jsp");
				}
			}			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
