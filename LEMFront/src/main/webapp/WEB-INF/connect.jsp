<%@page import="java.util.List"%>
<%@page import="model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>


<head>
<meta charset="UTF-8">

<title>LEM Connexion</title>
</head>

<body>

	<div class="container-fluid" id="background">
	

		<div class="row" id="topconnect">
		
		<div class="col-3">
		<img  id="logo" src="img/LogoLoLGrey.png" class = "img-fluid" />
		</div>
		
		<div class="col-1"></div>
		<div class="col-4">
		<div id="bienvenue">Bienvenue sur <br>LOL Esport Manager</div>
		</div>
		
		<div class="col-3"></div>
		
		</div>

		<div class="row" id="midconnect">
		


			<div class="col-4"></div>
			
			<div  class="col-4"> <!-- ; align-self-center mx-auto; style="vertical-align: middle" -->
				
					<button id="btnLogin" type="button" class="btn btn-warning btn-lg btn-block boutonJaune">Login</button>
					<br />
					<!-- Disparait quand on click dessus (methode dans le script) -->
				

				<form id="formConnect" method="POST" action="connect"> <!-- le formulaire de connection -->

					<input type="text" name="login" placeholder="Identifiant" class="form-control" /><br />
					<input type="password" name="password" placeholder="Mot de Passe" class="form-control"><br />
					<input	type="submit" placeholder="Valider"	class="btn btn-warning btn-lg btn-block boutonJaune" value="Connexion">	
					<!-- Apparait lorsque l'on clique (methode dans le script) -->

				</form>
				
				<img  id="gem" src="./img/gemRed.png" />
				<br/><br/>
				
				<form method="GET" action="inscription">
					<!-- Envoie sur la page d'inscription -->
					<button type="submit" class="btn btn-warning btn-lg btn-block boutonJaune" value="Inscription">Inscription</button>
					<br />
				</form>
				<div id = "error" class="text-danger" >${erreur}</div>


			</div>
			
			<div class="col-4">
			</div>
			
		</div>
		

	
	
	<div id="botconnect" class="row">
	
		<div class="col-2"></div>
		
		<div id="termsOfUse" class="col-3">Terms of use</div>
		<div class="col-2"></div>
		<div id="contact" class="col-3">Contacts</div>
		<div class="col-2"></div>
		<br/>
		<div id="copyright" class="col-12">Copyright© 2020 Thibault,Kodo,Florian</div>
	</div>
</div>

</body>





<script>

var formConnect=document.getElementById("formConnect");
var btnLogin = document.getElementById("btnLogin");
btnLogin.onclick=hideForm;

function hideForm(){	
	formConnect.style.display="block";
	//permet de faire apparaitre le formConnect
	btnLogin.style.display="none";
	//Fait disparaitre le btnLogin	
}

</script>
</html>