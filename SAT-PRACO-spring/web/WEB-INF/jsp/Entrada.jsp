<%-- 
    Document   : Entrada
    Created on : 04-nov-2018, 9:56:14
    Author     : FRANK
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <spring:url var="scripts" value="/recursos/scripts/script.js"></spring:url>
        <spring:url var="estilos" value="/recursos/Content/Estilos.css" ></spring:url>
        <script src="${scripts}" type="text/javascript"></script>
        <link href="${estilos}" rel="stylesheet" />      
        <link href="https://fonts.googleapis.com/css?family=Noto+Sans+JP" rel="stylesheet">
        <spring:url var="JqueryJs" value="/Recursos/Scripts/Jquery/jquery-1.12.4.js"></spring:url>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script type="text/javascript">
            function RegistraEntrada(){
                
                 var id_user = $("#id_user").val();
                 //var id = parseInt(id_user);
                 $.post("/SAT-PRACO-spring/registraIngreso",{id_user},
                        function(data){
                           $(".alert").css("top","0");
                           $(".msj").text(data);
                        }); 
            }
            function EscondeAlert(){
                 $(".alert").css("top","-200px");
                 $(".id_user").val("");
            }
            
        </script>
    </head>
    <body onload="MostrarHora()">
        <div id="app">
            <div class="container">
                <div class="alert">
                    <div class="msj">
                    </div>
                    <div class="btn-b" onclick="EscondeAlert()">CERRAR</div>
                    
                </div>
                <div class="cont-frm-regist_entrada">
                    <div class="title-frm-regist_entrada">
                    <h1 id="hora-entrada">--:--:--</h1>
                    </div>
                    <div class="frm-entrada">
                        <h2 id="title-frm-entrada">INGRESE SU CODIGO</h2>
                      
                        <input type="text" class="cja-text" id="id_user" placeholder="CODIGO">
                        <input type="submit"  value="REGISTRAR" onclick="RegistraEntrada()" class="btn-a">
                    
                    </div>
                </div>

            </div>
        </div>
    </body>
</html>
