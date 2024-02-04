<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="2" width="30%" cellpadding="1">
 
 		<tr>
 			<th>ID</th>
 			<th>NAME</th>
 			<th>ADDRESS</th>
 			<th>DELETE</th>
 			<th>EDIT</th>
 		</tr>
 	
 		<c:forEach var="student" items="${list}"> 
    		<tr>
			    <td>${student.id}</td>
			    <td>${student.name}</td>
			    <td>${student.address}</td>
			    <td> <a href="deletestudent/${student.id }">Delete Student</a> </td>
			    <td> <a href="editstudent/${student.id}">Edit</a> </td>
   			</tr>
   	 </c:forEach> 
 </table>
</body>
</html>