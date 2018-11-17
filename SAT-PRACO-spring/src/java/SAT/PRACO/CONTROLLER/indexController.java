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
    
    
}
