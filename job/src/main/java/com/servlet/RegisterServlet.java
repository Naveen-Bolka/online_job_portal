package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.User;

import com.dao.UserDAO;
import com.db.DBConnect;

@WebServlet("/add_user") 
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			String name=req.getParameter("fn");
			String qua=req.getParameter("qualification");
			String email=req.getParameter("em");
			String ps=req.getParameter("ps");
			
			UserDAO dao=new UserDAO(DBConnect.getCon()) ;
			
			User u=new User();
			u.setName(name);
			u.setQualification(qua);
			u.setEmail(email);
			u.setPassword(ps);
			
			
			boolean f=dao.addUSer(u);
			HttpSession session=req.getSession();
			
			if(f) {
				session.setAttribute("succMsg", "Registraion successfully");
				resp.sendRedirect("login.jsp");				
			}else {
				session.setAttribute("succMsg", "Something wrong server");
				resp.sendRedirect("login.jsp");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
		

}
