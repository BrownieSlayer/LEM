<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>


</style>
<head>
<meta charset="UTF-8">

</head>

<body id = "background">

<div class="container-fluid">

<div id="ligne"></div>

<img id="logoLoL" src="./img/LogoLoLGrey.png"/>



<div id="topBandeau" class="row">

            <div class="col-2"></div>
            <div id="titre1" class="col-2">LoL Esport</div>
            <div class="col-2"></div>
            <div class="col-1"></div>
            <div class="col-3"></div>
            <div class="col-2"></div>

        </div>
		
        <div id="topBandeau2" class="row">

            <div class="col-2"></div>
            <div id="titre2" class="col-2">MANAGER</div>
            <div class="col-2"></div>
            <div class="col-1"></div>
            <div class="col-1"></div>
            <div class="col-1"></div>
            <div class="col-1"></div>
            <div class="col-2"></div>
</div>

<div id = "inscriptionForm"> 
    <form id="form1" action="inscription" method="POST">
 		<input type="hidden" name="action" value="inscription">
 		
 		<!-- INSCRIPTION -->
 		<div class = "row">
 			<div class="col-5"></div>
 			<div id = "inscriptionTitre" class="col-2">INSCRIPTION</div>
 			<div class="col-5"></div>
 		</div>
 		
 		 <!-- Boutons manager et Joueur -->
 		 <div class = "row">
	 		<div class="col-4"></div>
	 		<div class="btn-group btn-group-toggle col-4 espacementForm" data-toggle="buttons">
	  			<label class="btn btn-outline-warning active boutonJaune2">
	    			<input required checked onChange="changeType('Joueur')" name="typeCompte" type="radio" value="Joueur"> Joueur
	  			</label>
	  			<label class="btn btn-outline-warning boutonJaune2">
	   				 <input required onChange="changeType('Manager')" name="typeCompte" type="radio" value="Manager"> Manager
	  			</label>
			</div>
			<div class="col-4"></div>
 		</div>
 		
 		<!-- Nom & Prénom -->
 		<div class = "row">
 			<div class="col-4"></div>
	 		<div class="input-group col-4 espacementForm">
	  			<div class="input-group-prepend">
	    			<span class="input-group-text">Nom & Prénom</span>
	  			</div>
	  			<input placeholder="Nom" class="form-control" type="text" required name="nom">
	  			<input placeholder="Prénom" class="form-control" type="text" required name="prenom">
			</div>
			<div class="col-4"></div>
 		</div>

		<!-- Pseudo -->
        <div class = "row">
       		<div class="col-4"></div>
	        <div class="input-group flex-nowrap col-4 espacementForm">
	  			<div class="input-group-prepend">
	  				<span class="input-group-text" id="addon-wrapping">Pseudo</span>
	    			<span class="input-group-text" id="addon-wrapping">@</span>
	  			</div>
	  			<input placeholder="Pseudo" class="form-control" id="pseudo" type="text" required name="pseudo" />
			</div>
			<div class="col-4"></div>
		</div>
 		
 		<!-- Login -->
 		<div class = "row">
 			<div class="col-4"></div>
	       	<div class="input-group flex-nowrap col-4 espacementForm">
	  			<div class="input-group-prepend">
	    			<span class="input-group-text">Login</span>
	  			</div>
	  			<input placeholder="Login" class="form-control" id="loginForm" type="text" required name="login" />
			</div>
			<div class="col-4"></div>
		</div>
       	
       	<!-- Password -->
       	<div class = "row">
       		<div class="col-4"></div>
	        <div class="input-group flex-nowrap col-4 espacementForm">
	  			<div class="input-group-prepend">
	    			<span class="input-group-text">Mot de passe</span>
	  			</div>
	  			<input id = "password" placeholder="Mot de passe" class="form-control" type="password" required name="password" />
			</div>
			<div class="col-4"></div>
		</div>
		
		<!-- CheckPassword -->
       	<div class = "row">
 			<div class="col-4"></div>
	       	<div class="input-group flex-nowrap col-4 espacementForm">
	  			<div class="input-group-prepend">
	    			<span class="input-group-text">Vérification de mot de passe</span>
	  			</div>
	  			<input placeholder="Vérification de MDP" class="form-control" id="checkPassword" type="password" required name="login" />
			</div>
			<div class="col-4"></div>
		</div>
        
        <!-- Equipe -->
        <div class = "row">
        	<div class="col-4"></div>
	        <div class="input-group flex-nowrap col-4 espacementForm">
	  			<div class="input-group-prepend">
	  				<span class="input-group-text" id="addon-wrapping">Equipe</span>
	  			</div>
	  			<input id = "equipeForm" placeholder="laisser vide si vous ne faites parti d'aucune équipe" class="form-control" type="text" required name="equipe" value="aucune"/> 
			</div>
			<div class="col-4"></div>
		</div>
   	
   		<!-- Submit Manager -->
        <div class="row">
        	<div class="col-5"></div>
        	<div class="col-2"><input style="display:none;" type="submit" id="btnM" class="btn btn-warning col 2 espacementForm boutonValider" value ="Valider"></div>
        	<div class="col-5"></div>
        </div>
        
        <!-- Boutons Rôles -->
        <div class = "row">
       	 	<div class="col-4"></div>
	 		<div class="btn-group btn-group-toggle champJoueur col-4 espacementForm" data-toggle="buttons">
	  			<label class="btn btn-warning active">
	    			<input required checked name="role" type="radio" value="Top"/>  Top
	  			</label>
	  			<label class="btn btn-warning">
	   				 <input required name="role" type="radio" value="Jungler"/> Jungler
	  			</label>
	  			<label class="btn btn-warning">
	   				 <input required name="role" type="radio" value="Mid"/> Mid
	  			</label>
	  			<label class="btn btn-warning">
	   				 <input required name="role" type="radio" value="ADC"/> ADC
	  			</label>
	  			<label class="btn btn-warning">
	   				  <input required name="role" type="radio" value="Support"/> Support
	  			</label>
			</div>
			<div class="col-4"></div>
		</div>
        
         <!-- Salaire -->   
        <div class = "row">
        	<div class="col-4"></div>
	        <div class="input-group mb-3 champJoueur col-4 espacementForm">
	  				<div class="input-group-prepend">
	  					<span class="input-group-text">Salaire minimal souhaité</span>
	  				</div>
	  				<input type="text" class="form-control" name= "salmin">
	  				<div class="input-group-prepend">
	  					<span class="input-group-text">€</span>
	    				<span class="input-group-text">0.00</span>
	    			</div>
	    	</div>
	    	<div class="col-4"></div>
    	</div>
   
    	 <!-- Statistiques --> 
    	<div class = "row">
    		<div class="col-3"></div>
			<div class="input-group mb-3 champJoueur col-6 espacementForm">
					<div class="input-group-prepend">
	  					<span class="input-group-text">Eliminations moyennes</span>
	  				</div>
	  					<input type="text" class="form-control" class="formJ" name="elimination">
	  				<div class="input-group-prepend">
	
	    				<span class="input-group-text">0.00</span>
	    			</div>
	    			
	    			<div class="input-group-prepend">
	  					<span class="input-group-text">Morts moyennes</span>
	  				</div>
	  					<input type="text" class="form-control" class="formJ" name="mort">
	  				<div class="input-group-prepend">
	    				<span class="input-group-text">0.00</span>
	    			</div>
	    			
	    			<div class="input-group-prepend">
	  					<span class="input-group-text">Assistances moyennes</span>
	  				</div>
	  					<input type="text" class="form-control" class="formJ" name="assist">
	  				<div class="input-group-prepend">
	    				<span class="input-group-text">0.00</span>
	    			</div>	
	        </div>
	        <div class="col-3"></div>
        </div>

        <div class = "row">
       		<div class="col-5"></div>
         	<input type="submit" id="btnJ" class="btn btn-warning col 2 espacementForm boutonValider" value ="Valider">
         	<div class="col-5"></div>
        </div>
      </form>
 </div>
 
 <div id = botBandeauInscription> </div>
 </div>
