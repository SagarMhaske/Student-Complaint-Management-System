<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="ims.scms.bean.CompUserBean"%>
<%@ page import="ims.scms.dao.ComplaintDao"%>
<%@ page import="java.util.*"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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
			<td><%=cul.getUserContact()%></td>
			<td><%=cul.getCompType() %></td>
			<td><%=cul.getCompDestrip() %></td>
			<td><%=cul.getDate() %></td>
			<td><%=cul.getCompStatus() %></td>
		</tr>
		<%} %>
	</table>
</body>
</html>