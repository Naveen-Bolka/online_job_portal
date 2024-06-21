<%@ page import="com.dao.JobDAO" %>
<%@ page import="com.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.db.DBConnect"%>
<%@ page import="com.entity.Jobs" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User: Home</title>
<%@include file="all_components/all_css.jsp" %>
</head>
<body style="background-color: #f0f1f2;">

      <c:if test="${empty userobj}">
           <c:redirect url="login.jsp" />
      </c:if>
      <c:if test="${not empty succMsg }">
           <h4 class="text-center text-success">${succMsg }</h4>
           <c:remove var="succMsg" />
      </c:if> 
     
    <%@include file="all_components/navbar.jsp" %>
     <div class="container">
          <div class="row">
                <div class="col-md-12">
                      <h5 class="text-center text-primary">All Jobs</h5>
                      
                     
                       
                      
                      <div class="card">
                           <div class="card-body">
                                <form class="form-inline" action="more_view.jsp" method="get">
                                       <div class="form-group col-md-5 mt-1">
                                            <h5>Location</h5>
                                       </div>
                                       
                                       <div class="form-group col-md-4 mt-1">
                                            <h5>Category</h5>
                                       </div>
                                        
                                       <div class="from-group col-md-5 ">
                                          <select name="loc" class="custom-select" id="inlineFormSelectPref">
                                             <option selected value="lo">Choose....</option>
                                             <option value="Odisha">Odisha</option>
                                             <option value="Jharkhand">Jharkhand</option>
                                             <option value="Gujurat">Gujurat</option>
                                             <option value="Bhubaneswar">Bhubaneswar</option>
                                             <option value="Delhi">Delhi</option>
                                             <option value="Banglore">Banglore</option>
                                             <option value="chennai">Chennai</option>
                                             <option value="Hyderabad">Hyderabad</option>
                                           </select>
                                       </div>
                                       
                                        <div class="form-group col-md-5">
                                           <select name="cat" class="custom-select" id="inlineFormSelectPref">
                                              <option selected value="ca">Choose....</option>
                                              <option value="IT">IT</option>
                                              <option value="Developer">Developer</option>
                                              <option value="Banking">Banking</option>
                                              <option value="Engineer">Engineer</option>
                                              <option value="Teacher">Teacher</option>
                                           </select>
                                        </div> 
                                        
                                        <button class="btn btn-success">Submit</button>
                                </form>
                           </div>
                      </div>
                      
                   <% 
                          JobDAO dao=new JobDAO(DBConnect.getCon());   
                           List <Jobs> list=dao.getAllJobsForUser();
                       
                           for(Jobs j:list){                      
                   %>
                  <div class="card mt-2">
                   <div class="card-body">
                       <div class="text-center text-primary">
                          <i class="far fa-clipboard fa-2x"></i>
                       </div>
                       
                       <h6><%=j.getTitle() %></h6>
                       
                       <% 
                            if (j.getDescription().length() > 0 && j.getDescription().length() < 120 ) { 
                       %>
                       <p><%=j.getDescription() %></p>
                       <% }
                          else 
                          {
                       %>
                       <p><%=j.getDescription().substring(0, 120)%>...</p>
                       <% } %>
                       
                       
                       
                       <br>
                       <div class="form-row">
                           <div class="form-group col-md-3">
                               <input type="text" class="form-control form-control-sm" value="Location:<%=j.getLocation() %>" readonly>
                           </div>
                           
                           <div class="form-group col-md-3">
                               <input type="text" class="form-control form-control-sm" value="Category:<%=j.getCategory() %>" readonly>
                           </div>
                           
                           <div class="form-group col-md-3">
                               <input type="text" class="form-control form-control-sm" value="Status:<%=j.getStatus() %>" readonly>
                           </div>
                       </div>
                       
                       <h6>Publish Date <%=j.getPdate().toString() %></h6>
                       <div class="text-center">
                           <a href="one_view.jsp?id=<%=j.getId()%>" class="btn btn-sm btn-success text-white">view more</a>
                       </div>
                   </div>
               </div>
               <%
                 }
               %>
                       
                       
                </div>
          </div>
     </div>    
</body>
</html>