package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    PreparedStatement ps;
    ResultSet rs;
    Conexion c = new Conexion();
    Connection con;
   
    public int validar(Usuario u){
        String sql="SELECT * FROM USUARIO WHERE correo=? AND password=?";
         int r=0;
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, u.getCorreo());
            ps.setString(2, u.getPass());
            rs=ps.executeQuery();
            while(rs.next()){
                r=r+1;
                u.setCorreo(rs.getString("correo"));
                u.setPass(rs.getString("password"));
            }
            if(r==1){
                return 1;
            }else{
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }
    }
    
    public int agregar(Usuario u){
        int r=0;
     String sql="INSERT INTO USUARIO(correo, password) VALUES(?,?)";
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, u.getCorreo());
            ps.setString(2, u.getPass());
            r=ps.executeUpdate();
            if(r==1){
                r=1;
            }else{
                r=0;
            }
        } catch (Exception e) {
        }
        return r;
    }
}