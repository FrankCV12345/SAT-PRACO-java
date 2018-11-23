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
     var fechaInicioE =formato($("#fechaInicioE").val());
     var fechaFinE = formato($("#fechaFinE").val());
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
            HoraInicioE:fechaInicioE,
            HoraTerminoE:fechaFinE,
            observacion:obvs
            }),
          success: function(data){
              alert(data);
          },error:function(){
              alert("no funca");
          }
        });
 }
 
 function listTareasPorUser(){
      var idUsuario = 3;
      $.ajax({
        type: "post",
        url: "/SAT-PRACO-spring/listaTareasPorUser",
        //contentType: "application/json",
        data: {id:idUsuario},
        success: function(data){
              alert(data);
          },
        error:function(){
              alert("no funca");
          }
        });
   
     
 }
 function Login(){
     var nombre = $("#idusu").val();
     if (typeof(Storage) !== "undefined") {
        sessionStorage.setItem("nombre", nombre);
        location.href  ="http://localhost:8090/SAT-PRACO-spring/empleado";
    } else {
        document.getElementById("result").innerHTML = "Sorry, your browser does not support Web Storage...";
    }
 }
 function muestraDatos(){
     
     
     if(sessionStorage.getItem("nombre") === null){
        location.href  ="http://localhost:8090/SAT-PRACO-spring/login";
     }else{
         alert(sessionStorage.getItem("nombre"));
     }
 }
 function BorrrarSeccion(){
     sessionStorage.clear();
     location.href  ="http://localhost:8090/SAT-PRACO-spring/login";
 }
 
