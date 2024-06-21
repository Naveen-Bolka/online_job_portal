<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Profile</title>
<%@include file="all_components/all_css.jsp" %>
</head>
<body style="background-color: #f0f1f2;">
       <c:if test="${empty userobj }">
           <c:redirect url="login.jsp"></c:redirect>
       </c:if>
      
     <%@include file="all_components/navbar.jsp" %>
     <div class="container-fluid">
         <div class="row p-4">
             <div class="col-md-4 offset-md-4">
                <div class="card">
                   <div class="card-body">
                         <div class="text-center">
                              <i class="fa fa-user-plus fa-2x" aria-hidden="true"></i>
                           
                              <h5>Edit Profile</h5>
                         </div>
                         <form action="update_profile" method="post">
                            <input type="hidden" name="id" value="${userobj.id }"> 
                           <div class="form-group">
                              <label>Enter Fullname</label>
                              <input type="text" class="form-control" required="required" id="exampleIputName" aria-describedby="emailHelp" name="fn" value="${userobj.name }">
                           </div>
                           
                           
                           <div class="form-group">
                              <label>Enter Qualification</label>
                              <input type="text" class="form-control" required="required" id="exampleIputName" aria-describedby="emailHelp" name="qualification" value="${userobj.qualification }">                              
                           </div>
                           
                           
                           <div class="form-group">
                              <label>Enter Email</label>
                              <input type="email" class="form-control" required="required" id="exampleIputEmial" aria-describedby="emailHelp" name="em" value="${userobj.email }">
                           </div>
                           
                           
                           <div class="form-group">
                              <label for="exampleIputPassword">Enter Password</label>
                              <input type="password" class="form-control" required="required" id="exampleIputPassword"  name="ps" value="${userobj.password }"> 
                           </div>
                           
                           <button type=submit class="btn btn-primary badge-pill btn-block">Update</button>
                       </form>
                   </div>
                 </div>
             </div>
           </div>
      </div>            

</body>
</html>