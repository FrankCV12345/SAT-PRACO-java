<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
       <head>
           <script src="http://momentjs.com/downloads/moment.min.js"></script>
       <spring:url var="scripts" value="/recursos/scripts/script.js"></spring:url>
        <spring:url var="estilos" value="/recursos/Content/Estilos.css" ></spring:url>
        <spring:url var="imagenes" value="/recursos/img" ></spring:url>
        <script src="${scripts}" type="text/javascript"></script>
        <link href="${estilos}" rel="stylesheet" />      
          <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
  
        <link href="https://fonts.googleapis.com/css?family=Noto+Sans+JP" rel="stylesheet">
        <spring:url var="JqueryJs" value="/Recursos/Scripts/Jquery/jquery-1.12.4.js"></spring:url>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <title>EMPLEADO</title>
    </head>
    <body onload="muestraDatos(1)">
        <div id="app">
             <div class="container-SAT" >
                <jsp:include page="BarraMenuEmpleado.jsp" />
                <div class="contenido">
                    <div id="titile"></div>
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
                    			
                    		</tr>	
                    	</thead>
                    	<tbody>
                    		<tr> 
                    			<td >8:00</td>
                                        <td data-id="" data-estado="0" class="lunes"  onclick="IniciarTerminar(this)" ></td>
                    			<td data-id="" data-estado="0" class="martes"  onclick="IniciarTerminar(this)"></td>
                    			<td data-id="" data-estado="0" class="miercoles"  onclick="IniciarTerminar(this)"></td>
                    			<td data-id="" data-estado="0" class="jueves"  onclick="IniciarTerminar(this)"></td>
                                        <td data-id="" data-estado="0" class="viernes"  onclick="IniciarTerminar(this)"></td>
                    				
                    		</tr>
                    		<tr> 
                    			<td>9:00</td>
                                        <td data-id="" data-estado="0" class="lunes"    onclick="IniciarTerminar(this)"  ></td>
                    			<td data-id="" data-estado="0" class="martes"  onclick="IniciarTerminar(this)"></td>
                    			<td data-id="" data-estado="0" class="miercoles"  onclick="IniciarTerminar(this)"></td>
                    			<td data-id="" data-estado="0" class="jueves"  onclick="IniciarTerminar(this)"></td>
                                        <td data-id="" data-estado="0" class="viernes" onclick="IniciarTerminar(this)"></td>
                    				
                    		</tr>
                    		<tr> 
                    			<td>10:00</td>
                    			<td data-id="" data-estado="0" class="lunes"  onclick="IniciarTerminar(this)"></td>
                    			<td  data-id="" data-estado="0" class="martes" onclick="IniciarTerminar(this)"></td>
                    			<td data-id="" data-estado="0" class="miercoles" onclick="IniciarTerminar(this)"></td>
                    			<td data-id="" data-estado="0" class="jueves"  onclick="IniciarTerminar(this)"></td>
                                        <td data-id="" data-estado="0" class="viernes"  onclick="IniciarTerminar(this)"></td>
                    				
                    		</tr>
                    		<tr> 
                    			<td>11:00</td>
                    			<td data-id="" data-estado="0" class="lunes"  onclick="IniciarTerminar(this)"></td>
                    			<td data-id="" data-estado="0" class="martes"  onclick="IniciarTerminar(this)"></td>
                    			<td data-id="" data-estado="0" class="miercoles"  onclick="IniciarTerminar(this)"></td>
                    			<td data-id="" data-estado="0" class="jueves"  onclick="IniciarTerminar(this)"></td>
                                        <td  data-id="" data-estado="0" class="viernes"  onclick="IniciarTerminar(this)"></td>
                    				
                    		</tr>
                    		<tr> 
                    			<td>12:00</td>
                    			<td data-id="" data-estado="0" class="lunes" onclick="IniciarTerminar(this)"></td>
                    			<td data-id="" data-estado="0" class="martes"  onclick="IniciarTerminar(this)"></td>
                    			<td data-id="" data-estado="0" class="miercoles"  onclick="IniciarTerminar(this)"></td>
                    			<td data-id="" data-estado="0" class="jueves"  onclick="IniciarTerminar(this)"></td>
                                        <td data-id="" data-estado="0" class="viernes"  onclick="IniciarTerminar(this)"></td>
                    				
                    		</tr>
                    		<tr> 
                    			<td>13:00</td>
                    			<td data-id="" data-estado="0" class="lunes"  onclick="IniciarTerminar(this)"></td>
                    			<td data-id="" data-estado="0" class="martes"  onclick="IniciarTerminar(this)"></td>
                    			<td data-id="" data-estado="0" class="miercoles"  onclick="IniciarTerminar(this)"></td>
                    			<td data-id="" data-estado="0" class="jueves"  onclick="IniciarTerminar(this)"></td>
                                        <td data-id="" data-estado="0" class="viernes"  onclick="IniciarTerminar(this)"></td>
                    				
                    		</tr>
                    		<tr> 
                    			<td>14:00</td>
                    			<td data-id="" data-estado="0" class="lunes"  onclick="IniciarTerminar(this)"></td>
                    			<td data-id="" data-estado="0" class="martes"  onclick="IniciarTerminar(this)"></td>
                    			<td data-id="" data-estado="0" class="miercoles"  onclick="IniciarTerminar(this)"></td>
                    			<td data-id="" data-estado="0" class="jueves"  onclick="IniciarTerminar(this)"></td>
                                        <td data-id="" data-estado="0" class="viernes"  onclick="IniciarTerminar(this)"></td>
                    				
                    		</tr>
                                <tr> 
                    			<td>15:00</td>
                    			<td data-id="" data-estado="0" class="lunes"  onclick="IniciarTerminar(this)"></td>
                    			<td data-id="" data-estado="0" class="martes"   onclick="IniciarTerminar(this)"></td>
                    			<td  data-id="" data-estado="0" class="miercoles"  onclick="IniciarTerminar(this)"></td>
                    			<td  data-id="" data-estado="0" class="jueves"   onclick="IniciarTerminar(this)"></td>
                                        <td data-id="" data-estado="0" class="viernes"  onclick="IniciarTerminar(this)"></td>
                    			
                    		</tr>
                                <tr> 
                    			<td>16:00</td>
                    			<td data-id="" data-estado="0" class="lunes"   onclick="IniciarTerminar(this)"></td>
                    			<td data-id="" data-estado="0"  class="martes"  onclick="IniciarTerminar(this)"></td>
                    			<td  data-id="" data-estado="0" class="miercoles"  onclick="IniciarTerminar(this)"></td>
                    			<td data-id="" data-estado="0" class="jueves"  onclick="IniciarTerminar(this)"></td>
                    			<td data-id="" data-estado="0" class="viernes"  onclick="IniciarTerminar(this)"></td>
                    			
                    		</tr>
                    	</tbody>
                    
                    </table>

                </div>
            </div>
        </div>
    </body>
</html>
