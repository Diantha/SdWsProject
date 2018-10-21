package it.unibo.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import it.entities.db.unibodb.Credenziali;
import it.entities.db.unibodb.CredenzialiHome;
import it.entities.db.unibodb.Utente;
import it.entities.db.unibodb.UtenteHome;
import it.unibo.bean.CredentialBean;
import it.unibo.bean.UserBean;

@Stateless
public class Enquiry {

	@EJB
	CredenzialiHome cHome;

	@EJB
	UtenteHome uHome;

	public void getUser(int idUser) throws Exception {
		findUserById(idUser);
	}

	public CredentialBean getCredentialsFromUserId(int idUser)throws Exception  {
		Utente u= uHome.findById(idUser);
		if(u==null) {
			throw new Exception("Eccezione, utente non trovato");
		}
		if(u.getCredenzialis().isEmpty()) {
			throw new Exception("Eccezione, all'utente non sono associate credenziali");
		}
		Iterator a = u.getCredenzialis().iterator();
		Credenziali c = (Credenziali) a.next();
		return credentialMapping(c);

	}


	public void getCredentialsFromUsername() {

	}

	public void deleteUser(int idUser) throws Exception {
		Utente u = uHome.findById(idUser);
		if(u!=null) {
			System.out.println("Utente trovato");
			uHome.remove(u);
			System.out.println("Utente rimosso con successo");
		}else {
			throw new Exception("Eccezione, utente non trovato");
		}
	}

	public void deleteCredential(int idUser) throws Exception {
		Utente u= uHome.findById(idUser);
		if(u==null) {
			throw new Exception("Eccezione, utente non trovato");
		}
		if(u.getCredenzialis().isEmpty()) {
			throw new Exception("Eccezione, all'utente non sono associate credenziali");
		}
		Iterator a = u.getCredenzialis().iterator();
		Credenziali c = (Credenziali) a.next();
		cHome.remove(c);
		System.out.println(" credenziali rimosse con successo");
		
	}
	
	public void deleteCredentialFromId(int idUser) throws Exception {
		Credenziali c = cHome.findById(idUser);
		cHome.remove(c);
		System.out.println(" credenziali rimosse con successo");
		
	}

	public void addUser(UserBean toAdd) {
		Utente toInsert= new Utente();
		toInsert.setCodiceFiscale(toAdd.getTaxCode());
		toInsert.setCognome(toAdd.getLastname());
		toInsert.setNome(toAdd.getFirstname());
		uHome.persist(toInsert);
		System.out.println(" Utente inserito");
	}

	public void addCredentialToUser(int idUser, CredentialBean input)throws Exception  {
		//Credenziali c= cHome.findById(idUser);
		Utente u = uHome.findById(idUser);

		if(u!=null) {
			//ritorna utente
			System.out.println("Utente trovato");
			Credenziali c = new Credenziali();
			c.setIdCredenziale(input.getIdCredenziale());
			c.setUtente(u);
			c.setPassword(input.getPassword());
			c.setUsername(input.getUsername());
			cHome.persist(c);
			System.out.println("credenziali associate all'utente");
		}else {
			throw new Exception("Eccezione, utente non trovato");
		}
	}

	public UserBean findUserById(Integer idUser) throws Exception {

		//Credenziali c= cHome.findById(idUser);
		Utente u = uHome.findById(idUser);

		if(u!=null) {
			//ritorna utente
			System.out.println("Utente trovato");
			UserBean ret= userMapping(u);
			return ret;
		}else {
			throw new Exception("Eccezione, utente non trovato");
		}
	}

	public UserBean userMapping(Utente userFind) {
		UserBean result = new UserBean();
		String taxCode=userFind.getCodiceFiscale();
		//List<String> infoFromTaxCode = getInfoFromTaxCode(taxCode);
		result.setIdUser(userFind.getIdUtente());
		result.setFirstname(userFind.getNome());
		result.setLastname(userFind.getCognome());
		result.setTaxCode(userFind.getCodiceFiscale());
		//result.setBirthDate(infoFromTaxCode.get(0));
		//result.setGender(infoFromTaxCode.get(1));
		return result;
	}

	public CredentialBean credentialMapping(Credenziali cFind) {
		CredentialBean result= new CredentialBean();
		result.setIdCredenziale(cFind.getIdCredenziale());
		result.setIdUtente(cFind.getUtente().getIdUtente());
		result.setPassword(cFind.getPassword());
		result.setUsername(cFind.getUsername());
		return result;

	}

	public List<String> getInfoFromTaxCode(String taxCode) {
		List<String> allTaxCodeInfo= new ArrayList<String>();

		return allTaxCodeInfo;
	}

	public void findUserByTaxCode(String taxCode) {

	}
}
