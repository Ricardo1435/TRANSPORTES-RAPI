package Modelo;

public class Viajero {
    private String rowId, idCliente, idDestino, asiento, fechaViaje, correo, nombresCliente, apellidosCliente, nombreDestino; 

    public Viajero() {
    }

    public Viajero(String rowId, String idCliente, String idDestino, String asiento, String fechaViaje, String correo, String nombresCliente, String apellidosCliente, String nombreDestino) {
        this.rowId = rowId;
        this.idCliente = idCliente;
        this.idDestino = idDestino;
        this.asiento = asiento;
        this.fechaViaje = fechaViaje;
        this.correo = correo;
        this.nombresCliente = nombresCliente;
        this.apellidosCliente = apellidosCliente;
        this.nombreDestino = nombreDestino;
    }

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }


    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(String idDestino) {
        this.idDestino = idDestino;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public String getFechaViaje() {
        return fechaViaje;
    }

    public void setFechaViaje(String fechaViaje) {
        this.fechaViaje = fechaViaje;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombresCliente() {
        return nombresCliente;
    }

    public void setNombresCliente(String nombresCliente) {
        this.nombresCliente = nombresCliente;
    }

    public String getApellidosCliente() {
        return apellidosCliente;
    }

    public void setApellidosCliente(String apellidosCliente) {
        this.apellidosCliente = apellidosCliente;
    }

    public String getNombreDestino() {
        return nombreDestino;
    }

    public void setNombreDestino(String nombreDestino) {
        this.nombreDestino = nombreDestino;
    }

}
