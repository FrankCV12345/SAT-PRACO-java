/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAT.PRACO.DAO;
import SAT.PRACO.bd.bdConnection;
import SAT.PRACO.IDAO.IOperacionesUser;
import SAT.PRACO.MODEL.USER_MODEL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OperacionesUser implements IOperacionesUser  {

    @Override
    public String RegistraIngreso(int id_user) {
        bdConnection objCon = new bdConnection();
        Connection con = objCon.EstablecerConexion();
        String rpta = "";
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
            e.printStackTrace();
        }
        return rpta;
    }
    
}
