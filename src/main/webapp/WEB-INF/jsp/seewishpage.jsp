<%-- 
    Document   : seewishes
    Created on : Apr 17, 2019, 2:30:51 PM
    Author     : martin
--%>

<%@page import="java.util.List"%>
<%@page import="Logic.DTO.Wish"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file = "../jspf/header.jspf" %>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <script>
            $(document).ready(function () // this make the JS wait for HTML to finish
            {

            }); // end ready
        </script>
    </head>
    <body>
        <%@ include file = "../jspf/body.jspf" %>
        <p class="white-text-with-blue-shadow">Tryk på et ønske for at ændre. Tryk på 50 for at logge ud</p>
        <div id="mainTable">
            <div class="container">
                <table class="table table-hover table-condensed table-striped text-center">
                    <tr class="table">
                        <th></th>
                        <th>Gaveønske</th>
                        <th>Giver</th>
                        <th>Noter</th>  
                    </tr>
                    <c:forEach items="${wishes}" var="wish"> 
                        <tr class="table-bordered">
                            <td>${wish.wishID}</td>
                            <td>${wish.wishText}</td>
                            <td>${wish.giver}</td>
                            <td>${wish.notes}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>
