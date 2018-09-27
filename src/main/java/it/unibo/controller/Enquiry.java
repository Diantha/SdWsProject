package it.unibo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import it.entities.db.unibodb.CredenzialiHome;
import it.entities.db.unibodb.Utente;
import it.entities.db.unibodb.UtenteHome;
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
	
	public void getCredentialsFromUserId(int idUser)throws Exception  {
		findUserById(idUser);
	}
	public void getCredentialsFromUsername() {
		
	}
	
	public void deleteUser(int idUser) throws Exception {
		findUserById(idUser);
	}
	
	public void deleteCredential(int idUser) throws Exception {
		findUserById(idUser);
	}
	
	public void addUser(UserBean toAdd) {
		Utente toInsert= new Utente();
		toInsert.setCodiceFiscale(toAdd.getTaxCode());
		toInsert.setCognome(toAdd.getLastname());
		toInsert.setNome(toAdd.getFirstname());
		uHome.persist(toInsert);
		System.out.println(" Utente inserito");
		
		
	}
	
	public void addCredentialToUser(int idUser)throws Exception  {
		findUserById(idUser);
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
	
	public List<String> getInfoFromTaxCode(String taxCode) {
		List<String> allTaxCodeInfo= new ArrayList<String>();
		
		return allTaxCodeInfo;
	}

	public void findUserByTaxCode(String taxCode) {
		
	}
}
