<%-- 
    Document   : userRegister
    Created on : May 15, 2017, 10:35:40 PM
    Author     : David Shire
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="sform" %>


<c:if test="${param.success eq true}">
    <div class="alert alert-success">Success Data Submitted</div>
</c:if>


<sform:form action="?success=true" commandName="userModel" cssClass="form-horizontal registrationForm">
    <!--For Name-->
    <div class="form-group">
        <label class="col-sm-2 control-label" for="name" >Name:</label>

        <div class="col-sm-10">
            <sform:input path="userName" cssClass="form-control"  />
            <sform:errors path="userName" />
        </div>

    </div>

    <!--For Email-->
    <div class="form-group">
        <label class="col-sm-2 control-label" for="Email" >Email:</label>

        <div class="col-sm-10">
            <sform:input path="userEmail" cssClass="form-control" />
            <sform:errors path="userEmail" />
        </div>

    </div>

    <!--For Password-->
    <div class="form-group">
        <label class="col-sm-2 control-label" for="Password" >Password:</label>

        <div class="col-sm-10">
            <sform:password path="userPassword" cssClass="form-control" />
            <sform:errors path="userPassword" />

        </div>

    </div>


    <!--For Button-->
    <div class="form-group">
        <div class="col-sm-10">
            <input type="submit" value="save"  class="btn btn-lg btn-primary"> 
            <input type="reset" value="Clear All" class="btn btn-lg btn-warning"> 
        </div>

    </div>



</sform:form>

<script type="text/javascript">
    $(document).ready(function () {
        $(".registrationForm").validate(
                {
                    rules: {
                        userName: {
                            required: true,
                            minlength: 3
                        },
                        userEmail: {
                            required: false,
                            email: true
                        },
                        userPassword: {
                            required: true,
                            minlength: 3
                        }

                    },
//                    this for text input highlight when written
                    highlight:function (element){
                        $(element).closest(".form-group").removeClass("has-success").addClass("has-error");
                    },
                    unhighlight:function (element){
                        $(element).closest(".form-group").removeClass("has-error").addClass("has-success");
                    }
                }
        );
    });
</script>