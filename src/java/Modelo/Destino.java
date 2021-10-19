
package Modelo;

public class Destino {
    private String idDestino, nombreDestino, precioBoleto, matricula, aliasVehiculo; 

    public Destino() {
    }

    public Destino(String idDestino, String nombreDestino, String precioBoleto, String matricula, String aliasVehiculo) {
        this.idDestino = idDestino;
        this.nombreDestino = nombreDestino;
        this.precioBoleto = precioBoleto;
        this.matricula = matricula;
        this.aliasVehiculo = aliasVehiculo;
    }

    public String getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(String idDestino) {
        this.idDestino = idDestino;
    }

    public String getNombreDestino() {
        return nombreDestino;
    }

    public void setNombreDestino(String nombreDestino) {
        this.nombreDestino = nombreDestino;
    }

    public String getPrecioBoleto() {
        return precioBoleto;
    }

    public void setPrecioBoleto(String precioBoleto) {
        this.precioBoleto = precioBoleto;
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
        
        

}
