package it.unibo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import it.unibo.bean.UserBean;
import it.unibo.db.unibo.Credenziali;
import it.unibo.db.unibo.CredenzialiHome;

@Stateless
public class Enquiry {

	@EJB
	CredenzialiHome cHome;
	
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
	
	public void addUser() {
		
	}
	
	public void addCredentialToUser(int idUser)throws Exception  {
		findUserById(idUser);
	}
	
	public void findUserById(Integer idUser) throws Exception {
		
		Credenziali c= cHome.findById(idUser);
		
		if(c!=null) {
			//ritorna utente
			System.out.println("Ciao");
		}else {
			 throw new Exception("Eccezione, utente non trovato");
		}
	}

	public UserBean userMapping() {
		UserBean result = new UserBean();
		result.setBirthDate("");
		result.setFirstname("");
		result.setLastname("");
		result.setTaxCode("");
		result.setBirthDate("");
		result.setGender("");
		return result;
	}
	
	public List<String> getInfoFromTaxCode(String taxCode) {
		List<String> allTaxCodeInfo= new ArrayList<String>();
		
		return allTaxCodeInfo;
	}
}
