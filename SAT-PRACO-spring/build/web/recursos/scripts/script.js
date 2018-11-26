var puestos =[];
function MostrarHora(){
    var hora = new Date();
    var meridiano = "AM";
    if(hora.getHours()>=12){
        meridiano="PM";
    }
    var hora_Completa = hora.getHours()+" : "+hora.getMinutes()+" : "+hora.getSeconds()+" "+meridiano;
    document.getElementById("hora-entrada").innerText = hora_Completa;
    setTimeout("MostrarHora()",1000);
}

var bandera = true;
function MostrarModal( frm){
	modal = document.getElementsByClassName('modal-a');
	frmh = document.getElementsByClassName(''+frm+'');
		if(bandera === true){
                    if(frm === "frm-registra-user"){
                         $.get("/SAT-PRACO-spring/listaTipoDoc",
                        function(data){
                            for(i=0; i < data.length;i++){
                                $("#tipo-doc").append("<option value='"+data[i].id_documento+"'>"+data[i].nombre_doc+"</option>")  ;
                            }
                        });
                         $.get("/SAT-PRACO-spring/listacargos",
                        function(dataa){
                            
                            for(w=0 ; w < dataa.length;w++){
                                $("#list-cargo").append("<option value='"+dataa[w].id_cargo+"'>"+dataa[w].nombre_cargo+"</option>")  ;
                                //<option value='"+dataa[w].id_cargo+"'>"+dataa[w].nombre_cargo+"</option>
                            }
                        });
                        
                    }else if(frm === "frm-asigna-tarea"){
                        $.get("/SAT-PRACO-spring/listausers",
                        function(data){
                            for(i=0; i < data.length;i++){
                                $("#lstUsers").append("<option value='"+data[i].id_user+"'>"+data[i].nombre+"</option>")  ;
                            }
                        });
                        $.get("/SAT-PRACO-spring/listaTareas",
                        function(data){
                            for(i=0; i < data.length;i++){
                                $("#lstTreas").append("<option value='"+data[i].idTarea+"'>"+data[i].descripcion+"</option>")  ;
                            }
                        });
                    }else if(frm === "frm-registra-reporte"){
                        $.get("/SAT-PRACO-spring/listausers",
                        function(data){
                            for(i=0; i < data.length;i++){
                                $("#lstempleados").append("<option value='"+data[i].id_user+"'>"+data[i].nombre+"</option>")  ;
                            }
                        });
                       
                    }
                    
			modal[0].style.display = "block";
			frmh[0].style.display ="block";
			bandera = false;
                        
		
		}	else{
                    
			modal[0].style.display = "none";
			frmh[0].style.display ="none";
			bandera = true;

		}
		 
}
function RegistraUser(){
    var  nombre = $("#nombre").val();
    var apellidos = $("#apellidos").val();
    var dni = $("#dni").val();
    var tipoDoc = parseInt($("#tipo-doc").val()) ;
    var email = $("#email").val();
    var telefono = $("#telefono").val();
    var cargo =  parseInt($("#list-cargo").val());
    var fechnac = formato($("#fechanac").val());
    var estadoCivil = $("#estacivil").val();
    var sexo = $("#sexo").val();
    var nacionalidad = $("#nacionalidad").val();
    var domicilio = $("#domicilio").val();
     $.ajax({
        type: "post",
        url: "/SAT-PRACO-spring/registrauser",
        contentType: "application/json",
        data: JSON.stringify({
            Nombre :nombre,
            Apellido:apellidos,
            Email:email,
            Contacto:telefono,
            id_cargo:cargo,
            fecha_nac:fechnac,
            estado_civil:estadoCivil,
            sexo :sexo,
            nacionalidad :nacionalidad,
            domicilio:domicilio,
            id_Docimento :tipoDoc,
            nro_documento:dni}),
          success: function(data){
              alert(data);
          },error:function(){
              alert("no funca");
          }
        });
  
    
}

