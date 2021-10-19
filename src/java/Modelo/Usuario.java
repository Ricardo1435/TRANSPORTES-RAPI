package Modelo;

public class Usuario {
    private String  pass, correo; 
    public Usuario() {
    }

    public Usuario(String pass, String correo) {
        this.pass = pass;
        this.correo = correo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
}