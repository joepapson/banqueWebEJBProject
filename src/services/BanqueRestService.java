package services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import metier.BanqueLocal;
import metier.entities.Compte;

@Path("/")
@Stateless
public class BanqueRestService {
	
	@EJB
	private BanqueLocal metier;

	@Path("/comptes")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Compte addCompte(Compte cp) {
		return metier.addCompte(cp);
	}

	@Path("/comptes/{code}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Compte getCompte(@PathParam(value="code")Long code) {
		return metier.getCompte(code);
	}

	@Path("/comptes")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Compte> listComptes() {
		return metier.listComptes();
	}

	@Path("/comptes/retirer")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public void retirer(@FormParam(value="code")Long cpt,
			           @FormParam(value ="montant")double mt) {
		metier.retirer(cpt, mt);
	}

	@Path("/comptes/verser")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public void verser(@FormParam(value="code")Long cpt,
	                   @FormParam(value ="montant")double mt){
		metier.verser(cpt, mt);
	}

	@Path("/comptes/virement")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public void virement(@FormParam(value="code1")Long cpt1,
			            @FormParam(value="code2")Long cpt2, 
			            @FormParam(value ="montant")double mt) {
		metier.virement(cpt1, cpt2, mt);
	}

}
