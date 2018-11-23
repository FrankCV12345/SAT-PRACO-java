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
            <div class="container-SAT" >
                <jsp:include page="BarraMenu.jsp" />
                <div class="contenido">
                    
                </div>
            </div>
             <div class="modal-a">
                    <!-- INICIO DEL FORMULARIO REGISTRA USUARIO-->
                    <div class="frm-registra-user">
                        <form id="frm-regis-user">
                                <div class="form-group">
                                    <label for="formGroupExampleInput">NOMBRE</label>
                                    <input type="text" class="form-control" id="nombre" placeholder="NOMBRE">
                                    <label for="formGroupExampleInput2">APELLIDOS</label>
                                    <input type="text" class="form-control" id="apellidos" placeholder="APELLIDOS">
                                    <label for="formGroupExampleInput2" >DNI</label>
                                    <input type="number" class="form-control" id="dni" placeholder="DNI">
                                     <div class="input-group mb-3">
                                      <div class="input-group-prepend">
                                        <label class="input-group-text" for="">TIPO DOC</label>
                                      </div>
                                      <select class="custom-select" id="tipo-doc">
                                        <option selected>Selecione</option>
                                      </select>
                                    </div>
                                    <label for="formGroupExampleInput2">EMAIL</label>
                                    <input type="email" class="form-control" id="email" placeholder="example@exampel.com">
                                     <label for="formGroupExampleInput2">TELEFONO</label>
                                    <input type="number" class="form-control" id="telefono" placeholder="000000000">
                                    <br>
                                    <div class="input-group mb-3">
                                      <div class="input-group-prepend">
                                        <label class="input-group-text" for="">Cargo</label>
                                      </div>
                                      <select class="custom-select" id="list-cargo">
                                        <option selected>Selecione</option>
                                      </select>
                                    </div>
                                    <div class="form-group row">
                                      <label for="example-datetime-local-input" class="col-2 col-form-label">FECHA NACIMIENTO</label>
                                      <div class="col-10">
                                        <input class="form-control" type="datetime-local" onclick="verFecha()" id="fechanac">
                                      </div>
                                    </div>
                                    <div class="input-group mb-3">
                                      <div class="input-group-prepend">
                                        <label class="input-group-text" for="">Estado civil</label>
                                      </div>
                                      <select class="custom-select" id="estacivil">
                                        <option selected>Selecione</option>
                                        <option value="S">SOLTERO</option>
                                        <option value="C">CASADO</option>
                                      </select>
                                    </div>
                                       <div class="input-group mb-3">
                                      <div class="input-group-prepend">
                                        <label class="input-group-text" for="">Sexo</label>
                                      </div>
                                      <select class="custom-select" id="sexo">
                                        <option selected>Selecione</option>
                                        <option value="M">MASCULINO</option>
                                        <option value="F">FEMENINO</option>
                                        <option value="I">INDEFINIDO</option>
                                      </select>
                                    </div>
                                    <label for="formGroupExampleInput2">NACIONALIDAD</label>
                                    <input type="text" class="form-control" id="nacionalidad" placeholder="NACIONALIDAD">
                                    <label for="formGroupExampleInput2">DOMICILIO</label>
                                    <input type="text" class="form-control" id="domicilio" placeholder="DOMICILIO">
                                  </div>                                                               
                                 
                            <input type="button" name="" value="GUARDAR" onclick="RegistraUser()">
                                 <input type="button" name="" value="X" onclick="MostrarModal('frm-registra-user')">
                        </form>
                    </div>
                    <!-- FIN DEL FORMULARIO REGISTRA USUARIO-->
                    <!-- INICIO DEL FORMULARIO REGISTRA ASIGNA TAREA-->
                    <div class="frm-asigna-tarea">
                        <form id="frm-regis-tarea">
                             <div class="input-group mb-3">
                                      <div class="input-group-prepend">
                                        <label class="input-group-text" for="">Empleado</label>
                                      </div>
                                      <select class="custom-select" id="lstUsers">
                                        <option selected>Selecione</option>
                                      </select>
                                </div>
                            <div class="input-group mb-3">
                                      <div class="input-group-prepend">
                                        <label class="input-group-text" for="">Tareas</label>
                                      </div>
                                      <select class="custom-select" id="lstTreas">
                                        <option selected>Selecione</option>
                                      </select>
                                </div>
                                    <div class="form-group">
                                        <label for="exampleFormControlTextarea1">detalles</label>
                                        <textarea class="form-control" id="Descripcion" rows="3"></textarea>
                                        <label for="example-datetime-local-input" class="col-2 col-form-label">DESDE</label>
                                          <div class="col-10">
                                            <input class="form-control" type="datetime-local" id="fechaInicioE">
                                          </div>
                                           <label for="example-datetime-local-input" class="col-2 col-form-label">HASTA</label>
                                          <div class="col-10">
                                            <input class="form-control" type="datetime-local"  id="fechaFinE">
                                          </div>
                                  </div>
                            <input type="button" name="" value="GUARDAR" onclick="RegistraTarea()">
                            <input type="button" name="" value="X" onclick="MostrarModal('frm-asigna-tarea')">
                        </form>
                    </div>
                      <!-- INICIO DE EL ELEMENTO DIV CALCULA  SUELDO-->
                       <div class="div-sueldo">
                            <div class="conte-sueldo">
                                <div class="sueldo"> 
                                    <h2> JUILIO DE LACRUZ TORRES</h2>
                                    <span> horas trabajadas</span> : <span>89.5 hrs</span>
                                    <br>
                                    <span> SUELDO ESTIMADOD</span> : <span>S/. 500</span>
                                </div>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                <input type="button" name="" value="X" onclick="MostrarModal('div-sueldo')">
                            </div>
                    </div>
                    <!-- FIN DE EL ELEMENTO DIV CALCULA  SUELDO-->

                    <!-- INICIO DE EL ELEMENTO DIV  DATOS USER-->
                       <div class="div-datos-user">
                            <div class="conte-datos-user">
                                <div class="datos-user-frm">                                     
                                    <span> NOMBRES:</span>  <span>JUAN </span>
                                    <br>
                                    <span> APELLIDOS:</span>  <span>DE LAS DAMAS</span>
                                    <br>
                                    <span> CARGO:</span>  <span>OPERIO </span>
                                    <br>
                                    <span> TELEFONO:</span>  <span>990418963</span>
                                    <div class="input-group mb-3">
                                      <div class="input-group-prepend">
                                        <label class="input-group-text" for="">ESTADO</label>
                                      </div>
                                      <select class="custom-select" id="">
                                        <option value="1">ACTIVO</option>
                                        <option value="0">INACTIVO</option
                                      </select>
                                </div>
                                </div>
                                    <br>
                                    <br>
                                    <br>
                                    <br>
                                <input type="button" name="" value="GUARDAR">
                                <input type="button" name="" value="X" onclick="MostrarModal('div-datos-user')">
                            </div>
                    </div>
                    <!-- FIN DE EL ELEMENTO DIV  DATOS USER--->
                </div>
        </div>
    </body>
</html>
