package it.unibo.services;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

import it.unibo.controller.Enquiry;

@WebService
public class UniboServices {

	@EJB
	Enquiry enq;
	
	@WebMethod
	public void provaDb() throws Exception {
		enq.findUserById(0);
	}
}
