package it.unibo.services;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import it.unibo.bean.CredentialBean;
import it.unibo.bean.UserBean;
import it.unibo.controller.Enquiry;

@WebService
public class UniboServices {

	@EJB
	Enquiry enq;

	public UniboServices() {

	}


	@WebMethod
	public UserBean getUser(
			@WebParam(name="idUser") Integer idUser
			) throws Exception {
		return enq.findUserById(idUser);
	}

	@WebMethod
	public CredentialBean getCredential(
			@WebParam(name="idUser") Integer idUser
			) throws Exception {
		return enq.getCredentialsFromUserId(idUser);
	}

	@WebMethod
	public void addUser(
			@WebParam(name="idUser") UserBean toAdd
			) throws Exception {
		enq.addUser(toAdd);
	}

	@WebMethod
	public void deleteUser(
			@WebParam(name="idUser") int idUser
			) throws Exception {
		enq.deleteUser(idUser);
	}

	@WebMethod
	public void addCredentials(
			@WebParam(name="idUser") Integer idUser,
			@WebParam(name="cred") CredentialBean cred
			) throws Exception {
		enq.addCredentialToUser(idUser, cred);
	}

	@WebMethod
	public void deletCredentialsFromIdUser(
			@WebParam(name="idUser") int idUser
			) throws Exception {
		enq.deleteCredential(idUser);
	}
	
	@WebMethod
	public void deletCredentialsFromId(
			@WebParam(name="idCred") int idCred
			) throws Exception {
		enq.deleteCredentialFromId(idCred);
	}
}
