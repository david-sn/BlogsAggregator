<%-- 
    Document   : login
    Created on : May 16, 2017, 11:06:24 AM
    Author     : David Shire
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
    .form-signin {
        max-width: 330px;
        padding: 15px;
        margin: 0 auto;
    }
    .form-signin .form-signin-heading,
    .form-signin .checkbox {
        margin-bottom: 10px;
    }
    .form-signin .checkbox {
        font-weight: normal;
    }
    .form-signin .form-control {
        position: relative;
        height: auto;
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        box-sizing: border-box;
        padding: 10px;
        font-size: 16px;
    }
    .form-signin .form-control:focus {
        z-index: 2;
    }
    .form-signin input[type="email"] {
        margin-bottom: -1px;
        border-bottom-right-radius: 0;
        border-bottom-left-radius: 0;
    }
    .form-signin input[type="password"] {
        margin-bottom: 10px;
        border-top-left-radius: 0;
        border-top-right-radius: 0;
    }
</style>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<div class="container">
    <form class="form-signin" name='f' action="<spring:url value="/login"/>" method="POST">
        <h2 class="form-signin-heading">Please Sign In</h2>
        <label for="inputEmail" class="sr-only">Email address</label>

        <input type="text" name="username"   class="form-control" placeholder="Email address" required autofocus>

        <label for="inputPassword" class="sr-only">Password</label>

        <input type="password" name="password"  class="form-control" placeholder="Password" required>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</div>