</body>
<script>

var cj=document.getElementsByClassName("formJ");
var divcj=document.getElementsByClassName("champJoueur");

var errorLogin=false;
var errorPseudo=false;

function changeType(type)
{
    if(type=="Joueur")
    {
    	
    	$("#btnJ").show();
    	$("#btnM").hide();
        for(var i=0;i<cj.length;i++)
        {
            cj[i].style.visibility="visible";
            cj[i].required=true;
        }
        
        for(var i=0;i<divcj.length;i++)
        {
            divcj[i].style.visibility="visible";
            divcj[i].required=true;
        }
 
    }
    else
    {
    	$("#btnJ").hide();
    	$("#btnM").show();
        for(var i=0;i<cj.length;i++)
        {
            cj[i].style.visibility="hidden";
            cj[i].required=false;
        }
        
        for(var i=0;i<divcj.length;i++)
        {
            divcj[i].style.visibility="hidden";
            divcj[i].required=false;
        }
    }

}

$("#pseudo").focusout(function()
	{
		var pseudo = $("#pseudo").val();
		if(pseudo!="")
		{
			$.ajax("inscription", { 
				type: "POST", 
				data: { 
					action:'checkPseudo', 
					pseudo:pseudo 
				},
				success: function (resp) 
				{ 
					if(resp=="Y")
					{
						$("#pseudo").addClass("is-valid");
						$("#pseudo").removeClass("is-invalid");
						
						errorPseudo=false;
					}
					else
					{
						
						$("#pseudo").addClass("is-invalid");
						$("#pseudo").removeClass("is-valid");
						errorPseudo=true;
					}
				} 
			});
		}
	});
	

$("#loginForm").focusout(function()
	{
		var login = $("#loginForm").val();
		if(login!="")
		{
			$.ajax("inscription", { 
				type: "POST", 
				data: { 
					action:'checkLogin', 
					login:login 
				},
				success: function (resp) 
				{ 
					if(resp=="Y")
					{
						
						$("#loginForm").addClass("is-valid");
						$("#loginForm").removeClass("is-invalid");
						errorLogin=false;
					}
					else
					{
						
						$("#loginForm").addClass("is-invalid");
						$("#loginForm").removeClass("is-valid");
						errorLogin=true;
					}
				} 
			});
		}
	});

$("#checkPassword").focusout(function()
{
	var password = $("#password").val();
	var checkPassword = $("#checkPassword").val();

	if(password!="")
	{
		alert("IN");
		if(checkPassword == password)
		{
			$("#checkPassword").removeClass("is-invalid");
			$("#checkPassword").addClass("is-valid");
			errorCheckPassword=false;	
		}
		else
		{
			$("#checkPassword").removeClass("is-valid");
			$("#checkPassword").addClass("is-invalid");
			errorCheckPassword=true;	
		}
	}
});

		
$("#form1").submit(function(e){
	if(errorPseudo || errorLogin || errorCheckPassword)
	 {e.preventDefault();}
	else
	{
		alert("inscription effectuee");
	}
});

</script>

</html>