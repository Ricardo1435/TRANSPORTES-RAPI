package Modelo;

public class Cliente {
    private String idCliente, dpi, nombresCliente, apellidosCliente, edadCliente; 
    public Cliente() {
    }

    public Cliente(String idCliente, String dpi, String nombresCliente, String apellidosCliente, String edadCliente) {
        this.idCliente = idCliente;
        this.dpi = dpi;
        this.nombresCliente = nombresCliente;
        this.apellidosCliente = apellidosCliente;
        this.edadCliente = edadCliente;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }


    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
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

    public String getEdadCliente() {
        return edadCliente;
    }

    public void setEdadCliente(String edadCliente) {
        this.edadCliente = edadCliente;
    }
    
    
}
