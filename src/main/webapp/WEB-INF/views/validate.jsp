<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<c:forEach items="${constraintViolations}" var="cv">
    ${cv.propertyPath} :     ${cv.message}
    <br/>
</c:forEach>
</body>
</html>