function formato(texto){
   var Fecha = texto.split("T");
   var newFecha = Fecha[0]+" "+Fecha[1];
   return newFecha;
}
 function RegistraTarea(){
     var idTarea = $("#lstTreas").val();
     var idSupervisor = 1;
     var idUsuario = $("#lstUsers").val();
     var fechaInicioE =$("#fechaInicioE").val();
     var fechaFinE = $("#fechaFinE").val();
     var obvs = $("#Descripcion").val();
     //alert(fechaInicioE+"   "+fechaFinE);
      $.ajax({
        type: "post",
        url: "/SAT-PRACO-spring/registratarea",
        contentType: "application/json",
        data: JSON.stringify({
            idtarealst :idTarea,
            idsupervisor:idSupervisor,
            idUser:idUsuario,
            HoraInicioE:fechaInicioE+":00",
            HoraTerminoE:fechaFinE+":00",
            observacion:obvs
            }),
          success: function(data){
              alert(data);
          },error:function(){
              alert("no funca");
          }
        });
 }
 
 function listTareasPorUser(user){
      var idUsuario = user;
      //var tareas ="sadsadad";
      $.ajax({
        type: "post",
        url: "/SAT-PRACO-spring/listaTareasPorUser",
        //contentType: "application/json",
        data: {id:idUsuario},
        success: function(data){
              console.log("tareas",data);
              var tamaño = data.length;
              for(i = 0 ; i < tamaño ; i++){
                  var fecha1 = moment(data[i].horaInicioE);
                  var fecha2 = moment(data[i].horaTerminoE);
                   var horas  = fecha2.diff(fecha1, 'hours');
                   var celdasLunes = document.getElementsByClassName("lunes");
                   var celdasMartes = document.getElementsByClassName("martes");
                   var celdasMiercoles = document.getElementsByClassName("miercoles");
                   var celdasJueves = document.getElementsByClassName("jueves");
                   var celdasviernes = document.getElementsByClassName("viernes");
                   var fecha = new Date(fecha1);
                    var dia = fecha.getUTCDay();
                    var hora = fecha.getHours();
                    var posicelda  ;
                   switch(hora){
                            case 8:
                               posicelda = 0;
                                break;
                            case 9:
                                posicelda = 1;
                                break;
                            case 10:
                               posicelda = 2;
                                break;
                            case 11:
                                posicelda = 3;
                                break;
                            case 12:
                               posicelda = 4;
                                break;
                            case 13:
                                posicelda = 5;
                                break;
                            case 14:
                               posicelda = 6;
                                break;
                            case 15:
                                posicelda = 7;
                                break;
                            case 16:
                                posicelda = 8;
                                break;
                       
                   }
                   for(w = 0; w < horas; w++){
                       posicelda = posicelda + 1;
                       switch (dia){
                            case 0:
                               alert("algo salio mal domingo");
                                break;
                            case 1:
                                celdasLunes[(posicelda-1)].innerHTML =data[i].observacion;
                                celdasLunes[(posicelda-1)].setAttribute("data-id",data[i].id_tarea);
                                break;
                            case 2:
                                celdasMartes[(posicelda-1)].innerHTML =data[i].observacion;
                                celdasMartes[(posicelda-1)].setAttribute("data-id",data[i].id_tarea);
                                break;
                            case 3:
                                celdasMiercoles[(posicelda-1)].innerHTML =data[i].observacion;
                                celdasMiercoles[(posicelda-1)].setAttribute("data-id",data[i].id_tarea);
                                break;
                            case 4:
                                celdasJueves[(posicelda-1)].innerHTML =data[i].observacion;
                                celdasJueves[(posicelda-1)].setAttribute("data-id",data[i].id_tarea);
                                break;
                            case 5:
                                celdasviernes[(posicelda-1)].innerHTML =data[i].observacion;
                                celdasviernes[(posicelda-1)].setAttribute("data-id",data[i].id_tarea);
                                break;
                            case 6:
                                alert("algo salio mal savado");
                       }
                       
                       //alert(w);
                   }
                    //alert(horas);
               // alert(celdas.length);
                  // $(".lunes").css("border","solid 1px red");
                  
              }
              
              console.log(fecha2.diff(fecha1, 'hours'), ' horas de diferencia');
          },
        error:function(){
              console.log("tareas","error");
          }
        });
   
     //return tareas;
 }
 function Login(){
     var nombre = $("#idusu").val();
     if (typeof(Storage) !== "undefined") {
         $.ajax({
        type: "post",
        url: "/SAT-PRACO-spring/Loguear",
        data: {id_user:nombre},
        success: function(data){
              //alert(data);
              if(data === ""){
                  //location.href  ="http://localhost:8090/SAT-PRACO-spring/empleado";
                  alert("usuario incorrecto");
              }else{
                  sessionStorage.setItem("datosUser",JSON.stringify(data));
                  if(data.id_cargo === 1){
                      location.href  ="http://localhost:8080/SAT-PRACO-spring/empleado";
                  }else if(data.id_cargo === 3){
                      location.href  ="http://localhost:8080/SAT-PRACO-spring/admin";
                  }else if(data.id_cargo === 2){
                      location.href  ="http://localhost:8080/SAT-PRACO-spring/Supervisor";
                  }else{
                      alert("algo salio mal");
                  }
                  
                    
                    
              }
          },
        error:function(){
              alert("no funca");
          }
        });
        
        
        
        
    } else {
        alert("SU NAVEGADOR NO SOPORTA LOCALSTORAGE");
    }
 }
 function muestraDatos(validador){
     
     
     if(sessionStorage.getItem("datosUser") === null){
        location.href  ="http://localhost:8080/SAT-PRACO-spring/login";
     }else{
          var datos = sessionStorage.getItem("datosUser");
         if(JSON.parse(datos).id_cargo === validador){
         var nombreUSu = JSON.parse(datos).nombre;
         var apellido = JSON.parse(datos).apellido;
         
        $("#inicialies").text(nombreUSu.slice(0,1)+"."+apellido.slice(0,1));
        console.log("datos",JSON.parse(datos));
        listTareasPorUser(JSON.parse(datos).id_user);
        ListaUserParaAdmin();
         }else{
             alert("USted no tiene atuotizacion para esta aqui");
             location.href  ="http://localhost:8080/SAT-PRACO-spring/login";
             sessionStorage.clear();
         }
         
       //console.log("tareas",tareas);
       //$("#titile").text(tareas);
     }
 }
 function BorrrarSeccion(){
     sessionStorage.clear();
     location.href  ="http://localhost:8080/SAT-PRACO-spring/login";
 }
 function ListaUserParaAdmin(){
     
      $.get("/SAT-PRACO-spring/listausers",
                        function(data){
                            for(i=0; i < data.length;i++){
                                $(".cont-list-users").append("<div class='cont-perfil-user' ><div class='cont-img-user'><img src='recursos/img/avatar.png' class='img-user'></div><div class='datos-user'><label> Nombre :</label> <span>"+data[i].nombre+"</span><br><label> Puesto :</label> <span>"+data[i].id_cargo+"</span><br><span onclick='MostrarModal('div-sueldo')'> ver sueldo</span>-<span onclick='MostrarModal('div-datos-user')'> ver datos</span></div></div>") ;
                            
                            }
                             console.log("users",data);
                        });
 }
 
 
  function RegistranNewTarea(){
     var desc = $("#descriptarea").val();
     var estado = $("#lstestado").val();
     var horas = $("#CantHoras").val();
     //alert(fechaInicioE+"   "+fechaFinE);
      $.ajax({
        type: "post",
        url: "/SAT-PRACO-spring/registraNeuevatarea",
        contentType: "application/json",
        data: JSON.stringify({
            horas :horas,
            descripcion:desc,
            estado:estado
            }),
          success: function(data){
              alert(data);
          },error:function(){
              alert("no funca");
          }
        });
 }
 
 
 function IniciarTerminar(elemnto){
        var d = new Date();
        var month = d.getMonth()+1;
        var day = d.getDate();
        var year = d.getFullYear();
        var hora = d.getHours();
        var minutos = d.getMinutes();
        var segundos = d.getSeconds();
        if(minutos<10){
            minutos ="0"+minutos;
        }
         if(segundos<10){
            segundos ="0"+segundos;
        }
        var fecha = year+"-"+month+"-"+day+"T"+hora+":"+minutos+":"+segundos;
        var ele = elemnto.getAttribute("data-id");
          $.ajax({
        type: "post",
        url: "/SAT-PRACO-spring/registraInioTarea",
        contentType: "application/json",
        data:JSON.stringify( {
            HoraInicio :fecha,
            id_tarea:ele
            }),
          success: function(data){
               alert(data);
          },error:function(){
              alert("no funca");
          }
        });
    
 }
 
 function TerminarTarea(elemnto){
        var d = new Date();
        var month = d.getMonth()+1;
        var day = d.getDate();
        var year = d.getFullYear();
        var hora = d.getHours();
        var minutos = d.getMinutes();
        var segundos = d.getSeconds();
        if(minutos<10){
            minutos ="0"+minutos;
        }
         if(segundos<10){
            segundos ="0"+segundos;
        }
        var fecha = year+"-"+month+"-"+day+"T"+hora+":"+minutos+":"+segundos;
        var ele = elemnto.getAttribute("data-id");
          $.ajax({
        type: "post",
        url: "/SAT-PRACO-spring/registraFinTarea",
        contentType: "application/json",
        data:JSON.stringify( {
            HoraTermino :fecha,
            id_tarea:ele
            }),
          success: function(data){
              alert(data);
          },error:function(){
              alert("no funca");
          }
        });
    }
    function listaTareasParaReporte(){
        var d = new Date();
        var month = d.getMonth()+1;
        var day = d.getDate();
        var year = d.getFullYear();
        var hora = d.getHours();
        var minutos = d.getMinutes();
        var segundos = d.getSeconds();
        if(minutos<10){
            minutos ="0"+minutos;
        }
         if(segundos<10){
            segundos ="0"+segundos;
        }
        var fechar = year+"-"+month+"-"+day+"T"+hora+":"+minutos+":"+segundos;
        var tareasincun = 0;
        var tareascumplidas = 0;
        var horas =0;
        var promedio = 0;
        var idusu = $("#lstempleados").val();
        var fecha = $("#fechadesde").val();
          $.ajax({
        type: "post",
        url: "/SAT-PRACO-spring/listaTareasParaReporte",
        contentType: "application/json",
        data:JSON.stringify( {
            idUser :idusu,
            Fechatarea:fecha+":00"
            }),
          success: function(data){
              console.log("data",data);
              for(i=0;i<data.length;i++){
                  $("#tareas").append("<tr><td>"+data[i].observacion+"</td><td>"+data[i].fechatarea+"</td><td>"+data[i].horaInicioE+"</td><td>"+data[i].horaInicio+"</td><td>"+data[i].horaTermino+"</td></tr>");
                  
                  if(data[i].horaInicio === null){
                      tareasincun = tareasincun+ 1;
                  }
                  if(data[i].horaTermino !== null){
                      tareascumplidas = tareascumplidas +1;
                  }
                   
                   if(data[i].horaInicio !== null && data[i].horaTermino !== null){
                       var fecha1 = moment(data[i].horaInicio);
                       var fecha2 = moment(data[i].horaTermino);
                       horas  = horas + fecha2.diff(fecha1, 'hours');
                   }
                    
              }
              promedio = horas/data.length;
              RegistraReporte(idusu,tareascumplidas,tareasincun,promedio,fechar);
              $("#resumen").text("tareas incumplidas : "+tareasincun+" tareas cumplidas : "+tareascumplidas+" promedio de horas : "+promedio);
                  
             
    
          },error:function(){
              alert("no funca 2");
          }
        });
        
    }
    function RegistraReporte(idus,tc,ti,pt,fecha){
           $.ajax({
        type: "post",
        url: "/SAT-PRACO-spring/RegistraReporte",
        contentType: "application/json",
        data:JSON.stringify( {
            idUsu :idus,
            tareasCumplidas:tc,
            tareasIncumplidas:ti,
            promedioTiempo:pt,
            fechaReporte:fecha
            }),
          success: function(data){
              console.log("data",data);
          },error:function(){
              alert("no funca 2");
          }
        });
        
    }

 
