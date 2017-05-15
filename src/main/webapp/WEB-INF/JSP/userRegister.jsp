<%-- 
    Document   : userRegister
    Created on : May 15, 2017, 10:35:40 PM
    Author     : David Shire
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="sform" %>

<sform:form commandName="userModel" cssClass="form-horizontal">
    <!--For Name-->
    <div class="form-group">
        <label class="col-sm-2 control-label" for="name" >Name:</label>

        <div class="col-sm-10">
            <sform:input path="userName" cssClass="form-control" />
        </div>

    </div>

    <!--For Email-->
    <div class="form-group">
        <label class="col-sm-2 control-label" for="Email" >Email:</label>

        <div class="col-sm-10">
            <sform:input path="userEmail" cssClass="form-control" />
        </div>

    </div>

    <!--For Password-->
    <div class="form-group">
        <label class="col-sm-2 control-label" for="Password" >Password:</label>

        <div class="col-sm-10">
            <sform:password path="userPassword" cssClass="form-control" />
        </div>

    </div>

        
<!--For Button-->
    <div class="form-group">
        <div class="col-sm-10">
            <input type="submit" value="save" class="btn btn-lg btn-primary"> 
        </div>

    </div>



</sform:form>