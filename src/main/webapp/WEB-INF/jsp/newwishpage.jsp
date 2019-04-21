<%-- 
    Document   : seewishes
    Created on : Apr 18, 2019
    Author     : martin
--%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
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
                    <h1 class="white-text-with-blue-shadow">Nyt ønske</h1>
                    <form action="FrontController" method="POST">
                        <input type="hidden" name="command" value="NewWishCommand" />
                        <div>
                            <label for="wishtext" class="label">Nyt Ønske</label>
                            <input contenteditable="true" type="text" id="departure" name="wishtext">
                        </div>
                        <div>
                            <label for="link" class="label">Link</label>
                            <input contenteditable="true" type="url" id="departure" name="link">
                        </div>
                        <div>
                            <button id="next" class="btn btn-warning">Fortsæt</button>
                        </div>
                    </form>
                    <div>
                        <form action="FrontController" method="POST">
                            <input type="hidden" name="command" value="SeeWishesCommand" />
                            <button id="wishes" class="btn btn-success">Se ønsker</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>