    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<h1>Student List</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>Id</th><th>Name</th><th>Address</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach var="student" items="${list}"> 
    <tr>
    <td>${student.id}</td>
    <td>${student.name}</td>
    <td>${student.address}</td>
    <td><a href="editemp/${student.id}">Edit</a></td>
    <td><a href="deleteemp/${student.id}">Delete</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>