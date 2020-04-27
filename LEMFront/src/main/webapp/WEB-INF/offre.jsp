<h1>Liste offres</h1>

<table class= "table table-dark" >
		<tr>
				<th>ID</th>
				<th>Contact</th>
				<th>Equipe</th>
				<th>Salaire</thd>
				<th>Role</th>
				<th></th>
				<th></th>
		</tr>
		<c:forEach items="${ offres }" var="offre">
			<tr>
				<th>${ offre.id }</th>
				<td>${ offre.manager.pseudo }</td>
				<td>${ offre.equipePropose }</td>
				<td>${ offre.salairePropose }</td>
				<td>${ offre.rolePropose }</td>
				<td>
					<form action = "offre" method="POST">
						<input type="hidden" name="option" value="accepter" />
						<input type="hidden" name="id_offre" value="${ offre.id }" />
						<input type="hidden" name="equipe" value="${ offre.equipePropose }" />
						<input type="hidden" name="id_joueur" value="${ offre.joueur.id }" />
						<input type="hidden" name="id_manager" value="${ offre.manager.id }" />
						<input type="hidden" name="role" value="${ offre.rolePropose }" />
						<input type="submit" value="Accepter" />
					</form>
				</td>	
				<td>
					<form action = "offre" method="POST">
						<input type="hidden" name="option" value="delete" />
						<input type="hidden" name="id_offre" value="${ offre.id }" />
						<input type="submit" value="Refuser" />
					</form>
				</td>	
			</tr>
		</c:forEach>
</table>

<h1>Candidater</h1>
<form action = "candidature" method="POST">
	<input type="hidden" name="option" value="insert" />	
	Manager <input type="text" name="pseudo_manager"/>
	Role souhaité <input type="text" name="role" />
	Salaire souhaité <input type="text" name="salaire_demande" />
	<input type="submit" value="Envoyer" />
	
</form>
