<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login-Incorrecto</title>
<link href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round" rel="stylesheet">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="icon" href="IMG/advertencia.png">

<style>
    body {
          font-family: 'Varela Round', sans-serif;
          background: gray;
	}

	.modal-confirm .modal-content {
		padding: 20px;
		border-radius: 5px;
		border: none;
               text-align: center;
		font-size: 14px;
	}
	.modal-confirm .modal-header {
		border-bottom: none;   
        position: relative;
	}
	.modal-confirm h4 {
		text-align: center;
		font-size: 26px;
		margin: 30px 0 -10px;
	}
	.modal-confirm .close {
                position: absolute;
		top: -5px;
		right: -2px;
	}
	.modal-confirm .modal-body {
		color: #000;
	}
	.modal-confirm .modal-footer {
		border: none;
		text-align: center;		
		border-radius: 5px;
		font-size: 13px;
		padding: 10px 15px 25px;
	}
			
	.modal-confirm .icon-box {
		width: 80px;
		height: 80px;
		margin: 0 auto;
		border-radius: 50%;
		z-index: 9;
		text-align: center;
		border: 3px solid #f15e5e;
	}
	.modal-confirm .icon-box i {
		color: #f15e5e;
		font-size: 46px;
		display: inline-block;
		margin-top: 13px;
	}
    #btnAceptar{
                color: #fff;
                border-radius: 4px;
		background: #60c7c1;
		text-decoration: none;
                line-height: normal;
		min-width: 120px;
                border: none;
		min-height: 40px;
		border-radius: 3px;
		margin: 0 5px;
		
    }

	
</style>
</head>
<body>


<!-- Modal HTML -->
<div id="myModal" class="modal-dialog">
    <div class="modal-dialog modal-confirm">
       <div class="modal-content">
	      <div class="modal-header">
		<div class="icon-box">
		   <i class="material-icons">&#xE5CD;</i>
		  </div>				
		<h4 class="modal-title">Error</h4>	
		</div>
		<div class="modal-body">
		<p>Ha ocurrido un error en el inicio de sesión, verifica que los datos ingresados sean correctos.</p>
		</div>
		<div class="modal-footer">
                   <a href="index.jsp"> <input type="button" class="btn btn-outline-info" value="ACEPTAR"  id="btnAceptar"></a> 
		</div>
		</div>
	</div>
</div>     
</body>
</html>                            