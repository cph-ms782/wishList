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
                    <h1 class="white-text-with-blue-shadow">Skriv noget episk</h1>
                    ${sessionScope.wish.wishText}
                    <form action="FrontController" method="POST">
                        <input type="hidden" name="command" value="ChangedWishesCommand" />
                        <div>
                            <label for="giver" class="label">Giver</label>
                            <input type="text" id="departure" name="giver" value="${sessionScope.user.userName}">
                        </div>
                        <div>
                            <label for="notes" class="label">Noter</label>
                            <input type="text" id="airport" name="notes" value="${sessionScope.wish.notes}">
                        </div>
                        <div>
                            <button id="next" class="btn btn-warning">Fortsæt</button>
                        </div>
                    </form>
                    <div>
                        <form action="FrontController" method="POST">
                            <input type="hidden" name="command" value="SeeWishesCommand" />
                            <button id="wishes" class="btn btn-info">Se ønsker</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
