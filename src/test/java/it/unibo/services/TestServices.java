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
	public void findRequestById() throws Exception{
		boolean toSkip=true;		
		
		
		String result= "";
		try{
			it.unibo.test.services.UserBean a =uniboServices.getUser(1);	
			toSkip = false;
			assertThat(null,not(equalTo(a.getIdUser())));
			System.out.println("Utente trovato!" +a.getFirstname());// +result.getDomicilio());
		} catch(Exception e){
			System.out.println(e);
			toSkip = true;
			assertEquals("Errore inaspettato", "com.namirial.ws.stub.raservices.WSException: La ricerca non ha prodotto risultati", e.toString());
		}
	}
	
	
}
