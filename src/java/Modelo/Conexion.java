package Modelo;
import java.sql.Connection;
import java.sql.*;

public class Conexion {
     Connection con;
     String url="jdbc:oracle:thin:@localhost:1521/XEPDB1";
      String user="Proyecto";
       String pass="1234";
     public Connection conectar(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnection(url,user,pass);
        }catch(Exception e){
            System.out.println("Error: "+e);
        } 
        return con;
    }
}