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

@WebServlet("/update_profile")
public class UpdateUserServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id=Integer.parseInt(req.getParameter("id"));
			String name=req.getParameter("fn");
			String qua=req.getParameter("qualification");
			String email=req.getParameter("em");
			String password=req.getParameter("ps");
		
			
			UserDAO dao=new UserDAO(DBConnect.getCon());
			
			User user=new User();
			user.setId(id);
			user.setName(name);
			user.setQualification(qua);
			user.setEmail(email);
			user.setPassword(password);
			
			
			boolean f=dao.updateUser(user);
			
			HttpSession session=req.getSession();
			
			if(f) {
				session.setAttribute("succMsg", "Profile updated successfully");
				resp.sendRedirect("home.jsp");
				
			}else {
				session.setAttribute("succMsg", "Something wrong on server");
				resp.sendRedirect("home.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
