<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="<spring:url value="/"/>">Java Blog Aggeragator</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="${currentActive == 'index' ? 'active':''}"><a href="<spring:url value="/"/>">Home</a></li>
            <li class="${currentActive == 'index' ? 'active':''}"><a href="<spring:url value="/users"/>">Users</a></li>
            <li class="${currentActive == 'index' ? 'active':''}"><a href="<spring:url value="/"/>">Link</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        </ul>
    </div>
</nav>