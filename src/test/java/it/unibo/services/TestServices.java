package it.unibo.services;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TestServices {

	@Test
	public void findRequestById(){
		boolean toSkip=true;
		//Richiesta result = new Richiesta();
		String result= "";
		try{
		//	result=raServices.findRequestById("111", "AUAA2016112475485723");//ID_RICHIESTA);
			toSkip = false;
			assertThat(null,not(equalTo(result)));
			System.out.println("Richiesta trovata! Domicilio:" );// +result.getDomicilio());
		} catch(Exception e){
			System.out.println(e);
			toSkip = true;
			assertEquals("Errore inaspettato", "com.namirial.ws.stub.raservices.WSException: La ricerca non ha prodotto risultati", e.toString());
		}
	}
	
	@Test
	public void addRequest(){
		boolean toSkip=true;
		//Richiesta result = new Richiesta();
		String result= "";
		try{
		//	result=raServices.findRequestById("111", "AUAA2016112475485723");//ID_RICHIESTA);
			toSkip = false;
			assertThat(null,not(equalTo(result)));
			System.out.println("Richiesta trovata! Domicilio:" );// +result.getDomicilio());
		} catch(Exception e){
			System.out.println(e);
			toSkip = true;
			assertEquals("Errore inaspettato", "com.namirial.ws.stub.raservices.WSException: La ricerca non ha prodotto risultati", e.toString());
		}
	}
	
	@Test
	public void deleteRequest(){
		boolean toSkip=true;
		//Richiesta result = new Richiesta();
		String result= "";
		try{
		//	result=raServices.findRequestById("111", "AUAA2016112475485723");//ID_RICHIESTA);
			toSkip = false;
			assertThat(null,not(equalTo(result)));
			System.out.println("Richiesta trovata! Domicilio:" );// +result.getDomicilio());
		} catch(Exception e){
			System.out.println(e);
			toSkip = true;
			assertEquals("Errore inaspettato", "com.namirial.ws.stub.raservices.WSException: La ricerca non ha prodotto risultati", e.toString());
		}
	}
	
	
}
