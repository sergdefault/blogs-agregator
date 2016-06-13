<%--
  Created by IntelliJ IDEA.
  User: Цымбалюк Сергей
  Date: 08.06.2016
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/taglib.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<script type="text/javascript">
    $(document).ready(function () {
        $('.registrationForm').validate(
                {
                    rules:{
                        name:{
                            required: true,
                            minlength : 3
                        },
                        email:{
                            required: true,
                            email : true
                        },
                        password:{
                            required: true,
                            minlength : 5
                        },
                        password_again:{
                            required: true,
                            minlength : 5,
                            equalTo: "#password"
                        }

                    },
                    highlight: function (element) {
                        $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
                    },
                    unhighlight: function (element) {
                        $(element).closest('.form-group').removeClass('has-error').addClass('has-success');
                    }
                }
        );
    });
</script>
<form:form commandName="user" cssClass="form-horizontal registrationForm">
    <c:if test="${param.success eq true}">
        <div class="alert alert-success">Registration successfull!</div>
    </c:if>

    <div>

    <div class="form-group">
        <label for="name" class="col-sm-2 control-label">Name:</label>
        <div class="col-sm-10">
            <form:input path="name" cssClass="form-control"></form:input>
            <form:errors path="name"></form:errors>

        </div>
    </div>

    <div>
    <div class="form-group">
        <label for="email" class="col-sm-2 control-label">Email:</label>
        <div class="col-sm-10">
            <form:input path="email" cssClass="form-control"></form:input>
            <form:errors path="email"></form:errors>
        </div>
    </div>

    <div>
    <div class="form-group">
        <label for="password" class="col-sm-2 control-label">Password:</label>
        <div class="col-sm-10">
            <form:password path="password" cssClass="form-control"></form:password>
            <form:errors path="password"></form:errors>
        </div>
    </div>

    <div>
    <div class="form-group">
        <label for="password" class="col-sm-2 control-label">Password again:</label>
        <div class="col-sm-10">
            <input type="password" name="password_again" id="password_again" class="form-control"/>
        </div>
    </div>


    <div class="form-group">
        <div class="col-sm-10">
            <input type="submit" value="Save" class="btn btn-lg btn-primary"/>
        </div>
    </div>

</form:form>
