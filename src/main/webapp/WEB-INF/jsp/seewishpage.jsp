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

        <c:if test = "${sessionScope.user.getUser} == ${loggedin}">

            <div id="changeWishButtonContainer">
                <div class="centerize">
                    <button class="btn btn-success" onclick="window.location.href = 'FrontController?command=NewWishCommand';">Nyt ønske</button>
                </div>
            </div>

        </c:if>

        <div id="wishTable">
            <div class="container">
                <table id="mainTable" class="table table-hover table-condensed table-striped text-center">
                    <tr class="table">
                        <th></th>
                        <th>Gaveønske</th>
                            <c:if test = "${sessionScope.user} != ${loggedin}">
                            <th>Giver</th>
                            <th>Noter</th>  
                            </c:if>
                        <th>Link</th>  
                    </tr>
                    <c:forEach items="${wishes}" var="wish"> 
                        <tr class="table-bordered">
                            <td style="color: white">${wish.wishID}</td>
                            <td>${wish.wishText}</td>
                            <c:choose> 
                                <c:when test = "${wish.link != null}">
                                    <td><a href="${wish.link}" target="_blank">Link</td>
                                </c:when>
                                <c:otherwise>
                                    <td></td>
                                </c:otherwise>
                            </c:choose>  
                            <c:if test = "${sessionScope.user != 1}">
                                <td>${wish.giver}</td>
                                <td>${wish.notes}</td>
                            </c:if>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>
