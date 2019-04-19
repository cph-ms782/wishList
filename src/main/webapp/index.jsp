<%-- 
    Document   : index
    Created on : 17. april, 2019
    Modified on: 19. april, 2019
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
        <c:choose>
            <c:when test="${sessionScope.user == null}">
                <!--info for user-->
                <div id="firstTextContainer">
                    <div id="firstText">
                        <p>For at se gaveønsker, login med følgende:</p>
                        <p>Navn: <span style="color: blue"> Gavegiveren</span> (f.eks "Hans, Christian og Anders")</p>
                        <p>Kodeord: <span style="color: blue"> se mail</span></p>
                        <p><br /></p>
                        <p style="font-size: 1.2em">Login og skriv noget i tabellen under Noter </p>
                        <p style="font-size: 1.4em">for at "reservére" en gave </p>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <jsp:forward page="WEB-INF/jsp/seewishpage.jsp" />
            </c:otherwise>
        </c:choose>
    </body>
</html>
