<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: arek
  Date: 31.05.2022
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>id</th>
        <th>title</th>
        <th>description</th>
        <th>publisher</th>
    </tr>
<a href="<c:url value="/book-form/add"/>">dodaj książkę</a>
    </thead>
    <tbody>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.description}</td>
            <td>${book.publisher.name}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
