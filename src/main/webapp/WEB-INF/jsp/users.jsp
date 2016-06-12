<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../layout/taglib.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table class="table table-bordered table-hover table-striped">
    <thread>
        <tr>
            <th>User name</th>
        </tr>
    </thread>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>
                <a href="<spring:url value="/users/${user.id}.html"/>">
                ${user.name}
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
