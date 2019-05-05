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

        <c:if test = "${sessionScope.user.userID > 1}">
            <div class="wrapper">
                <div class="content">
                    <div class="main">
                        <h1 class="white-text-with-blue-shadow">Ændre ønske</h1>

                        <form action="FrontController" method="POST">
                            <input type="hidden" name="command" value="ChangedWishCommand" />
                            <div>
                                <label for="wishtext" class="label">Ønske</label>
                                <input type="text" id="departure" name="wishtext" value="${sessionScope.wish.wishText}">
                            </div>
                            <div>
                                <label for="link" class="label">Link</label>
                                <input type="text" id="departure" name="link" value="${sessionScope.wish.link}">
                            </div>
                            <div>
                                <button id="next" class="btn btn-warning">Fortsæt</button>
                            </div>
                        </form>
                        <form action="FrontController" method="POST">
                            <input type="hidden" name="command" value="ChangedWishCommand" />
                            <input type="hidden" name="deleted" value="true" />
                            <div>
                                <button id="wishes" class="btn btn-danger">Slet ønsk</button>
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
        </c:if>

    </body>
</html>
