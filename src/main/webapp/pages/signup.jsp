<html>
<body>
<h2>Enter your user name and password!</h2>
<form action="adduser">

Name     :<input type="text" name="userName"></input><br>
Password :<input type="text" name="password"></input><br>
Age     :<input type="text" name="age"></input><br>
Phone Number :<input type="text" name="phoneNumber"></input><br>
<input type="submit" name=submit></input>

</form>
<%=session.getAttribute("message")%>

</body>
</html>
