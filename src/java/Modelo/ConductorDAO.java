package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ConductorDAO {
   PreparedStatement ps;
    ResultSet rs;
    Conexion c = new Conexion();
    Connection con;
    
    public List listar(){
        List <Conductor>lista = new ArrayList<>();
        String sql="SELECT * FROM CONDUCTOR order by nombres_conductor asc";
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Conductor cond = new Conductor();
                cond.setIdConductor(rs.getString(1));
                cond.setNombresConductor(rs.getString(2));
                cond.setApellidosConductor(rs.getString(3));
                lista.add(cond);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
     public int agregar(Conductor cond){
        int r=0;
     String sql="INSERT INTO CONDUCTOR(id_conductor, nombres_conductor, apellidos_conductor) VALUES(?,?,?)";
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, cond.getIdConductor());
            ps.setString(2, cond.getNombresConductor());
            ps.setString(3, cond.getApellidosConductor());
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
     
     public Conductor listarID(String idConductor){
        Conductor cond = new Conductor();
        String sql= ("SELECT * FROM CONDUCTOR WHERE (id_conductor = '"+idConductor+"')");
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                cond.setIdConductor(rs.getString(1));
                cond.setNombresConductor(rs.getString(2));
                cond.setApellidosConductor(rs.getString(3));
            }
        } catch (Exception e) {
        }
        return cond;
    }
    
    public int actualizar(Conductor cond){
        int r=0;
        String sql="UPDATE conductor SET nombres_conductor=?, apellidos_conductor=? WHERE (id_conductor=?)";
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, cond.getNombresConductor());
            ps.setString(2, cond.getApellidosConductor());
            ps.setString(3, cond.getIdConductor());
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
    
    public void eliminar(String idConductor){
        String sql="DELETE FROM conductor WHERE (id_conductor = '"+idConductor+"')";
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
   
    public List buscar(String texto){
        List <Conductor> lista = new ArrayList<>();
        String sql="SELECT * FROM conductor WHERE id_conductor LIKE '%"+texto+"%' OR nombres_conductor LIKE '%"+texto+"%' OR apellidos_conductor LIKE '%"+texto+"%' order by nombres_conductor asc ";
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Conductor co = new Conductor();
                co.setIdConductor(rs.getString("id_conductor"));
                co.setNombresConductor(rs.getString("nombres_conductor"));
                co.setApellidosConductor(rs.getString("apellidos_conductor"));
                lista.add(co);
            }
        } catch (Exception e) {
        }
        return lista;
    }
   
}