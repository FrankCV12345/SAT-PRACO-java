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
    <body onload="muestraDatos()">
        <div id="app">
             <div class="container-SAT" >
                <jsp:include page="BarraMenuEmpleado.jsp" />
                <div class="contenido">
                     <table class="table-tareas">
                    	<br>
                    	<br>
                    	<thead>
                    		<tr>
                    			<th><div class="">DIA/HORA</div></th>
                    			<th>LUNES</th>
                    			<th>MARTES</th>
                    			<th>MIERCOLES</th>
                    			<th>JUEVES</th>
                    			<th>VIERNES</th>
                    			<th></th>
                    		</tr>	
                    	</thead>
                    	<tbody>
                    		<tr> 
                    			<td>8:00</td>
                    			<td>PREPARAR INFORME MENSUAL</td>
                    			<td>PREPARAR INFORME MENSUAL</td>
                    			<td>PREPARAR INFORME MENSUAL</td>
                    			<td>PREPARAR INFORME MENSUAL</td>
                    			<td>PREPARAR INFORME MENSUAL</td>
                    			<td>
                    				<div class="iniciar">INICIAR</div>
                    					<div class="espacio"></div>
 	                   				<div class="terminar">TERMINAR</div>
                    			</td>	
                    		</tr>
                    		<tr> 
                    			<td>9:00</td>
                    			<td>PREPARAR INFORME MENSUAL</td>
                    			<td>b</td>
                    			<td>b</td>
                    			<td>b</td>
                    			<td>b</td>
                    			<td>
                    				<div class="iniciar">INICIAR</div>
                    					<div class="espacio"></div>
 	                   				<div class="terminar">TERMINAR</div>
                    			</td>	
                    		</tr>
                    		<tr> 
                    			<td>10:00</td>
                    			<td>b</td>
                    			<td>b</td>
                    			<td>b</td>
                    			<td>b</td>
                    			<td>b</td>
                    			<td>
                    				<div class="iniciar">INICIAR</div>
                    					<div class="espacio"></div>
 	                   				<div class="terminar">TERMINAR</div>
                    			</td>	
                    		</tr>
                    		<tr> 
                    			<td>11:00</td>
                    			<td>b</td>
                    			<td>b</td>
                    			<td>b</td>
                    			<td>b</td>
                    			<td>b</td>
                    			<td>
                    				<div class="iniciar">INICIAR</div>
                    					<div class="espacio"></div>
 	                   				<div class="terminar">TERMINAR</div>
                    			</td>	
                    		</tr>
                    		<tr> 
                    			<td>12:00</td>
                    			<td>b</td>
                    			<td>b</td>
                    			<td>b</td>
                    			<td>b</td>
                    			<td>b</td>
                    			<td>
                    				<div class="iniciar">INICIAR</div>
                    					<div class="espacio"></div>
 	                   				<div class="terminar">TERMINAR</div>
                    			</td>	
                    		</tr>
                    		<tr> 
                    			<td>13:00</td>
                    			<td>b</td>
                    			<td>b</td>
                    			<td>b</td>
                    			<td>b</td>
                    			<td>b</td>
                    			<td>
                    				<div class="iniciar">INICIAR</div>
                    					<div class="espacio"></div>
 	                   				<div class="terminar">TERMINAR</div>
                    			</td>	
                    		</tr>
                    		<tr> 
                    			<td>14:00</td>
                    			<td>b</td>
                    			<td>b</td>
                    			<td>b</td>
                    			<td>b</td>
                    			<td>b</td>
                    			<td>
                    				<div class="iniciar">INICIAR</div>
                    					<div class="espacio"></div>
 	                   				<div class="terminar">TERMINAR</div>
                    			</td>	
                    		</tr>
                    	</tbody>
                    	<tfoot>
                    		<tr>
                    			<td colspan="7">FOOTER</td>
                    		</tr>
                    	</tfoot>
                    </table>

                </div>
            </div>
        </div>
    </body>
</html>
