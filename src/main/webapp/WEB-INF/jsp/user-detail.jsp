<%--
  Created by IntelliJ IDEA.
  User: Цымбалюк Сергей
  Date: 07.06.2016
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/taglib.jsp" %>

<h1>${user.name}</h1>

<c:forEach items="${user.blogs}" var="blog">

    <h1>${blog.name}</h1>
    <p>${blog.url}</p>
    <table class="table table-bordered table-hover table-striped">
        <thread>
            <tr>
                <th>Title</th>
                <th>Link</th>
            </tr>
        </thread>

        <tbody>
        <c:forEach items="${blog.items}" var="item">
            <tr>
                <td>${item.title}</td>
                <td>${item.link}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</c:forEach>