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

    <form:hidden path="id"/>
    pages
    <form:input path="pages"/> <br/>
    <form:errors path="pages"/><br/>
    title
    <form:input path="title"/> <br/>
    <form:errors path="title"/><br/>
    description
    <form:input path="description"/><br/>
    <form:errors path="description"/><br/>
    rating
    <form:input path="rating"/> <br/>
    <form:errors path="rating"/><br/>

    <form:select path="publisher" items="${publishers}" itemLabel="name" itemValue="id"/>
    <br/><br/>
    <input type="submit" value="Save"> <br/>
    <form:errors path="*"/>
</form:form>
</body>
</html>
