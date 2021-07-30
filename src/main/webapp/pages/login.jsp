<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="validate">

Name     :<input type="text" name="userName"></input><br>
Password :<input type="text" name="password"></input><br>
<input type="submit" name=submit></input>

</form>


<a href="signup" > New user? Sign up here! </a><br>
<a href="reset" >Forgot Password? </a><br>
<%=session.getAttribute("message")%>

</body>
</html>