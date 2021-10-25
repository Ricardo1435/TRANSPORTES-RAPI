package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VehiculoDAO {
   PreparedStatement ps;
   ResultSet rs;
   Conexion c = new Conexion();
   Connection con;
   
     public List listar(){
        List <Vehiculo>lista = new ArrayList<>();
        String sql="SELECT vehiculo.matricula, vehiculo.alias_vehiculo, vehiculo.cantidad_asientos, conductor.nombres_conductor, conductor.apellidos_conductor \n" +
                    "FROM vehiculo, conductor WHERE vehiculo.id_conductor=conductor.id_conductor  ORDER BY vehiculo.matricula";
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Vehiculo vehi = new Vehiculo();
                vehi.setMatricula(rs.getString(1));
                vehi.setAliasVehiculo(rs.getString(2));
                vehi.setCantidadAsientos(rs.getString(3));
                vehi.setNombresConductor(rs.getString(4));
                vehi.setApellidosConductor(rs.getString(5));
                lista.add(vehi);
            }
        } catch (Exception e) {
        }
        return lista;
    }
     
      public int agregar(Vehiculo vehi){
        int r=0;
        String sql="INSERT INTO vehiculo(matricula, alias_vehiculo, cantidad_asientos, id_conductor) VALUES(?,?,?,?)";
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, vehi.getMatricula());
            ps.setString(2, vehi.getAliasVehiculo());
            ps.setString(3, vehi.getCantidadAsientos());
            ps.setString(4, vehi.getNombresConductor());
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
      
      public Vehiculo listarID(String matricula){
        Vehiculo vehi = new Vehiculo();
        String sql= ("SELECT * FROM VEHICULO WHERE (matricula = '"+matricula+"')");
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                vehi.setMatricula(rs.getString(1));
                vehi.setAliasVehiculo(rs.getString(2));
                vehi.setCantidadAsientos(rs.getString(3));
                vehi.setNombresConductor(rs.getString(4));
            }
        } catch (Exception e) {
        }
        return vehi;
    }
     public int actualizar(Vehiculo vehi){
        int r=0;
        String sql="UPDATE vehiculo SET alias_vehiculo=?, cantidad_asientos=?, id_conductor=? WHERE (matricula=?)";
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, vehi.getAliasVehiculo());
            ps.setString(2, vehi.getCantidadAsientos());
            ps.setString(3, vehi.getNombresConductor());
            ps.setString(4, vehi.getMatricula());
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
     
     public void eliminar(String matricula){
        String sql="DELETE FROM vehiculo WHERE (matricula = '"+matricula+"')";
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
     
       public List buscar(String texto){
        List <Vehiculo> lista = new ArrayList<>();
        String sql="SELECT vehiculo.matricula, vehiculo.alias_vehiculo, vehiculo.cantidad_asientos, conductor.nombres_conductor, conductor.apellidos_conductor \n" +
                    "FROM vehiculo, conductor WHERE vehiculo.id_conductor=conductor.id_conductor AND vehiculo.matricula LIKE '%"+texto+"%'";
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Vehiculo veh = new Vehiculo();
                veh.setMatricula(rs.getString("matricula"));
                veh.setAliasVehiculo(rs.getString("alias_vehiculo"));
                veh.setCantidadAsientos(rs.getString("cantidad_asientos"));
                veh.setNombresConductor(rs.getString("nombres_conductor"));
                veh.setApellidosConductor(rs.getString("apellidos_conductor"));
                lista.add(veh);
            }
        } catch (Exception e) {
        }
        return lista;
    }
}