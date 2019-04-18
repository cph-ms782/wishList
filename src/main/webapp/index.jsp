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
        <%String cUser = (String) session.getAttribute("user");
            if (cUser == null)
            {
        %>
        <!--info for user-->
        <div id="firstText">
            <p style="text-decoration: underline">For at se gaveønsker, login med følgende:</p>
            <p>Navn: <span style="color: blue"> Gavegiveren</span> (f.eks "Hans, Christian og Anders")</p>
            <p>Kodeord: <span style="color: blue"> se mail</span></p>
        </div>
        <%}%>
    </body>
</html>
