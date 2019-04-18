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
                    <h1 class="white-text-with-blue-shadow">Nyt ønske</h1>
                    <form action="FrontController" method="POST">
                        <input type="hidden" name="command" value="NewWishCommand" />
                        <div>
                            <label for="wishtext" class="label">Nyt Ønske</label>
                            <input contenteditable="true" type="text" id="departure" name="wishtext">
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