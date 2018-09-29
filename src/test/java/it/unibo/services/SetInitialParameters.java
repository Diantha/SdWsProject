package it.unibo.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/*
 * Classe che prende in input i parametri per la connessione ai webmethod
 */

public class SetInitialParameters {
	String Address; //Indirizzo del webservice
	Object serviceClass; //tipo d'oggetto di ritorno del webservice 

	public SetInitialParameters(String Address, Object serviceClass)
	{
		this.Address= Address;
		this.serviceClass= serviceClass;
	}

	public List<String> setUsernameAndPassword()
	{
		String username="";
		String password="";
		try {
			Properties prop = new Properties();
			//System.out.println(" " +Paths.get(".").toAbsolutePath().normalize().toString());
			prop.load(new FileInputStream(new File("src/test/resources/credentials.properties")));
			username = prop.getProperty("username");
			password = prop.getProperty("password");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		List<String> result =new ArrayList<String>();
		result.add(username);
		result.add(password);
		return result;
	}

	//Client con username e password
	public JaxWsProxyFactoryBean setProxyFactory(String username,String password)
	{
		JaxWsProxyFactoryBean proxyFactory = new JaxWsProxyFactoryBean();
		proxyFactory.setServiceClass((Class) serviceClass);
		proxyFactory.setAddress(Address);
		proxyFactory.setUsername(username);
		proxyFactory.setPassword(password);
		return proxyFactory;
	}

}