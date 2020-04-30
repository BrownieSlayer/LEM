<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Manager</title>
</head>
<style>
.boutonsHidden
{
	display : none;
}
</style>
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
			<div id="joueur" class="col-3">Manager</div>
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
			Ceci est mon Profil
		</div>
		
		<div class="container-fluid champOffre">
			<h1>Mes Offres</h1>
			<table class= "table table-dark" >
					<tr>
							<th>ID</th>
							<th>Contact</th>
							<th>Salaire</thd>
							<th>Role</th>
							<th></th>
							<th></th>
					</tr>
					<c:forEach items="${ offres }" var="offre">
						<tr>
							<th>${ offre.id }</th>
							<td>${ offre.joueur.pseudo }</td>
							<td>${ offre.salairePropose }</td>
							<td>${ offre.rolePropose }</td>
							<td>
								<form action = "manager" method="POST">
									<input class = "boutonsHidden" type="hidden" name="id_page" value="${ id }" />
									<input class = "boutonsHidden" type="hidden" name="option" value="actualiserOffre" />
									<div class="input-group">
									    <button class="btn btn-primary input-group-prepend" type="button" id="button-addon1">Salaire</button>  
									  	<input type="text" class = "form-control col-1" name="salairePropose" />
										<button class="btn btn-primary input-group-prepend" type="button" id="button-addon1">Role</button>
										<input type="text" name="rolePropose col-1" />
										<input type="submit" class =  "btn btn-outline-primary" value ="Actualiser" />			
									</div>
								</form>
							</td>	
							<td>
								<form action = "manager" method="POST">
									<input class = "boutonsHidden" type="hidden" name="id_page" value="${ id }" />
									<input class = "boutonsHidden" type="hidden" name="option" value="deleteOffre" />
									<input type="hidden" name="id_offre" value="${ offre.id }" />
									<input type="submit" class =  "btn btn-outline-danger" value="Supprimer" />
								</form>
							</td>	
						</tr>
					</c:forEach>
			</table>
			
			<h1>Proposer une offre</h1>
			<form action = "manager" method="POST">
				<input type="hidden" name="id_page" value="${ id }" />
				<input type="hidden" name="option" value="ProposerOffre" />	
				Joueur <input type="text" name="pseudo_manager"/>
				Role <input type="text" name="role_demande" />
				Salaire<input type="text" name="salaire_demande" />
				<input type="submit" value="Envoyer" />
				
			</form>
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

for(var i=0;i<co.length;i++)
{
co[i].style.display="none";
}

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
</body>
</html>