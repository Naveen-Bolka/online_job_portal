<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>
<%@include file="all_components/all_css.jsp" %>
</head>
<body style="background-color: #f0f1f2;">
     <%@include file="all_components/navbar.jsp" %>
     <div class="container-fluid">
         <div class="row p-5">
             <div class="col-md-4 offset-md-4">
                <div class="card">
                   <div class="card-body">
                         <div class="text-center">
                           <i class="fa fa-user-plus fa-2x" aria-hidden="true"></i>
                           <h5>Login Page</h5>
                          </div>
                    <c:if test="${not empty succMsg }">
                          <h4 class="text-center text-danger">${succMsg }</h4>
                          <c:remove var="succMsg" />
                       </c:if>
                       <form action="loginServlet" method="post">
                           <div class="form-group">
                              <label>Enter Email</label>
                              <input type="email" class="form-control" required="required" id="exampleIputEmial" aria-describedby="emailHelp" name="em">
                           </div>
                           <div class="form-group">
                              <label for="exampleIputPassword">Enter Password</label>
                              <input type="password" class="form-control" required="required" id="exampleIputPassword"  name="ps"> 
                           </div>
                           
                           <button type=submit class="btn btn-primary badge-pill btn-block">Login</button>
                       </form>
                   </div>
                   </div>
                </div>
             </div>
         </div>
     </div>
</body>
</html>