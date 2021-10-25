package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ViajeroDAO {
   PreparedStatement ps;
   ResultSet rs;
   Conexion c = new Conexion();
   Connection con;
   
   public List listar(){
        List <Viajero>lista = new ArrayList<>();
        String sql="SELECT cliente_destino.ROWID, cliente_destino.id_cliente, cliente.nombres_cliente, cliente.apellidos_cliente, cliente_destino.id_destino, destino.nombre_destino, cliente_destino.asiento, to_char(cliente_destino.fecha_viaje, 'DD/MM/YYYY HH:MI AM'), cliente_destino.correo \n" +
                    "FROM cliente_destino, cliente, destino, usuario WHERE cliente_destino.id_cliente=cliente.id_cliente AND cliente_destino.id_destino=destino.id_destino AND cliente_destino.correo=usuario.correo ORDER BY cliente.nombres_cliente";
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Viajero via = new Viajero();
                via.setRowId(rs.getString(1));
                via.setIdCliente(rs.getString(2));
                via.setNombresCliente(rs.getString(3));
                via.setApellidosCliente(rs.getString(4));
                via.setIdDestino(rs.getString(5));
                via.setNombreDestino(rs.getString(6));
                via.setAsiento(rs.getString(7));
                via.setFechaViaje(rs.getString(8));
                via.setCorreo(rs.getString(9));
                lista.add(via);
            }
        } catch (Exception e) {
        }
        return lista;
    }
   
   public int agregar(Viajero via){
        int r=0;
        String sql="INSERT INTO CLIENTE_DESTINO (ID_CLIENTE, ID_DESTINO, ASIENTO, FECHA_VIAJE, CORREO) VALUES (?, ?, ?, TO_DATE(?, 'DD/MM/YYYY HH12:MI AM'), ?)";
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, via.getIdCliente());
            ps.setString(2, via.getIdDestino());
            ps.setString(3, via.getAsiento());
            ps.setString(4, via.getFechaViaje());
            ps.setString(5, via.getCorreo());
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
   
   public Viajero listarID(String idViajero){
        Viajero via = new Viajero();
        String sql= ("SELECT ROWID, id_cliente, id_destino, asiento, TO_CHAR(fecha_viaje, 'DD/MM/YYYY HH:MI AM'), correo FROM cliente_destino WHERE (ROWID = '"+idViajero+"')");
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                via.setRowId(rs.getString(1));
                via.setIdCliente(rs.getString(2));
                via.setIdDestino(rs.getString(3));
                via.setAsiento(rs.getString(4));
                via.setFechaViaje(rs.getString(5));
                via.setCorreo(rs.getString(6));
            }
        } catch (Exception e) {
        }
        return via;
    }
   
   public int actualizar(Viajero via){
        int r=0;
        String sql="UPDATE CLIENTE_DESTINO SET ID_CLIENTE = ?, ID_DESTINO = ?, ASIENTO = ?, FECHA_VIAJE = TO_DATE(?, 'DD/MM/YYYY HH12:MI AM'), CORREO = ? WHERE ROWID = ?";
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, via.getIdCliente());
            ps.setString(2, via.getIdDestino());
            ps.setString(3, via.getAsiento());
            ps.setString(4, via.getFechaViaje());
            ps.setString(5, via.getCorreo());
            ps.setString(6, via.getRowId());
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
   
    public void eliminar(String idViajero){
        String sql="DELETE FROM CLIENTE_DESTINO WHERE (ROWID = '"+idViajero+"')";
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
     public List buscar(String texto){
        List <Viajero> lista = new ArrayList<>();
        String sql="SELECT cliente_destino.ROWID, cliente_destino.id_cliente, cliente.nombres_cliente, cliente.apellidos_cliente, cliente_destino.id_destino, destino.nombre_destino, cliente_destino.asiento, to_char(cliente_destino.fecha_viaje, 'DD/MM/YYYY HH:MI AM'), cliente_destino.correo FROM cliente_destino, cliente, destino, usuario WHERE cliente_destino.id_cliente=cliente.id_cliente AND cliente_destino.id_destino=destino.id_destino AND cliente_destino.correo=usuario.correo AND cliente.nombres_cliente LIKE '%"+texto+"%'";
        try {
            con=c.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Viajero via = new Viajero();
                via.setRowId(rs.getString(1));
                via.setIdCliente(rs.getString(2));
                via.setNombresCliente(rs.getString(3));
                via.setApellidosCliente(rs.getString(4));
                via.setIdDestino(rs.getString(5));
                via.setNombreDestino(rs.getString(6));
                via.setAsiento(rs.getString(7));
                via.setFechaViaje(rs.getString(8));
                via.setCorreo(rs.getString(9));
                lista.add(via);
            }
        } catch (Exception e) {
        }
        return lista;
    }
}
    

