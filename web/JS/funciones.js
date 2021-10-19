$(document).ready(function () {
    $("tr #btnEliminarCliente").click(function () {
        var idCliente = $(this).parent().find("#idCliente").val();
     swal({
            title: "¿Estas seguro de eliminar?",
            text: "Si lo eliminas no podrás recuperarlo!",
            type: "warning",
            showCancelButton: true,
            confirmButtonClass: "btn-danger",
            confirmButtonText: "Eliminar!",
            cancelButtonClass: "btn-secondary",
            cancelButtonText: "Cancelar!",
            closeOnConfirm: false,
            closeOnCancel: false
        },
                function (isConfirm) {
                    if (isConfirm) {
                        eliminarCliente(idCliente);
                        swal("Eliminado!", "El registro se ha eliminado", "success");
                        setTimeout(function (){
                            parent.location.href="ClienteIndex.jsp";
                        }, 1500);
                    } else {
                        swal("Cancelado", "No se eliminó el registro", "error");
                    }
                });
    });

    function eliminarCliente(idCliente) {
        var url = "ControladorCliente?accion=Eliminar&idCliente=" + idCliente;
        $.ajax({
            type: 'POST',
            url: url,
            async: true,
            data: "idCliente=" + idCliente,
            success: function (data, textStatus, jqXHR) {
            }
        })
    }

  $("tr #btnEliminarConductor").click(function () {
        var idConductor = $(this).parent().find("#idConductor").val();
     swal({
            title: "¿Estas seguro de eliminar?",
            text: "Si lo eliminas no podrás recuperarlo!",
            type: "warning",
            showCancelButton: true,
            confirmButtonClass: "btn-danger",
            confirmButtonText: "Eliminar!",
            cancelButtonClass: "btn-secondary",
            cancelButtonText: "Cancelar!",
            closeOnConfirm: false,
            closeOnCancel: false
        },
                function (isConfirm) {
                    if (isConfirm) {
                        eliminarConductor(idConductor);
                        swal("Eliminado!", "El registro se ha eliminado", "success");
                        setTimeout(function (){
                            parent.location.href="ConductorIndex.jsp";
                        }, 1500);
                    } else {
                        swal("Cancelado", "No se eliminó el registro", "error");
                    }
                });
    });

    function eliminarConductor(idConductor) {
        var url = "ControladorConductor?accion=Eliminar&idConductor=" + idConductor;
        $.ajax({
            type: 'POST',
            url: url,
            async: true,
            data: "idConductor=" + idConductor,
            success: function (data, textStatus, jqXHR) {
            }
        })
    }
 $("tr #btnEliminarVehiculo").click(function () {
        var matricula = $(this).parent().find("#matricula").val();
     swal({
            title: "¿Estas seguro de eliminar?",
            text: "Si lo eliminas no podrás recuperarlo!",
            type: "warning",
            showCancelButton: true,
            confirmButtonClass: "btn-danger",
            confirmButtonText: "Eliminar!",
            cancelButtonClass: "btn-secondary",
            cancelButtonText: "Cancelar!",
            closeOnConfirm: false,
            closeOnCancel: false
        },
                function (isConfirm) {
                    if (isConfirm) {
                        eliminarVehiculo(matricula);
                        swal("Eliminado!", "El registro se ha eliminado", "success");
                        setTimeout(function (){
                            parent.location.href="VehiculoIndex.jsp";
                        }, 1500);
                    } else {
                        swal("Cancelado", "No se eliminó el registro", "error");
                    }
                });
    });

    function eliminarVehiculo(matricula) {
        var url = "ControladorVehiculo?accion=Eliminar&matricula=" + matricula;
        $.ajax({
            type: 'POST',
            url: url,
            async: true,
            data: "matricula=" + matricula,
            success: function (data, textStatus, jqXHR) {
            }
        })
    }
    
     $("tr #btnEliminarDestino").click(function () {
        var idDestino = $(this).parent().find("#idDestino").val();
     swal({
            title: "¿Estas seguro de eliminar?",
            text: "Si lo eliminas no podrás recuperarlo!",
            type: "warning",
            showCancelButton: true,
            confirmButtonClass: "btn-danger",
            confirmButtonText: "Eliminar!",
            cancelButtonClass: "btn-secondary",
            cancelButtonText: "Cancelar!",
            closeOnConfirm: false,
            closeOnCancel: false
        },
                function (isConfirm) {
                    if (isConfirm) {
                        eliminarDestino(idDestino);
                        swal("Eliminado!", "El registro se ha eliminado", "success");
                        setTimeout(function (){
                            parent.location.href="DestinoIndex.jsp";
                        }, 1500);
                    } else {
                        swal("Cancelado", "No se eliminó el registro", "error");
                    }
                });
    });

    function eliminarDestino(idDestino) {
        var url = "ControladorDestino?accion=Eliminar&idDestino=" + idDestino;
        $.ajax({
            type: 'POST',
            url: url,
            async: true,
            data: "idDestino=" + idDestino,
            success: function (data, textStatus, jqXHR) {
            }
        })
    }
$("tr #btnEliminarViajero").click(function () {
        var idViajero = $(this).parent().find("#idViajero").val();
     swal({
            title: "¿Estas seguro de eliminar?",
            text: "Si lo eliminas no podrás recuperarlo!",
            type: "warning",
            showCancelButton: true,
            confirmButtonClass: "btn-danger",
            confirmButtonText: "Eliminar!",
            cancelButtonClass: "btn-secondary",
            cancelButtonText: "Cancelar!",
            closeOnConfirm: false,
            closeOnCancel: false
        },
                function (isConfirm) {
                    if (isConfirm) {
                        eliminarViajero(idViajero);
                        swal("Eliminado!", "El registro se ha eliminado", "success");
                        setTimeout(function (){
                            parent.location.href="ViajeroIndex.jsp";
                        }, 1500);
                    } else {
                        swal("Cancelado", "No se eliminó el registro", "error");
                    }
                });
    });

    function eliminarViajero(idViajero) {
        var url = "ControladorViajero?accion=Eliminar&idViajero=" + idViajero;
        $.ajax({
            type: 'POST',
            url: url,
            async: true,
            data: "idViajero=" + idViajero,
            success: function (data, textStatus, jqXHR) {
            }
        })
    }
});