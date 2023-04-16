<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ims.scms.dao.ComplaintDao"%>
<%@ page import="ims.scms.bean.CompUserBean"%>
<%@ page import="java.util.*"%>
<%
    ComplaintDao dao = new ComplaintDao();
    String compId = request.getParameter("compId");
    String compStatus = request.getParameter("compStatus");
    if (compId != null && compStatus != null) {
        dao.updateComplaintStatus(compId, compStatus);
        response.sendRedirect(request.getRequestURI()); // This line is added to refresh the page after updating the complaint status
    }
    List<CompUserBean> compList = dao.listOfComplaint();
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Page</title>
    <style>
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


th, td {
  text-align: left;
  padding: 8px;
  border-bottom: 1px solid #ddd;
}

th {
  background-color: #4CAF50;
  color: white;
}

tr:nth-child(even) {
  background-color: #f2f2f2;
}

button {
  background-color: #4CAF50;
  color: white;
  border: none;
  padding: 8px 16px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 14px;
  margin: 4px 2px;
  cursor: pointer;
}
    </style>
</head>
<body>
	
	<header>
		<h1>Student Complaint Management System</h1>
		<nav>
			<ul>
				<li><a href="LogComplaint.html">Submit a Complaint</a></li>
				<li><a href="byEmail.html">complaintBy Email</a></li>
				<li><a href="index.jsp">Log out</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<br>
    <table>
        <thead>
            <tr>
                <th>Complaint ID</th>
                <th>User Name</th>
                <th>Contact</th>
                <th>Complaint Type</th>
                <th>Description</th>
                <th>Date</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <% for (CompUserBean comp : compList) { %>
            <tr>
                <td><%= comp.getComplaintId() %></td>
                <td><%= comp.getUserName() %></td>
                <td><%= comp.getUserContact() %></td>
                <td><%= comp.getCompType() %></td>
                <td><%= comp.getCompDestrip() %></td>
                <td><%= comp.getDate() %></td>
                <td><%= comp.getCompStatus() %></td>
                <td>
                    <% if (comp.getCompStatus().equals("Pending")) { %>
                        <form method="post" action="Admin.jsp">
                            <input type="hidden" name="compId" value="<%= comp.getComplaintId() %>">
                            <input type="hidden" name="compStatus" value="Resolved">
                            <button type="submit">Resolve</button>
                        </form>
                    <% } else { %>
                        <%= comp.getCompStatus() %>
                    <% } %>
                </td>
            </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>