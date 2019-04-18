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
        <script>
            $(document).ready(function () // this make the JS wait for HTML to finish
            {

            }); // end ready
        </script>
        <!--setup of JS table events. Needs to be last of all scripts-->
        <%@ include file = "../jspf/tableEvents.jspf"%>
    </head>
    <body>
        <%@ include file = "../jspf/body.jspf" %>
        <p class="white-text-with-blue-shadow">Tryk på et ønske for at ændre. Tryk på 50 for at logge ud</p>
        <div id="wishTable">
            <div class="container">
                <table id="mainTable" class="table table-hover table-condensed table-striped text-center">
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
        <c:if test = "${sessionScope.user == 'migselv'}">
            <button class="btn btn-success centered" onclick="window.location.href = 'FrontController?command=NewWishCommand';">Nyt ønske</button>
        </c:if>
    </body>
</html>
