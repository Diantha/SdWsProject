package it.unibo.services;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import it.unibo.test.services.Exception_Exception;

@RunWith(OrderedRunner.class)
public class TestServices {
	int credenTodelete=0;
	it.unibo.test.services.UniboServices uniboServices=null;
	JaxWsProxyFactoryBean proxyFactory = new JaxWsProxyFactoryBean();
	
	@Before
	public void setConfiguration(){ //in questo modo setto il mio client
		SetInitialParameters a = new SetInitialParameters("http://localhost:9080/SoapSd/services/Uniboservices",it.unibo.test.services.UniboServices.class);
		proxyFactory=a.setProxyFactory(null, null);
		uniboServices = (it.unibo.test.services.UniboServices) proxyFactory.create();
	}
	
	
	@Test
	@Order(order = 1)
	public void getFirstCredentials() throws Exception{
		try{
			it.unibo.test.services.CredentialBean a =uniboServices.getCredential(1);	
			assertThat(null,not(equalTo(a.getIdCredenziale())));
			System.out.println("Credenziale trovata!" +a.getUsername());
		} catch(Exception e){
			System.out.println(e);
			assertEquals("Errore inaspettato", "it.unibo.test.services.Exception_Exception: Eccezione, all'utente non sono associate credenziali", e.toString());
		}
	}
	
	
	@Test
	@Order(order = 2)
	public void getFirstUser() throws Exception{
		try{
			it.unibo.test.services.UserBean a =uniboServices.getUser(1);	
			assertThat(null,not(equalTo(a.getIdUser())));
		} catch(Exception e){
			System.out.println(e);
			assertEquals("Errore inaspettato", "it.unibo.test.services.Exception_Exception: Eccezione, utente non trovato", e.toString());
		}
	}
	
	@Test
	@Order(order = 3)
	public void addCredentials() throws Exception{
		it.unibo.test.services.CredentialBean toAdd= new it.unibo.test.services.CredentialBean();
		//toAdd.setIdCredenziale(1);
		toAdd.setIdUtente(1);
		toAdd.setPassword("password");
		toAdd.setUsername("paofl");
		uniboServices.addCredentials(1, toAdd);
	}

	@Test
	@Order(order = 4)
	public void deleteCredentialsFromIdUser() throws Exception{
		credenTodelete=uniboServices.getCredential(1).getIdCredenziale();
		System.out.println(" "+credenTodelete);
		try{
			uniboServices.deletCredentialsFromId(credenTodelete);	
		} catch(Exception e){
			System.out.println(e);
			assertEquals("Errore inaspettato", " ", e.toString());
		}
	}
	
	@Test
	@Order(order = 5)
	public void deleteUser() throws Exception{
		try{
			uniboServices.deleteUser(0);	
		} catch(Exception e){
			System.out.println(e);
			assertEquals("it.unibo.test.services.Exception_Exception: Eccezione, utente non trovato", e.toString());
		}
	}
}
