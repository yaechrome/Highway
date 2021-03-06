<%-- 
    Document   : login
    Created on : 28-11-2017, 20:00:22
    Author     : nippo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="css/style.css" media="all" type="text/css">
    </head>
    <body>
        <header>
        </header>

        <section>
            <div class="login-form">
                <h1 style="text-align: center;">Autenticación</h1>          
                <form action="<%= request.getContextPath()%>/Login" method="POST">
                    <fieldset>
                        <legend>Credenciales de usuario</legend> 

                        <% if (request.getAttribute("mensajeError") != null) {%>
                        <div class="error">
                            <p>             
                                <%= request.getAttribute("mensajeError")%>
                            </p>
                        </div>
                        <% }%>

                        <div class="form-group ">
                            <input class="form-control" type="text" name="user" required placeholder="Usuario"/>
                        </div>


                        <div class="form-group ">
                            <input class="form-control" type="password" name="pass" required placeholder="Password"/>
                        </div>
                        
                        <input class="boton_chico" type="submit" name="submit" value="Ingresar" />
                   
                    </fieldset>  
                </form>
            </div>

        </section>
    </body>
</html>
