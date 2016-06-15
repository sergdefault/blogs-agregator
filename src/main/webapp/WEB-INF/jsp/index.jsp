<%--
  Created by IntelliJ IDEA.
  User: Цымбалюк Сергей
  Date: 21.05.2016
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/taglib.jsp" %>



<h1>Latest news from java world:</h1>
<table class="table table-bordered table-hover table-striped">
 <thread>
  <tr>
   <th>date</th>
   <th>item</th>
  </tr>
 </thread>

 <tbody>
 <c:forEach items="${items}" var="item">
  <tr>

   <td><c:out value="${item.publishedDate}"/>
   <br>
   <c:out value="${item.blog.name}"/>
   </td>

   <td>
    <strong>
     <a href="<c:out value="${item.link}"/>"target="_blank">
      <c:out value="${item.title}"/>
     </a>
    </strong>
    <br>
     ${item.description}
   </td>
  </tr>
 </c:forEach>
 </tbody>
</table>

