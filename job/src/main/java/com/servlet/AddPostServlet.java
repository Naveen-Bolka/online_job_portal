package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.JobDAO;
import com.db.DBConnect;
import com.entity.Jobs;

@WebServlet("/add_job")
public class AddPostServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String title=req.getParameter("title");
			String desc=req.getParameter("desc");
			String category=req.getParameter("category");
			String loctaion=req.getParameter("location");
			String status=req.getParameter("status");
			
			HttpSession session=req.getSession();
			
			Jobs job=new Jobs();
			job.setTitle(title);
			job.setCategory(category);
			job.setDescription(desc);
			job.setLocation(loctaion);
			job.setStatus(status);
		
			JobDAO dao=new JobDAO(DBConnect.getCon());
			boolean f=dao.addJobs(job);
			if(f) {
				session.setAttribute("succMsg","Job Posted Succesfully");
				resp.sendRedirect("add_job.jsp");
			}
			else {
				session.setAttribute("succMsg", "something went worng on server");
				resp.sendRedirect("add_job.jsp");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
   
}
