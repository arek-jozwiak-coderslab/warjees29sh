<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: arek
  Date: 31.05.2022
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="book">
    <form:input path="title"/>
    <form:input path="description"/>

    <form:select path="publisher" items="${publishers}" itemLabel="name" itemValue="id"/>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
