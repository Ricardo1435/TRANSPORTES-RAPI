<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*;"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>      
        <script src="https://kit.fontawesome.com/85601d370d.js" crossorigin="anonymous"></script>
        <link href="CSS/estilos.css" rel="stylesheet">
        <!-- Favicon -->
        <link rel="icon" href="IMG/bus.svg">
        <title>Editar Destino</title>
    </head>
    <body>
        <!-- Barra de Navegacion -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-secondary">
                <a class="navbar-brand"> <i class="fas fa-bus"></i>&nbsp;&nbsp;TRANSPORTES RAPI</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                  <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item active">
                            <a class="nav-link">Editar Destino <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="DestinoIndex.jsp">Destinos<span class="sr-only">(current)</span></a>
                        </li>
                    </ul>
                </div>
        </nav>
        
        <!-- Formulario -->
        <form class="bg-light container-md mt-5 mb-5 " action="ControladorDestino" method="POST">
                <center><h2 class="mt-2 mb-2"> EDITAR DESTINO &nbsp;&nbsp;<i class="fas fa-edit"></i></h2> </center>
            <div>
                <input type="hidden" class="form-control" autocomplete="off" name="ingresoIdDestino" placeholder="Ingrese ID del destino"  maxlength="25" value="${destino.getIdDestino()}" required>
            </div>
            <div>
                <b><label for="ingresoNombreDestino" class="mt-2">NOMBRE</label></b>
                <input type="text" class="form-control" autocomplete="off" name="ingresoNombreDestino" placeholder="Ingrese nombre del destino" maxlength="75" value="${destino.getNombreDestino()}" required> 
            </div>
            <div>
                <b><label for="ingresoPrecioBoleto" class="mt-2">PRECIO DEL BOLETO</label></b>
                <input type="number" class="form-control" autocomplete="off" step="0.01" min="1" name="ingresoPrecioBoleto" placeholder="Ingrese el precio del boleto" value="${destino.getPrecioBoleto()}" required>
            </div>
            <div>
               <b><label for="ingresoMatricula" class="mt-2">VEHICULO</label></b>
                <select class="custom-select" name="ingresoMatricula" id="ingresoMatricula" required>
                    <option value="${destino.getMatricula()}">--Cambiar Vehiculo--</option>
                    <%
                        try {
                              String sql="SELECT * FROM vehiculo";
                              Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
                              String url="jdbc:oracle:thin:@localhost:1521/XEPDB1";
                              String user="Proyecto";
                              String pass="1234";
                              Connection conn=DriverManager.getConnection(url,user,pass);
                              Statement stm =conn.createStatement();
                              ResultSet rs=stm.executeQuery(sql);
                              while(rs.next()){
                                  %>
                                  <option value="<%=rs.getString("matricula")%>">Matricula:&nbsp;"<%=rs.getString("matricula")%>"&nbsp;-&nbsp;Alias:&nbsp;"<%=rs.getString("alias_vehiculo")%>"</option>
                                  <%
                              }
                            } catch (Exception e) {
                            }
                    %>
                </select>        
            </div>
            <button type="submit" class="btn btn-primary my-3" id="btnGuardar" name="accion" value="Actualizar">Guardar &nbsp;&nbsp;<i class="fas fa-save"></i></button> 
           <a href="DestinoIndex.jsp"> <input type="button" value="Cancelar" class="btn btn-danger" id="btnCancelar"></a> 
           
        </form>

    </body>
</html>