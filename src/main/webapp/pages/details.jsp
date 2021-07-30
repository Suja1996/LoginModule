<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="updateDetails">

Phone Number     :<input type="text" name="phoneNumber" ></input><br>
Age :<input type="text" name="age"></input><br>
<input type="submit" name=submit></input>

</form>




<%=session.getAttribute("message")%>

</body>
</html>