/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAT.PRACO.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Administrador
 */
public class bdConnection {
    private String url ="jdbc:sqlserver://DESKTOP-1TI9C90:1433;databaseName=BDSatPraco";
    private String login ="fcv";
    private String password ="123";
    private String driver ="com.microsoft.sqlserver.jdbc.SQLServerDriver";    
    Connection conn =null;
    public Connection EstablecerConexion(){
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,login,password);    
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }        
        return conn;
    }
    public void desconectar(){
        try{ 
            conn.close();
        }catch(SQLException E){
            E.printStackTrace();
        }
    }
    
}
