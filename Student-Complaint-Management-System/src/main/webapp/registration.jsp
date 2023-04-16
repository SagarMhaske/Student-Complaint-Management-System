<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
    <%@page import="ims.scms.dao.UserDao,ims.scms.bean.UserRegisterBean"%> 
    <%="hello" %>
    <%= request.getParameter("userName") %>>
    <jsp:useBean id="u" class="ims.scms.bean.UserRegisterBean" scope="session" ></jsp:useBean>
    <jsp:setProperty property="*" name="u"/> 
    <% out.println("user name"+ u.getUserName()); %>
    
    
    
    
    <% 
int i = UserDao.userRegister(u);  
if(i>0){  
response.sendRedirect("registerSuccess.jsp");  
}else{  
response.sendRedirect("registerError.jsp");  
}  
%>