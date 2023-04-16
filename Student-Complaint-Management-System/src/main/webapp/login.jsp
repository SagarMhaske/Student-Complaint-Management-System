
<%@page import="ims.scms.dao.UserDao, ims.scms.bean.UserLoginBean"%>  
<jsp:useBean id="obj" class="ims.scms.bean.UserLoginBean"/>  
  <%= request.getParameter("userEmail") %>
<jsp:setProperty property="*" name="obj"/>  
 
<%  
boolean status=UserDao.userLogin(obj); 
if(status){  
	String userRole = request.getParameter("userType");
	if(userRole.equals("student")){
		response.sendRedirect("LogComplaint.html");
	}
	else if(userRole.equals("admin")){
		response.sendRedirect("Admin.jsp");
	}
	else if(userRole.equals("PResolver")){
		response.sendRedirect("ProblemResolver.jsp");
	}   
}  
else  
{  
	out.print("Sorry, email or password error");  
%>  
<jsp:include page="login.html"></jsp:include>  
<%  
}  
%>  
