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
