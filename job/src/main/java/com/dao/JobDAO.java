package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Jobs;

public class JobDAO {
   private Connection con;

   public JobDAO(Connection con) {
	     super();
	     this.con = con;
   }
   public boolean addJobs(Jobs job) {
	   boolean b=false;
	   
	   try {
           String sql="insert into job_portal(title,description,category,status,location) values(?,?,?,?,?)";		   
		   PreparedStatement pst=con.prepareStatement(sql);
		   pst.setString(1,job.getTitle());
		   pst.setString(2,job.getDescription());
		   pst.setString(3,job.getCategory());
		   pst.setString(4,job.getStatus());
		   pst.setString(5,job.getLocation());
		   
		   int i=pst.executeUpdate();
		   
		   if(i==1) {
			   b=true;
		}
	   }catch(Exception e) {
		   e.printStackTrace();
		   
	   }
	   return b;
   }
   
   public List<Jobs> getAllJobs(){
	   List<Jobs> list=new ArrayList<Jobs>();
	   Jobs j=null;
	   
	   try {
		   String sql="select * from job_portal order by id desc";
		   PreparedStatement pst=con.prepareStatement(sql);
		   ResultSet rs=pst.executeQuery();
		   
		   while(rs.next()) {
			   j=new Jobs();
			   
			   j.setId(rs.getInt(1));
			   j.setTitle(rs.getString(2));
			   j.setDescription(rs.getString(3));
			   j.setCategory(rs.getString(4));
			   j.setStatus(rs.getString(5));
			   j.setLocation(rs.getString(6));
			   j.setPdate(rs.getTimestamp(7)+"");
			   
			   list.add(j);		   }
	   }catch (Exception e) {
		e.printStackTrace();
	}
	   
	   return list;
   }
   
   public Jobs getJobById(int id){
	   Jobs j=null;
	   
	   try {
		   String sql="select * from job_portal where id=?";
		   PreparedStatement pst=con.prepareStatement(sql);
		   pst.setInt(1, id);
		   ResultSet rs=pst.executeQuery();
		   
		   while(rs.next()) {
			   j=new Jobs();
			   
			   j.setId(rs.getInt(1));
			   j.setTitle(rs.getString(2));
			   j.setDescription(rs.getString(3));
			   j.setCategory(rs.getString(4));
			   j.setStatus(rs.getString(5));
			   j.setLocation(rs.getString(6));
		       j.setPdate(rs.getTimestamp(7)+"");
           }
	   }catch (Exception e) {
		e.printStackTrace();
	}
	   return j;
   }
   
   public boolean updateJob(Jobs job) {
	   boolean f=false;
	   
	   try {
		   String sql="update job_portal set title=?,description=?,category=?,status=?,location=? where id=?";
		   PreparedStatement pst=con.prepareStatement(sql);
		   
		   pst.setString(1,job.getTitle());
		   pst.setString(2,job.getDescription());
		   pst.setString(3,job.getCategory());
		   pst.setString(4,job.getStatus());
		   pst.setString(5,job.getLocation());
		   
		   pst.setInt(6,job.getId());
		   
          int i=pst.executeUpdate();
		   
		   if(i==1) {
			   f=true;
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	   return f;
   }
   
   public boolean deleteJobs(int id) {
	   boolean f=false;
	   try {
		   String sql="DELETE FROM job_portal WHERE id = ?";
		   PreparedStatement pst=con.prepareStatement(sql);
		   pst.setInt(1, id);
		   int i=pst.executeUpdate();
		   
		   if(i==1)
			   f=true;
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	   return f;
   }
   
   
   public List<Jobs> getAllJobsForUser(){
	   List<Jobs> list=new ArrayList<Jobs>();
	   Jobs j=null;
	   
	   try {
		   String sql="select * from job_portal where status=? order by id desc";
		   PreparedStatement pst=con.prepareStatement(sql);
		   pst.setString(1,"Active");
		   		   
		   ResultSet rs=pst.executeQuery();
		   
		   while(rs.next()) {
			   j=new Jobs();
			   
			   j.setId(rs.getInt(1));
			   j.setTitle(rs.getString(2));
			   j.setDescription(rs.getString(3));
			   j.setCategory(rs.getString(4));
			   j.setStatus(rs.getString(5));
			   j.setLocation(rs.getString(6));
			   j.setPdate(rs.getTimestamp(7)+"");
			   
			   list.add(j);		   }
	   }catch (Exception e) {
		e.printStackTrace();
	}
	   
	   return list;
   }
   
   public List<Jobs> getJobsORLocationAndCate(String cat,String loc){
	   
	   List<Jobs> list=new ArrayList<>();
	   
	   Jobs j=null;
	   
	   try {
		   
		   String sql="select * from job_portal where category=? or location=? order by id DESC";
		   PreparedStatement pst=con.prepareStatement(sql);
		   
		   pst.setString(1, cat);
		   pst.setString(2, loc);

		   ResultSet rs=pst.executeQuery();
		   
		   while(rs.next()) {
			   j=new Jobs();
			   
			   j.setId(rs.getInt(1));
			   j.setTitle(rs.getString(2));
			   j.setDescription(rs.getString(3));
			   j.setCategory(rs.getString(4));
			   j.setStatus(rs.getString(5));
			   j.setLocation(rs.getString(6));
			   j.setPdate(rs.getTimestamp(7)+"");
			   
			   list.add(j);
		   }
	} catch (Exception e) {
		e.printStackTrace();
	}
	   return list;
	   
   }
   
   
public List<Jobs> getJobsAndLocationAndCate(String cat,String loc){
	   
	   List<Jobs> list=new ArrayList<>();
	   
	   Jobs j=null;
	   
	   try {
		   
		   String sql="select * from job_portal where category=? or location=? order by id DESC";
		   PreparedStatement pst=con.prepareStatement(sql);
		   
		   pst.setString(1, cat);
		   pst.setString(2, loc);

		   ResultSet rs=pst.executeQuery();
		   
		   while(rs.next()) {
			   j=new Jobs();
			   
			   j.setId(rs.getInt(1));
			   j.setTitle(rs.getString(2));
			   j.setDescription(rs.getString(3));
			   j.setCategory(rs.getString(4));
			   j.setStatus(rs.getString(5));
			   j.setLocation(rs.getString(6));
			   j.setPdate(rs.getTimestamp(7)+"");
			   
			   list.add(j);
		   }
	} catch (Exception e) {
		e.printStackTrace();
	}
	   return list;
	   
   }

}
