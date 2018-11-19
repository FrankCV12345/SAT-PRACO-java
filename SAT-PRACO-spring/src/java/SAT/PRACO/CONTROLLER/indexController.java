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
import SAT.PRACO.MODEL.documentoModel;
import SAT.PRACO.MODEL.CargoModel;
import SAT.PRACO.MODEL.USER_MODEL;
import SAT.PRACO.DAO.OperacionesTipoDoc;
import com.google.gson.Gson;
import java.util.List;

/**
 *
 * @author SARA
 */
@Controller
public class indexController {
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
    
   /* public @ResponseBody String RegistraEntrada(){
        return "ADASDSD"; 
    }*/
   @RequestMapping(value="/registraIngreso",method = RequestMethod.POST)
   public @ResponseBody String RegistraEntrada(@RequestBody String id_user){
        OperacionesUser opeUser = new OperacionesUser();
        String  n = id_user.replaceAll("id_user=E", "");
        int id = Integer.parseInt(n);
        //int id = Integer.parseInt(id_user);
        String rpta = opeUser.RegistraIngreso(id);
        return rpta; 
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
   public @ResponseBody String registrUser(@RequestBody String objuser){
        OperacionesUser opeUser = new OperacionesUser();
        USER_MODEL usuario  = new Gson().fromJson(objuser, USER_MODEL.class);
        //USER_MODEL("pedrito","clavo","pedrito@gmail.com","990412967",2,"10/10/1996","S","M","PERUANO","SU CASA 4",1,"71055663");
       
        String rpta =opeUser.Registrouser(usuario);
        return rpta; 
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
    
    
}
