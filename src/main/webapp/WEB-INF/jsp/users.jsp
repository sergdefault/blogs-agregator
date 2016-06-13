<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../layout/taglib.jsp" %>

<script type="text/javascript">
    $(document).ready(function () {
        $('.triggerRemove').click(function (e) {
            e.preventDefault();
            $("#modalRemove .removeBtn").attr("href", $(this).attr("href"));
            $("#modalRemove").modal();
        })
    })
</script>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table class="table table-bordered table-hover table-striped">
    <thread>
        <tr>
            <th>User name</th>
            <th>operations</th>
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
            <td>
                <a href="<spring:url value="/users/remove/${user.id}.html"/>"class="btn btn-danger triggerRemove">
                        remove
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Remove blog</h4>
            </div>
            <div class="modal-body">
                Really remove?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                <a href="" class="btn btn-danger removeBtn">Remove</a>
            </div>
        </div>
    </div>
</div>


</body>
</html>
