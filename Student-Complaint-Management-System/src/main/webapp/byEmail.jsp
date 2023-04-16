<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
    <%@page import="ims.scms.dao.ComplaintDao"%> 
    <jsp:useBean id="userBean" class="ims.scms.bean.ComplaintBean"></jsp:useBean>
    <jsp:setProperty property="*" name="userBean"/> 
    
    <%@ page import="ims.scms.bean.CompUserBean"%>
	<%@ page import="ims.scms.dao.ComplaintDao"%>
	<%@ page import="java.util.*"%>
    
 <html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style >
    header {
    background-color: #4CAF50;
    color: #fff;
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 10px;
}

nav ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
}

nav li {
    display: inline-block;
    margin-right: 10px;
}

nav li a {
    color: #fff;
    text-decoration: none;
}

nav li a:hover {
    color: #ddd;
}
        table {
  border-collapse: collapse;
  width: 100%;
}
</style>
</head>

<body>
<header>
		<h1>Student Complaint Management System</h1>
		<nav>
			<ul>
				<li><a href="Admin.jsp">Home</a></li>
				<li><a href="byEmail.html">complaintBy Email</a></li>
				<li><a href="index.jsp">Log out</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<br>
	<%
		ComplaintDao dao = new ComplaintDao();
		List<CompUserBean> compList = dao.listOfComplaint();
	%>
	<table border="1">
		<tr>
			<th>Complaint Id</th>
			<th>Name</th>
			<th>Contact</th>
			<th>Comp Type</th>
			<th>Complaint Description</th>
			<th>Date</th>
			<th>Complaint Status</th>
		</tr>
		<tr>
			<%for(CompUserBean cul : compList){ %>
			<td><%=cul.getComplaintId()%></td>
			<td><%=cul.getUserName()%></td>
			<td><%=cul.getUserContact() %></td>
			<td><%=cul.getCompType() %></td>
			<td><%=cul.getCompDestrip() %></td>
			<td><%=cul.getDate() %></td>
			<td><%=cul.getCompStatus() %></td>
		</tr>
		<%} %>
	</table>
</body>
</html>