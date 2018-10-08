package it.unibo.services;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Before;
import org.junit.Test;



public class TestServices {

	it.unibo.test.services.UniboServices uniboServices=null;
	JaxWsProxyFactoryBean proxyFactory = new JaxWsProxyFactoryBean();
	
	@Before
	public void setConfiguration(){ //in questo modo setto il mio client
		SetInitialParameters a = new SetInitialParameters("http://localhost:8080/SoapSd/UniboServices",it.unibo.test.services.UniboServices.class);
		proxyFactory=a.setProxyFactory(null, null);
		uniboServices = (it.unibo.test.services.UniboServices) proxyFactory.create();
	}
	
	
	@Test
	public void getFirstCredentials() throws Exception{

		String result= "";
		try{
			it.unibo.test.services.UserBean a =uniboServices.getCredential(1);	
			assertThat(null,not(equalTo(a.getIdUser())));
			System.out.println("Utente trovato!" +a.getFirstname());
		} catch(Exception e){
			System.out.println(e);
			assertEquals("Errore inaspettato", " La ricerca non ha prodotto risultati", e.toString());
		}
	}
	
	
	@Test
	public void getFirstUser() throws Exception{

		String result= "";
		try{
			it.unibo.test.services.UserBean a =uniboServices.getUser(1);	
			assertThat(null,not(equalTo(a.getIdUser())));
		} catch(Exception e){
			System.out.println(e);
			assertEquals("Errore inaspettato", " La ricerca non ha prodotto risultati", e.toString());
		}
	}
	
	
	@Test
	public void deleteUser() throws Exception{

		String result= "";
		try{
			it.unibo.test.services.UserBean a =uniboServices.deleteUser(0);	
			assertThat(null,not(equalTo(a.getIdUser())));
		} catch(Exception e){
			System.out.println(e);
			assertEquals("Errore inaspettato", " La ricerca non ha prodotto risultati", e.toString());
		}
	}
	
	
	@Test
	public void deleteCredentials() throws Exception{

		String result= "";
		try{
			it.unibo.test.services.UserBean a =uniboServices.deletCredentials(1);	
			assertThat(null,not(equalTo(a.getIdUser())));
		} catch(Exception e){
			System.out.println(e);
			assertEquals("Errore inaspettato", " ", e.toString());
		}
	}
	
}
