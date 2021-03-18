<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/userUpdateForm.css"/>
<head>
<meta charset="ISO-8859-1">
<title>Update User Form</title>
</head>
<body>
<p>Restrictions</p>
	<ul>
         <li>Password:  Must be longer than 5 characters</li>
         <li>Email: Follow Email Format</li>
         <li>Name: Can only have letters and spaces</li>
    </ul>
<form action ="update" method="post" >
	<label for="idNum" >User Id Number</label>
   		<input type="number" value="${user.id}" name="idNum" readonly/>
   		<br>
   <label for="password">Password</label>
   		<input type="password" value="${user.password}" name="password"  minlength="5" required/>
   		<br>
   <label for="email">Email</label>
   		<input type="email" value="${user.email}" name="email" required/>
   		<br>
   <label for="name">Name</label>
   		<input type="text" value="${user.name}" name="name" pattern="[a-zA-Z ]+" required/>
   		<br>
   <input type="submit" value="Update">
   
</form>
</body>
</html>