<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>Register</title>
    <base href="<%=basePath%>">
</head>
<body>
    <form action="registerStudent" method="post">
        First Name:<input type="text" name="firstName"><br/>
        Last Name:<input type="text" name="lastName"><br/>
        Email: <input type="text" name="email"><br>
        Password:<input type="text" name="password"><br>
        <input type="reset" value="reset"><input type="submit" value="submit">
    </form>
</body>
</html>
