<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <spring:url var="scripts" value="/recursos/scripts/script.js"></spring:url>
        <spring:url var="estilos" value="/recursos/Content/Estilos.css" ></spring:url>
        <spring:url var="imagenes" value="/recursos/img" ></spring:url>
        <script src="${scripts}" type="text/javascript"></script>
        <link href="${estilos}" rel="stylesheet" />      
          <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
  
        <link href="https://fonts.googleapis.com/css?family=Noto+Sans+JP" rel="stylesheet">
        <spring:url var="JqueryJs" value="/Recursos/Scripts/Jquery/jquery-1.12.4.js"></spring:url>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <title>ADMIN</title>
    </head>
    <body>
        <div id="app">
            <div class="container-SAT l" >
            	 <div class="cont-frm-login">
                    <div class="frm-login">
                        <h2 id="title-frm-LOGIN">LOGIN </h2>
                        <input type="text" class="cja-text" placeholder="usuario" id="idusu">
                        <input type="PASSWORD" class="cja-text" placeholder="PASSWORD">
                        <input type="submit"  value="INGRESAR" class="btn-a" onclick="Login()">
                    </div>
                </div>
           	</div>
         </div>
    </body>
</html>
