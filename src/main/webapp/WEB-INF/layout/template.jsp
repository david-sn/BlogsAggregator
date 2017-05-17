<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
    <head>

        <title><tiles:getAsString name="title" /></title>
        <script
            src="https://code.jquery.com/jquery-3.2.1.min.js"
            integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
        crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    </head>

    <body>     
        <div class="header">
            <tilesx:useAttribute name="currentActive"/>

            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="<spring:url value="/"/>">Java Blog Aggeragator</a>
                    </div>
                    <ul class="nav navbar-nav">
                        <li class="${currentActive == 'Home' ? 'active':''}"><a href="<spring:url value="/"/>">Home</a></li>

                        <!--if user loggedin and has admin Role-->
                        <security:authorize access="isAuthenticated() and hasRole('ROLE_ADMIN')">
                            <li class="${currentActive == 'users' ? 'active':''}"><a href="<spring:url value="/users"/>">Users</a></li>
                        </security:authorize>
                        
                        <security:authorize access="isAuthenticated()">
                            <li class="${currentActive == 'usersDetail' ? 'active':''}"><a href="<spring:url value="/accout"/>">My Account</a></li>
                        </security:authorize>
                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <li class="${currentActive == 'userRegister' ? 'active':''}"><a href="<spring:url value="/register"/>"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>

                        <!--if user not authenticated will show login user and hide logout button-->
                        <security:authorize access="! isAuthenticated()">
                            <li class="${currentActive == 'userLogin' ? 'active':''}"><a href="<spring:url value="/user-login"/>"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                            </security:authorize>

                        <!--if User Authenticated will show Logout Button-->
                        <security:authorize access="isAuthenticated()">
                            <li><a href="<spring:url value="/logout"/>"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
                            </security:authorize>        

                    </ul>
                </div>
            </nav>
        </div>

        <div class="container">
            <div class="body">
                <tiles:insertAttribute name="body" />
            </div>

            <br/>

            <center>
                <div class="footer">
                    <tiles:insertAttribute name="footer" /> 
                </div>
            </center>

        </div>


    </body>
</html>
