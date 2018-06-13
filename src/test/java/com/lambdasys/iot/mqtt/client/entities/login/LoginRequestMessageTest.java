package com.lambdasys.iot.mqtt.client.entities.login;

import static org.testng.Assert.assertNotNull;

import java.io.IOException;
import java.io.Serializable;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * 
 * @author Leonardo Luz Fernandes
 * @version 0.1
 * @since 12/06/2018
 *
 */

@SuppressWarnings("serial")
public class LoginRequestMessageTest implements Serializable {

	private LoginRequestMessage message;

	@BeforeSuite(description="Inicializando recursos para teste de LoginRequestMessage...")
	public void setUp() {
		this.message = LoginRequestMessage.builder().build();;
	}
	
	@AfterSuite(description="Finalizando recursos para teste de LoginRequestMessage...")
	public void tearDown() {
		this.message = null;
	}

	@DataProvider(name="dataProviderJson")
	public Object[][] dataProviderJson(){
		//TODO: Verificar documento ... campo swVersion ou appVersion??
		return new Object[][] {
			{"{ \"imei\": \"7997444561\", \"serialNumber\": \"7997444561\", \"sim\": \"34234324\", \"swVersion\": \"EN_0.21-8.25-8.5.0-16.64\" }"} ,
		};
	}
	
	@DataProvider(name="dataProviderObject")
	public Object[][] dataProviderObject(){
		return new Object[][] {
			{ LoginRequestMessagePayload.builder().imei("7997444561").serialNumber("7997444561").sim("34234324").swVersion("EN_0.21-8.25-8.5.0-16.64").build() } ,
		};
	}
	
	@Test(
		  dataProvider="dataProviderObject",
		  description="Testing Json serialization.")
	public void testSerialize( LoginRequestMessagePayload payload ) throws JsonProcessingException {
		String json = message.serialize( payload );
		System.out.println("Serialize result - " + json );
		assertNotNull( json );
	}
	
	@Test(dataProvider="dataProviderJson",
		  description="Testing Json deserialization.")
	public void testDeserialize( String json ) throws IOException {
		LoginRequestMessagePayload payload = message.deserialize( json );
		System.out.println("Deserialize result - " + payload.toString() );
		assertNotNull( payload );
	}
	
}
