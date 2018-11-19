/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAT.PRACO.DAO;
import SAT.PRACO.bd.bdConnection;
import java.sql.Connection;
import SAT.PRACO.IDAO.IOpercaionesCargo;
import SAT.PRACO.MODEL.CargoModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SARA
 */
public class OpercaionesModel implements IOpercaionesCargo {

    @Override
    public List<CargoModel> listaCArgo() {
        bdConnection objCon = new bdConnection();
        Connection con = objCon.EstablecerConexion();
        String rpta ="";
        List<CargoModel> listacargo = new ArrayList<>();
         try{
            PreparedStatement pst = con.prepareStatement("{ call proc_list_cargo}");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                listacargo.add(new CargoModel(rs.getInt(1),rs.getString(2)) );
            }
            objCon.desconectar();
        }catch( SQLException e){
             
            rpta = ""+e;
        }
        return listacargo;
        
    }
    
}
