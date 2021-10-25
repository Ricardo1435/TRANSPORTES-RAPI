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
        <title>Agregar Viajero</title>
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
                            <a class="nav-link">Agregar Viajero <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="ViajeroIndex.jsp">Viajeros<span class="sr-only">(current)</span></a>
                        </li>
                    </ul>
                </div>
        </nav>
        
        <!-- Formulario -->
        <form class="bg-light container-md mt-5 mb-5 " action="ControladorViajero" method="POST">
            <center><h2 class="mt-2 mb-2"> REGISTRO DE VIAJEROS &nbsp;&nbsp;&nbsp;<i class="fas fa-pen-alt"></i></h2> </center>
            <div>
               <b><label for="ingresoCliente" class="mt-2">CLIENTE</label></b>
                <select class="custom-select" name="ingresoCliente" id="ingresoCliente" required>
                    <option>--Seleccione una opcion--</option>
                    <%
                        try {
                              String sql="SELECT * FROM cliente";
                              Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
                              String url="jdbc:oracle:thin:@localhost:1521/XEPDB1";
                              String user="Proyecto";
                              String pass="1234";
                              Connection conn=DriverManager.getConnection(url,user,pass);
                              Statement stm =conn.createStatement();
                              ResultSet rs=stm.executeQuery(sql);
                              while(rs.next()){
                                  %>
                                  <option value="<%=rs.getString("id_cliente")%>"><%=rs.getString("nombres_cliente")%>&nbsp;<%=rs.getString("apellidos_cliente")%></option>
                                  <%
                              }
                            } catch (Exception e) {
                            }
                    %>
                </select>        
            </div>
            <div>
               <b><label for="ingresoDestino" class="mt-2">DESTINO</label></b>
                <select class="custom-select" name="ingresoDestino" id="ingresoDestino" required>
                    <option>--Seleccione una opcion--</option>
                    <%
                        try {
                              String sql="SELECT * FROM destino";
                              Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
                              String url="jdbc:oracle:thin:@localhost:1521/XEPDB1";
                              String user="Proyecto";
                              String pass="1234";
                              Connection conn=DriverManager.getConnection(url,user,pass);
                              Statement stm =conn.createStatement();
                              ResultSet rs=stm.executeQuery(sql);
                              while(rs.next()){
                                  %>
                                  <option value="<%=rs.getString("id_destino")%>"><%=rs.getString("nombre_destino")%></option>
                                  <%
                              }
                            } catch (Exception e) {
                            }
                    %>
                </select>        
            </div>
            <div>
                <b><label for="ingresoAsiento" class="mt-2">ASIENTO</label></b>
                <input type="number" class="form-control" autocomplete="off" name="ingresoAsiento" min="1" pattern="^[0-9]+" placeholder="Ingrese asiento del cliente" required>
            </div>
            <div>
                <b><label for="ingresoFechaViaje" class="mt-2">FECHA Y HORA</label></b>
                <input type="text" class="form-control" autocomplete="off" name="ingresoFechaViaje" placeholder="DD/MM/AAAA HH:MM TT" required>
            </div>
            <div>
                <input type="hidden" class="form-control" autocomplete="off" name="ingresoCorreo" value="${correo}">
            </div>
            <button type="submit" class="btn btn-primary my-3" id="btnGuardar" name="accion" value="Guardar">Guardar &nbsp;&nbsp;<i class="fas fa-save"></i></button> 
           <a href="ViajeroIndex.jsp"> <input type="button" value="Cancelar" class="btn btn-danger" id="btnCancelar"></a> 
           
        </form>

    </body>
</html>