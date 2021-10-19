package Modelo;

public class Conductor {
    private String idConductor, nombresConductor, apellidosConductor; 
    
    public Conductor() {
    }

    public Conductor(String idConductor, String nombresConductor, String apellidosConductor) {
        this.idConductor = idConductor;
        this.nombresConductor = nombresConductor;
        this.apellidosConductor = apellidosConductor;
    }

    public String getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(String idConductor) {
        this.idConductor = idConductor;
    }

    public String getNombresConductor() {
        return nombresConductor;
    }

    public void setNombresConductor(String nombresConductor) {
        this.nombresConductor = nombresConductor;
    }

    public String getApellidosConductor() {
        return apellidosConductor;
    }

    public void setApellidosConductor(String apellidosConductor) {
        this.apellidosConductor = apellidosConductor;
    }
    
    
}