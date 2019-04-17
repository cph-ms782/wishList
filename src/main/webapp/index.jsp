<%-- 
    Document   : index
    Created on : 17. april, 2019
    Modified on: 17. april, 2019
    Author     : martin bøgh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file = "WEB-INF/jspf/header.jspf" %>
    </head>

    <body>
        <%@ include file = "WEB-INF/jspf/body.jspf" %>

        Only bring text if there's no logged in user
        <%String cUser = (String) session.getAttribute("user");
            if (cUser == null)
            {
        %>
        <!--info for user-->
        <div class="firstText">
            <div id="orderInfoHeader">
                <br><br><br><br><br>
                <p style="text-decoration: underline">For at se gaveønsker, login med følgende:</p>
                <p>Navn: <span style="color: aquamarine">Gavegiver, f.eks "Hans, Christian og Anders"</span></p>
                <p>Kodeord: <span style="color: aquamarine">se mail</span></p>
            </div>
        </div>
        <%}%>
    </body>
</html>
