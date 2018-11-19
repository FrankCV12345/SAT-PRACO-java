/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAT.PRACO.DAO;
import SAT.PRACO.bd.bdConnection;
import java.sql.Connection;
import SAT.PRACO.IDAO.IoperacionesTipoDoc;
import SAT.PRACO.MODEL.documentoModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SARA
 */
public class OperacionesTipoDoc implements  IoperacionesTipoDoc{

    @Override
    public List<documentoModel> listTipoDoc() {
        bdConnection objCon = new bdConnection();
        Connection con = objCon.EstablecerConexion();
        String rpta ="";
        List<documentoModel> listaTipoDoc = new ArrayList<>();
         try{
            PreparedStatement pst = con.prepareStatement("{ call proc_list_tipo_doc}");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                listaTipoDoc.add(new documentoModel(rs.getInt(1),rs.getString(2)) );
            }
            objCon.desconectar();
        }catch( SQLException e){
             
            rpta = ""+e;
        }
        return listaTipoDoc;
    }
    
}
