<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Student Complaint Management System</title>
	<style>
body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
}

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

main {
    max-width: 800px;
    margin: 0 auto;
    padding: 20px;
}

/* Specific Styles */
h1 {
    font-size: 36px;
    margin: 0;
}

a.button {
    background-color: #f00;
    color: #fff;
    padding: 10px;
    text-decoration: none;
    border-radius: 5px;
    display: inline-block;
}

a.button:hover {
    background-color: #c00;
}

/* Responsive Styles */
@media screen and (max-width: 600px) {
    header {
        flex-direction: column;
    }
    
    nav li {
        display: block;
        margin: 10px 0;
    }
}
	</style>
</head>
<body>
	<header>
		<h1>Student Complaint Management System</h1>
		<nav>
			<ul>
				<li><a href="login.html">Submit a Complaint</a></li>
				<li><a href="registration.html">Register</a></li>
				<li><a href="login.html">Login</a></li>
			</ul>
		</nav>
	</header>
	<main>
	<img alt="not found" src="https://www.consumercomplaints.in/img/present-img.svg">
	</main>
	
</body>
</html>
