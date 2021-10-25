package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ClienteDAO {
   PreparedStatement ps;
    ResultSet rs;
    Conexion c = new Conexion();
    Connection con;
    
    public List listar(){
        List <Cliente>lista = new ArrayList<>();
        String sql="SELECT * FROM CLIENTE ORDER BY id_cliente";
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Cliente cli = new Cliente();
                cli.setIdCliente(rs.getString(1));
                cli.setDpi(rs.getString(2));
                cli.setNombresCliente(rs.getString(3));
                cli.setApellidosCliente(rs.getString(4));
                cli.setEdadCliente(rs.getString(5));
                lista.add(cli);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
    public int agregar(Cliente cli){
        int r=0;
     String sql="INSERT INTO CLIENTE(id_cliente, dpi, nombres_cliente, apellidos_cliente, edad_cliente) VALUES(?,?,?,?,?)";
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, cli.getIdCliente());
            ps.setString(2, cli.getDpi());
            ps.setString(3, cli.getNombresCliente());
            ps.setString(4, cli.getApellidosCliente());
            ps.setString(5, cli.getEdadCliente());
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
    
    public Cliente listarID(String idCliente){
        Cliente cli = new Cliente();
        String sql= ("SELECT * FROM cliente WHERE (id_cliente = '"+idCliente+"')");
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                cli.setIdCliente(rs.getString(1));
                cli.setDpi(rs.getString(2));
                cli.setNombresCliente(rs.getString(3));
                cli.setApellidosCliente(rs.getString(4));
                cli.setEdadCliente(rs.getString(5));
            }
        } catch (Exception e) {
        }
        return cli;
    }
    
   public int actualizar(Cliente cli){
        int r=0;
        String sql="UPDATE cliente SET dpi=?, nombres_cliente=?, apellidos_cliente=?, edad_cliente=? WHERE (id_cliente=?)";
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, cli.getDpi());
            ps.setString(2, cli.getNombresCliente());
            ps.setString(3, cli.getApellidosCliente());
            ps.setString(4, cli.getEdadCliente());
            ps.setString(5, cli.getIdCliente());
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
   
   
   public void eliminar(String idCliente){
        String sql="DELETE FROM cliente WHERE (id_cliente = '"+idCliente+"')";
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
   
    public List buscar(String texto){
        List <Cliente> lista = new ArrayList<>();
        String sql="SELECT * FROM CLIENTE WHERE id_cliente LIKE '%"+texto+"%' OR dpi LIKE '%"+texto+"%' OR nombres_cliente LIKE '%"+texto+"%' OR apellidos_cliente LIKE '%"+texto+"%' OR edad_cliente LIKE '%"+texto+"%'";
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Cliente cl = new Cliente();
                cl.setIdCliente(rs.getString("id_cliente"));
                cl.setDpi(rs.getString("dpi"));
                cl.setNombresCliente(rs.getString("nombres_cliente"));
                cl.setApellidosCliente(rs.getString("apellidos_cliente"));
                cl.setEdadCliente(rs.getString("edad_cliente"));
                lista.add(cl);
            }
        } catch (Exception e) {
        }
        return lista;
    }
}
