<%-- 
    Document   : seewishes
    Created on : Apr 18, 2019
    Author     : martin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file = "../jspf/header.jspf" %>
        <link href = "css/form.css" rel = "stylesheet" >
    </head>

    <body>
        <%@ include file = "../jspf/body.jspf" %>
        <div class="wrapper">
            <div class="content">
                <div class="main">
                    <h1 class="white-text-with-blue-shadow">Ændre ønske</h1>
                    
                    <form action="FrontController" method="POST">
                        <input type="hidden" name="command" value="SeeWishesCommand" />
                        <input type="hidden" name="index" value="${param["index"]}" />
                        <div>
                            <label for="wishtext" class="label">Ønske</label>
                            <input type="text" id="departure" name="wishtext" value="${sessionScope.wish.wishText}">
                        </div>
                        <div>
                            <button id="next">Fortsæt</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
