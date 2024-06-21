<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="all_css.jsp" %>
 <nav class="navbar navbar-expand-lg bg-body-tertiary bg-custom navbar-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">JOB PORTAL</a>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="home.jsp">Home</a>
          <span class="sr-only">(current)</span>
        </li>
         <c:if test="${userobj.role eq 'admin'}">
              <li class="nav-item">
                 <a class="nav-link" href="add_job.jsp"><i class="fa fa-plus-circle"></i> Post Job</a>
              </li>
              <li class="nav-item">
                  <a class="nav-link" href="view_jobs.jsp"><i class="fas fa-eye"></i> View Job</a>
              </li>
        </c:if>   
      </ul>
    </div>
    <div>
         <form class="d-flex ml-4" >
         
            
            <c:if test="${userobj.role eq 'admin' }" >
                 <a href="#" class="btn btn-light mr-1"><i class="fas fa-user"></i> Admin</a>
                  <a href="logout" class="btn btn-light mr-1"><i class="fas fa-user"></i> Logout</a>
            </c:if>  
            <c:if test="${userobj.role eq 'user' }" >
                 <a  class="btn btn-light mr-1" data-bs-toggle="modal" data-bs-target="#exampleModal"><i class="fas fa-user"></i>${userobj.name }</a>
                  <a href="logout" class="btn btn-light mr-1"><i class="fas fa-user"></i> Logout</a>
            </c:if>
                              
            <c:if test="${ empty userobj }">
                  <a href="login.jsp" class="btn btn-light mr-1"><i class="fas fa-sign-in-alt"></i> Login</a>
                  <a href="register.jsp" class="btn btn-light"><i class="fas fa-user"></i> Sign up</a>  
            </c:if> 
      </form>
    </div>
  </div>
</nav>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Profile</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div class="card">
             <div class="card-body">
                  <div class="text-center text-primary">
                      <i class="fas fa-user-circle fa-3x"></i> 
                  </div>
                  <table class="table">
                         <tbody>
                              <tr>
                                  <th scope="row">Name</th>
                                  <th>${userobj.name}</th>
                              </tr>
                              
                              <tr>
                                  <th scope="row">Qualification</th>
                                  <th>${userobj.qualification}</th>
                              </tr>
                              
                              <tr>
                                  <th scope="row">Email</th>
                                  <th>${userobj.email}</th>
                              </tr>
                         </tbody>
                  </table>
             </div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <a href="edit_profile.jsp" class="btn btn-primary">Edit</a>
      </div>
    </div>
  </div>
</div>