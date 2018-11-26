/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAT.PRACO.CONTROLLER;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import SAT.PRACO.DAO.OperacionesUser;
import SAT.PRACO.DAO.OpercaionesModel;
import SAT.PRACO.DAO.OperacionesTarea;
import SAT.PRACO.MODEL.Tarea_model;
import SAT.PRACO.MODEL.documentoModel;
import SAT.PRACO.MODEL.CargoModel;
import SAT.PRACO.MODEL.USER_MODEL;
import SAT.PRACO.MODEL.model_tareaUser;
import SAT.PRACO.DAO.OperacionesTipoDoc;
import SAT.PRACO.MODEL.ReporteModel;
import com.google.gson.Gson;
import java.util.List;

/**
 *
 * @author SARA
 */
@Controller
public class indexController {
    OperacionesUser opeuser = new OperacionesUser();
    OperacionesTarea operTarea = new OperacionesTarea();
    
    
    @RequestMapping(value="/",method= RequestMethod.GET)
    public String index(){
    return "Entrada";
    }
    @RequestMapping(value="/salida",method= RequestMethod.GET)
    public String salida(){
    return "salida";
    }
    @RequestMapping(value="/admin",method= RequestMethod.GET)
    public String ViewAdmin(){
    return "adminview";
    }
    @RequestMapping(value="/Supervisor",method= RequestMethod.GET)
    public String ViewSupervisor(){
    return "SuepervisorView";
    }
    @RequestMapping(value="/empleado",method= RequestMethod.GET)
    public String ViewEmpleado(){
    return "EmpleadoView";
    }
    @RequestMapping(value="/login",method= RequestMethod.GET)
    public String ViewLogin(){
    return "Login";
    }
   
   @RequestMapping(value="/registraIngreso",method = RequestMethod.POST)
   public @ResponseBody String RegistraEntrada(@RequestBody String id_user){
        OperacionesUser opeUser = new OperacionesUser();
        String  n = id_user.replaceAll("id_user=E", "");
        int id = Integer.parseInt(n);
        //int id = Integer.parseInt(id_user);
        String rpta = opeUser.RegistraIngreso(id);
        return rpta; 
    }
    @RequestMapping(value="/Loguear",method = RequestMethod.POST, produces="application/json")
   public @ResponseBody USER_MODEL Loguear(@RequestBody String id_user){
        USER_MODEL usuario = null;
        String  n = id_user.replaceAll("id_user=E", "");
        int id = Integer.parseInt(n);
        //int id = Integer.parseInt(id_user);
        usuario = opeuser.Login(id);
        return usuario; 
    }
      @RequestMapping(value="/registraSalida",method = RequestMethod.POST)
   public @ResponseBody String RegistraSalida(@RequestBody String id_user){
        OperacionesUser opeUser = new OperacionesUser();
        String  n = id_user.replaceAll("id_user=E", "");
        int id = Integer.parseInt(n);
        //int id = Integer.parseInt(id_user);
        String rpta = opeUser.RegistroSalida(id);
        return rpta; 
    }
     @RequestMapping(value="/registrauser",method = RequestMethod.POST)
   public @ResponseBody String registrUser(@RequestBody String objJson){
        OperacionesUser opeUser = new OperacionesUser();
        USER_MODEL usuario  = new Gson().fromJson(objJson, USER_MODEL.class);
        //USER_MODEL("pedrito","clavo","pedrito@gmail.com","990412967",2,"10/10/1996","S","M","PERUANO","SU CASA 4",1,"71055663");
        String rpta =opeUser.Registrouser(usuario);
        return rpta; 
    }
   
    @RequestMapping(value="/registratarea",method = RequestMethod.POST)
   public @ResponseBody String RegistraTarea(@RequestBody String objJson){
        model_tareaUser tarea  = new Gson().fromJson(objJson, model_tareaUser.class);
        String rpta =opeuser.Registarea(tarea);
        return rpta; 
    }
    @RequestMapping(value="/registraNeuevatarea",method = RequestMethod.POST)
   public @ResponseBody String RegistraNewTarea(@RequestBody String objJson){
        Tarea_model tarea  = new  Gson().fromJson(objJson, Tarea_model.class);
        String rpta =operTarea.Addtarea(tarea);
        return rpta; 
    }
   
      @RequestMapping(value="/listaTareas",method = RequestMethod.GET, produces="application/json")
   public @ResponseBody List<Tarea_model> listaTareas(){
        List<Tarea_model> lstTareas = operTarea.listaTareas() ;
        return lstTareas; 
    }
      @RequestMapping(value="/listaTipoDoc",method = RequestMethod.GET, produces="application/json")
   public @ResponseBody List<documentoModel> listaDoc(){
        OperacionesTipoDoc opeTIpoDOc = new OperacionesTipoDoc();
        List<documentoModel> lstTipoDoc = opeTIpoDOc.listTipoDoc() ;
        return lstTipoDoc; 
    }
      @RequestMapping(value="/listacargos",method = RequestMethod.GET, produces="application/json")
   public @ResponseBody List<CargoModel> listaCargo(){
        OpercaionesModel opecargo = new OpercaionesModel();
        List<CargoModel> listacargos = opecargo.listaCArgo();
        return listacargos; 
    }
      @RequestMapping(value="/listausers",method = RequestMethod.GET, produces="application/json")
   public @ResponseBody List<USER_MODEL> listaUser(){
        List<USER_MODEL> listaUser = opeuser.ListaUsers();
        return listaUser; 
    }
  
 
      @RequestMapping(value="/listaTareasPorUser",method = RequestMethod.POST, produces="application/json")
   public @ResponseBody List<model_tareaUser>  listaTareasPorUser(@RequestBody String id_user){
          String  n = id_user.replaceAll("id=", "");
        int id = Integer.parseInt(n);
        List<model_tareaUser> lsta  = opeuser.listaTareasPorUSer(id);
        return lsta; 
    }
   
       @RequestMapping(value="/registraInioTarea",method = RequestMethod.POST)
   public @ResponseBody String RegistraInicioTarea(@RequestBody String objJson){
        
       model_tareaUser tarea = new Gson().fromJson(objJson, model_tareaUser.class);
        String rpta = opeuser.InicioTarea(tarea.getHoraInicio(),tarea.getId_tarea());
        return rpta; 
    }
   
         @RequestMapping(value="/registraFinTarea",method = RequestMethod.POST)
   public @ResponseBody String RegistraFinTarea(@RequestBody String objJson){
       model_tareaUser tarea = new Gson().fromJson(objJson, model_tareaUser.class);
        String rpta = opeuser.FinTarea(tarea.getHoraTermino(),tarea.getId_tarea());
        return rpta; 
    }
  
       @RequestMapping(value="/listaTareasParaReporte",method = RequestMethod.POST, produces="application/json")
   public @ResponseBody List<model_tareaUser>  listaTareasParaReporte(@RequestBody String objJson){
        model_tareaUser tarea = new Gson().fromJson(objJson,model_tareaUser.class);
        List<model_tareaUser> lsta  = opeuser.listatareasPorFEchayuser(tarea);
        return lsta; 
    }
   
         @RequestMapping(value="/RegistraReporte",method = RequestMethod.POST, produces="application/json")
   public @ResponseBody String RegistraReporte(@RequestBody String objJson){
        ReporteModel reporte = new Gson().fromJson(objJson,ReporteModel.class);
        String rpta  = opeuser.RegistraReporte(reporte);
        return rpta; 
    }
   
}
    
