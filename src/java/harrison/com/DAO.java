/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harrison.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Harrison
 */
public class DAO {
    
    private Connection con;

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
    public void Conectar() throws Exception{
        try {
           // Class.forName("com.mysql.jdbc.Drvier");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/primefaces","root","");
        } catch (Exception ex) {
            throw  ex;
        }
        
    }
    
    public void Cerrar()throws Exception{
        try{
        if(con != null){
            if(con.isClosed() == false){
                con.close();
            }
        }
    }catch(Exception ex){
        throw  ex;
    }
    }
}
