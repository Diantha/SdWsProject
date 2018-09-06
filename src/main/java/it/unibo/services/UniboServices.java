package it.unibo.services;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import it.unibo.controller.Enquiry;

@WebService
public class UniboServices {

	@EJB
	Enquiry enq;
	
	public UniboServices() {
		
	}
	
	
	@WebMethod
	public void provaDb(
			@WebParam(name="idUser") Integer idUser
			) throws Exception {
		enq.findUserById(idUser);
	}
}
