/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAT.PRACO.DAO;
import SAT.PRACO.bd.bdConnection;
import SAT.PRACO.IDAO.IOperacionesUser;
import SAT.PRACO.MODEL.USER_MODEL;
import SAT.PRACO.MODEL.model_tareaUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class OperacionesUser implements IOperacionesUser  {

    @Override
    public String RegistraIngreso(int id_user) {
        bdConnection objCon = new bdConnection();
        Connection con = objCon.EstablecerConexion();
        String rpta ="";
        try{
            PreparedStatement pst = con.prepareStatement("{ call Proc_busca_usu (?)}");
            pst.setInt(1, id_user);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                PreparedStatement pst2 = con.prepareStatement("{ call Proc_verRI (?)}");
                 pst2.setInt(1, id_user);
                  ResultSet rs2 = pst2.executeQuery();
                if(rs2.next()){
                    rpta="USETED YA SE REGISTRO SU INGRESO";
                }else{
                    PreparedStatement pst3 = con.prepareStatement("{ call Proc_reg_entrada (?)}");
                    pst3.setInt(1, id_user);
                      pst3.execute();
                     rpta=" registrado correctamente";
                }
            }else{
            rpta="USUARIO NO EXISTE";
            }
               
           
            objCon.desconectar();
        }catch( SQLException e){
             
            rpta = ""+e;
        }
        return rpta;
    }

    @Override
    public String RegistroSalida(int id_user) {
        bdConnection objCon = new bdConnection();
        Connection con = objCon.EstablecerConexion();
        String rpta ="";
        try{
            PreparedStatement pst = con.prepareStatement("{ call Proc_busca_usu (?)}");
            pst.setInt(1, id_user);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                 PreparedStatement pst2 = con.prepareStatement("{ call proc_fechaingreso (?)}");
                 int horas = 0;
                 pst2.setInt(1, id_user);
                  ResultSet rs2 = pst2.executeQuery();
                  while(rs2.next()){
                        horas = rs2.getInt(1);
                  }
                   PreparedStatement pst3 = con.prepareStatement("{ call proc_registrasalida (?,?)}");
                    pst3.setInt(1, id_user);
                    pst3.setInt(2, horas);
                   pst3.execute();
                  rpta = " se registro su salida , las horas trabajadas son "+horas;
                  
                }else{
                rpta="USUARIO NO EXISTE";
            }
            
            
        }catch(SQLException e){
            rpta = ""+e.getMessage();
        }
        return rpta;
    }

    @Override
    public String Registrouser(USER_MODEL usu) {
         bdConnection objCon = new bdConnection();
        Connection con = objCon.EstablecerConexion();
        String rpta ="";
        try{
            PreparedStatement pst = con.prepareStatement("{ call proc_registra_user (?,?,?,?,?,?,?,?,?,?,?,?)}");
            pst.setString(1, usu.getNombre());
            pst.setString(2, usu.getApellido());
            pst.setString(3, usu.getEmail());
            pst.setString(4,usu.getContacto());
            pst.setInt(5, usu.getId_cargo());
            pst.setString(6, usu.getFecha_nac());
            pst.setString(7, usu.getEstado_civil());
            pst.setString(8,usu.getSexo());
            pst.setString(9,usu.getNacionalidad());
            pst.setString(10,usu.getDomicilio());
            pst.setInt(11, usu.getId_Docimento());
            pst.setString(12, usu.getNro_documento());
             pst.execute();
            rpta = pst.getUpdateCount() > 0 ? "REGISTRADO CORRECTAMENTE" : "NO  SE PUDO REGISTRAR";
        }catch(SQLException e){
            rpta =""+e.getMessage();
        }
        return rpta;
    }

    @Override
    public String Registarea(model_tareaUser tarea) {
        bdConnection objCon = new bdConnection();
        Connection con = objCon.EstablecerConexion();
        String rpta ="";
        try{
            PreparedStatement pst = con.prepareStatement("{ call proc_asignaTarea    (?,?,?,?,?,?)}");
            pst.setString(1,tarea.getHoraInicioE());
            pst.setString(2,tarea.getHoraTerminoE());
            pst.setInt(3,tarea.getIdUser());
            pst.setString(4,tarea.getObservacion());
            pst.setInt(5,tarea.getIdtarealst());
            pst.setInt(6,tarea.getIdsupervisor());
            pst.execute();
            rpta = pst.getUpdateCount() > 0 ? "REGISTRADO CORRECTAMENTE" : "NO  SE PUDO REGISTRAR";
        }catch(SQLException e){
             rpta =""+e.getMessage();
    }
        return rpta;
        
    }

    @Override
    public List<USER_MODEL> ListaUsers() {
        bdConnection objCon = new bdConnection();
        Connection con = objCon.EstablecerConexion();
        String rpta ="";
        List<USER_MODEL> listaUSer = new ArrayList<>();
        try{
            PreparedStatement pst = con.prepareStatement("proc_listaUser");
           
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                listaUSer.add(new USER_MODEL(rs.getInt(1),rs.getString(2)));
                
            }
            
        }catch(SQLException e){
            rpta = ""+e.getMessage();
        }
        return listaUSer;
    }

    @Override
    public List<model_tareaUser> listaTareasPorUSer(int id_user) {
         bdConnection objCon = new bdConnection();
        Connection con = objCon.EstablecerConexion();
        String rpta ="";
        List<model_tareaUser> listaTareas = new ArrayList<>();
        try{
            PreparedStatement pst = con.prepareStatement("{ call proc_listTareasPorUser (?)}");
            pst.setInt(1, id_user);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                listaTareas.add(
                        new model_tareaUser(
                        rs.getInt(1),
                        rs.getInt(7),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(2)
                        ,rs.getString(3),
                         rs.getString(4),
                         rs.getString(5)
                         ,rs.getString(6),
                          rs.getString(8)
                        ));
            }
        }catch(SQLException e){
            rpta = ""+e.getMessage();
        }
        return listaTareas;
    }

    @Override
    public USER_MODEL Login(int iduser) {
         bdConnection objCon = new bdConnection();
        Connection con = objCon.EstablecerConexion();
        String rpta ="";
        USER_MODEL user = null;
        try{
            PreparedStatement pst = con.prepareStatement("{ call Proc_Login (?)}");
            pst.setInt(1, iduser);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                user = new USER_MODEL(rs.getInt(1),rs.getInt(4),rs.getString(2),rs.getString(3));
            }
            
        }catch(SQLException e){
            rpta = ""+e.getMessage();
        }
       return user;
    }

 
    
}
