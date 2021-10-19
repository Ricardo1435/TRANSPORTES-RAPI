package Modelo;
public class Vehiculo {
    private String matricula, aliasVehiculo, cantidadAsientos, nombresConductor, apellidosConductor; 

        
    public Vehiculo() {
    }

    public Vehiculo(String matricula, String aliasVehiculo, String cantidadAsientos, String nombresConductor, String apellidosConductor) {
        this.matricula = matricula;
        this.aliasVehiculo = aliasVehiculo;
        this.cantidadAsientos = cantidadAsientos;
        this.nombresConductor = nombresConductor;
        this.apellidosConductor = apellidosConductor;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getAliasVehiculo() {
        return aliasVehiculo;
    }

    public void setAliasVehiculo(String aliasVehiculo) {
        this.aliasVehiculo = aliasVehiculo;
    }

    public String getCantidadAsientos() {
        return cantidadAsientos;
    }

    public void setCantidadAsientos(String cantidadAsientos) {
        this.cantidadAsientos = cantidadAsientos;
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