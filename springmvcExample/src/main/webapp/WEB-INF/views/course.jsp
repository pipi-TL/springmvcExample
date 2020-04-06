<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Course</title>
</head>
<body>
<form action="registerCourse" method="post">
    Course name:<input type="text" name="courseName"><br>
    Department:<input type="text" name="department">
    <input type="submit" value="add">
    <hr>
    <table border="1">
        <thead>
        	<tr>
            <th>course name</th>
            <th>department</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${currentStudent.courses}" var="course">
               <tr>
                   <td><c:out value="${course.courseName}"></c:out></td>
                   <td><c:out value="${course.department}"></c:out></td>

               </tr>
            </c:forEach>
        </tbody>
    </table>
</form>
<a href="registerStudent">logout</a>
</body>
</html>
