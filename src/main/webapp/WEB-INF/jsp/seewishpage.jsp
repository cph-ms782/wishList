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

        <c:if test = "${sessionScope.user.userID > 1 }">
            <%@ include file = "../jspf/menu.jspf" %>
        </c:if>
        <p class="white-text-with-blue-shadow">Tryk på et ønske for at ændre. Tryk på <img src="img/<c:out value="${sessionScope.receiver.image}" />" alt="modtager billede" height="55"> for at logge ud</p>

        <div id="wishTable">
            <div class="container">
                <table id="mainTable" class="table table-hover table-condensed table-striped text-center">
                    <tr class="table">
                        <th></th>
                        <th>Gaveønsker for <c:out value="${sessionScope.receiver.userName}" /></th>
                        <th>Link</th>  
                            <c:if test = "${sessionScope.user.userID != sessionScope.receiver.userID || sessionScope.user.userID == 1}">
                            <th>Giver</th>
                            <th>Noter</th>  
                            </c:if>
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
                            <c:if test = "${sessionScope.user.userID != sessionScope.receiver.userID || sessionScope.user.userID == 1}">
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
