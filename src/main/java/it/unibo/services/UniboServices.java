package it.unibo.services;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

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
	public UserBean getCredential(
			@WebParam(name="idUser") Integer idUser
			) throws Exception {
		return enq.findUserById(idUser);
	}

	@WebMethod
	public void addUser(
			@WebParam(name="idUser") UserBean toAdd
			) throws Exception {
		enq.addUser(toAdd);
	}

	@WebMethod
	public UserBean deleteUser(
			@WebParam(name="idUser") Integer idUser
			) throws Exception {
		return enq.findUserById(idUser);
	}

	@WebMethod
	public UserBean addCredentials(
			@WebParam(name="idUser") Integer idUser
			) throws Exception {
		return enq.findUserById(idUser);
	}

	@WebMethod
	public UserBean deletCredentials(
			@WebParam(name="idUser") Integer idUser
			) throws Exception {
		return enq.findUserById(idUser);
	}
}
