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
 function registra(){
     
      $.ajax({
        type: "post",
        url: "/SAT-PRACO-spring/registrauser",
        contentType: "application/json",
        data: JSON.stringify({
            Nombre :nombre,
            Apellido:apellidos,
            Email:email
            }),
          success: function(data){
              alert(data);
          },error:function(){
              alert("no funca");
          }
        });
 }