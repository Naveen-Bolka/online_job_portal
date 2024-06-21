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

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
  
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id=Integer.parseInt(req.getParameter("id"));
			String title=req.getParameter("title");
			String desc=req.getParameter("desc");
			String location=req.getParameter("location");
			String category=req.getParameter("category");
			String status=req.getParameter("status");
		
			
			Jobs job=new Jobs();
			job.setId(id);
			job.setTitle(title);
			job.setDescription(desc);
			job.setCategory(category);
			job.setLocation(location);
			job.setStatus(status);
			
			HttpSession session=req.getSession();
			JobDAO dao=new JobDAO(DBConnect.getCon());
			
			
			boolean f=dao.updateJob(job);
			 
			if(f) {
				session.setAttribute("succMsg","Job Updated Succesfully");
				resp.sendRedirect("view_jobs.jsp");
			}
			else {
				session.setAttribute("succMsg", "something went worng on server");
				resp.sendRedirect("view_jobs.jsp");
			}
			
			
		} catch (Exception e) {
		   e.printStackTrace();
		}
	}
	

}
