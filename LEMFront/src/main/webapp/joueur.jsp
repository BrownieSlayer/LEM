<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Joueur</title>
</head>

<header> </header>

<body id="background">

	<div class="container-fluid">
		
		<div id="ligne"></div>
		
		<img id="logoLoL" src="./img/LogoLoLGrey.png" />

		<div id="topBandeau" class="row">

			<div class="col-2"></div>
			<div id="titre1" class="col-2">LoL Esport</div>
			<div class="col-2"></div>
			<div class="col-1"></div>
			<div id="joueur" class="col-3">Joueur</div>
			<div class="col-2"></div>

		</div>
		
		
		
		<div id="topBandeau2" class="row">

			<div class="col-2"></div>
			<div id="titre2" class="col-2">MANAGER</div>
			<div class="col-2"></div>
			<div class="col-1"></div>
			
			
	   				
		
			<div class="btn-group btn-group-toggle col-3" data-toggle="buttons">
	  			<label class="btn btn-outline active boutonSilver ">
	    			<input required checked onChange="changeType('Profil')" name="typeCompte" type="radio" value="Profil"> Profil
	  			</label>
	  			<label class="btn btn-outline boutonSilver">
	  				 <input required onChange="changeType('Offre')" name="typeCompte" type="radio" value="Offre"> Offre
	  			</label>
			</div>
			
			<div class="col-2"></div>
		</div>
		<br>

		<div id="bonjour" class="col-12">Bonjour ${prenom} "${pseudo}"
			${nom} !</div>
		<br> <br> <br>

		
		<div class="container-fluid champProfil">
			<div class="row">
				<div class="col-2"></div>
				<div class="col-2">
					<div id="statistiques">
						Vos statistiques :<br>
						<br> <br> <span id="stat">Eliminations :
							${elimination}<br>
						<br>Morts : ${mort}<br>
						<br>Assistances : ${assist}<br>
						<br>KDA : ${kda}
						</span>
					</div>
				</div>
				<div class="col-3"></div>
				<div id="equipe" class="col-3">
					Equipe actuelle : ${equipe}<br> <br>
					<br> Rôle actuel : ${role}<br>
					<br>
					<form id="formModifRole" action="joueur" method="POST">
					<button id = "btnModifRole" type="button" class = "btn btn-warning btn-block boutonJauneJoueur" onClick="hideForm1()"> Modifier rôle</button>
					
					<br>
					<!-- Boutons Rôles -->
 
			 		<div  class="btn-group btn-group-toggle champModifRole" data-toggle="buttons">
			  			<label class="btn btn-light active">
			    			<input required checked name="role" type="radio" value="Top"/>  Top
			  			</label>
			  			<label class="btn btn-light">
			   				 <input required name="role" type="radio" value="Jungler"/> Jungler
			  			</label>
			  			<label class="btn btn-light">
			   				 <input required name="role" type="radio" value="Mid"/> Mid
			  			</label>
			  			<label class="btn btn-light">
			   				 <input required name="role" type="radio" value="ADC"/> ADC
			  			</label>
			  			<label class="btn btn-light">
			   				  <input required name="role" type="radio" value="Support"/> Support
			  			</label>
			  			
			  			
					</div>
					<br>
					<div  class="btn-group btn-group-toggle champModifRole" data-toggle="buttons">
					<input type="button" class="btn btn-warning col 2 espacementForm btn-block boutonJauneJoueur" value ="Valider">
					</div>
					<br>
					</form>
					
					
					<br>
					<br> Salaire minimum exigé actuel : ${salmin}<br>
					<br>
					<form id="formModifRole" action="joueur" method="POST">
					<button id = "btnModifSal" type="button" class = "btn btn-warning btn-block boutonJauneJoueur" onClick="hideForm2()"> Modifier salaire</button>
					<br>
					<div class="input-group-prepend champModifSal">
	  					<span class="input-group-text">Salaire minimal souhaité</span>
	  				<input type="text" class="form-control" name= "salmin">
	  				<span class="input-group-prepend"></span><span class="input-group-text">€</span>
	    			</div>
	    			<div  class="btn-group btn-group-toggle champModifSal" data-toggle="buttons">
					<input type="button" class="btn btn-warning col 2 espacementForm btn-block boutonJauneJoueur" value ="Valider">
					</div>
					</form>
				</div>
				<div class="col-2"></div>
			</div>

		</div>

		<div id="botBandeau" class="row">
			<div class="col-2"></div>
			<div id="termsOfUse" class="col-3">Terms of use</div>
			<div class="col-2"></div>
			<div id="contact" class="col-3">Contacts</div>
			<div class="col-2"></div>
			<br>
			<div id="copyright" class="col-12">Copyright© 2020
				Thibault,Kodo,Florian</div>

		</div>
	
	</div>

</body>

<script>

var btnModifRole = document.getElementById("btnModifRole");
var champModifRole = document.getElementsByClassName("champModifRole");
var btnModifSal = document.getElementById("btnModifSal")
var champModifSal = document.getElementsByClassName("champModifSal");

/* btnModifRole.onclick=hideForm1;
btnModifSal.onclick=hideForm2; */

for(var i=0;i<champModifRole.length;i++)
	{
	champModifRole[i].style.visibility="hidden";
	}


function hideForm1(){
	for(var i=0;i<champModifRole.length;i++)
	{
	champModifRole[i].style.visibility="visible";
	}
	
}
$("btnValiderRole").click(function(){
	alert("YES");
})	

for(var i=0;i<champModifSal.length;i++)
	{
	champModifSal[i].style.visibility="hidden";
	}

function hideForm2(){
	
	for(var i=0;i<champModifSal.length;i++)
	{
	champModifSal[i].style.visibility="visible";
	}
	
}

var cp=document.getElementsByClassName("champProfil");
var co=document.getElementsByClassName("champOffre");
function changeType(type)
{
    if(type=="Profil")
    {

        for(var i=0;i<co.length;i++)
        {
            co[i].style.display="none";
           
        }

        for(var i=0;i<cp.length;i++)
        {
            cp[i].style.display="block";
        
        }
 
    }
    else
    {
         for(var i=0;i<cp.length;i++)
         {
             cp[i].style.display="none";
            
         }

         for(var i=0;i<co.length;i++)
         {
             co[i].style.display="block";
          
         }
    }

}

</script>
</html>