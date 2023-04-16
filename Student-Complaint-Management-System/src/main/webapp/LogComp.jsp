<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
    <%@page import="ims.scms.dao.ComplaintDao"%> 
    <jsp:useBean id="userBean" class="ims.scms.bean.ComplaintBean"></jsp:useBean>
    <jsp:setProperty property="*" name="userBean"/> 
    
    <%  
int i = ComplaintDao.logComplaint(userBean);  
if(i>0){  
response.sendRedirect("addCompSuccess.jsp");  
}else{  
response.sendRedirect("addCompError.jsp");  
}  
%>