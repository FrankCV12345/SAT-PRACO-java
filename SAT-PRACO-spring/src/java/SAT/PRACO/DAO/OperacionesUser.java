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
            PreparedStatement pst = con.prepareStatement("{ call dbo.Proc_reg_entrada (?)}");
            pst.setInt(1, id_user);
            pst.execute();
            rpta = pst.getUpdateCount() > 0 ? "ENTRADA REGISTRADA": "USUARIO NO ENCONTRADO";
            objCon.desconectar();
        }catch( SQLException e){
            e.printStackTrace();
        }
        return rpta;
    }
    
}
