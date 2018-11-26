/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAT.PRACO.DAO;
import SAT.PRACO.IDAO.IOperacionesTarea;
import SAT.PRACO.MODEL.Tarea_model;
import SAT.PRACO.bd.bdConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author SARA
 */
public class OperacionesTarea implements IOperacionesTarea {

    @Override
    public List<Tarea_model> listaTareas() {
         bdConnection objCon = new bdConnection();
        Connection con = objCon.EstablecerConexion();
        String rpta ="";
        List<Tarea_model> listTareas = new ArrayList<>();
        try{
            PreparedStatement pst = con.prepareStatement("proc_listTareas");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                listTareas.add(new Tarea_model(rs.getInt(1),rs.getInt(3),rs.getString(2),rs.getString(4)));
            }
        }catch(SQLException e){
            rpta =""+e.getMessage();
        }
          return listTareas;
    }

    @Override
    public String Addtarea(Tarea_model tarea) {
         bdConnection objCon = new bdConnection();
        Connection con = objCon.EstablecerConexion();
        String rpta ="";
        try{
            PreparedStatement pst = con.prepareStatement("{call insertaTareas(?,?,?)}");
            pst.setString(1, tarea.getDescripcion());
            pst.setInt(2,tarea.getHoras());
            pst.setString(3, tarea.getEstado());
            pst.execute();
            rpta = pst.getUpdateCount() > 0 ? "REGISTRADO CORRECTAMENTE" : "NO  SE PUDO REGISTRAR"; 
        }catch(SQLException e){
            rpta =""+e.getMessage();
        }
        return rpta;
    }

   
  
    
}
