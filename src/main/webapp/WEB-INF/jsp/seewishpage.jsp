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
        <%@ include file = "../jspf/tableEvents.jspf"%>
    </head>
    <body>
        <%@ include file = "../jspf/body.jspf" %>
        <p class="white-text-with-blue-shadow">Tryk på et ønske for at ændre. Tryk på <img src="img/50.gif" alt="50 km" width="55" height="55"> for at logge ud</p>
        <div id="wishTable">
            <div class="container">
                <table id="mainTable" class="table table-hover table-condensed table-striped text-center">
                    <tr class="table">
                        <th></th>
                        <th>Gaveønske</th>
                            <c:if test = "${sessionScope.user != 'migselv'}">
                            <th>Giver</th>
                            <th>Noter</th>  
                            </c:if>
                    </tr>
                    <c:forEach items="${wishes}" var="wish"> 
                        <tr class="table-bordered">
                            <td style="color: white">${wish.wishID}</td>
                            <td>${wish.wishText}</td>
                            <c:if test = "${sessionScope.user != 'migselv'}">
                                <td>${wish.giver}</td>
                                <td>${wish.notes}</td>
                            </c:if>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        <c:if test = "${sessionScope.user == 'migselv'}">
            <button class="btn btn-success centered" onclick="window.location.href = 'FrontController?command=NewWishCommand';">Nyt ønske</button>
        </c:if>
    </body>
</html>
