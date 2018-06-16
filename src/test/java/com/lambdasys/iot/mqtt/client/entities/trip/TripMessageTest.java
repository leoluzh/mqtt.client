package com.lambdasys.iot.mqtt.client.entities.trip;

import static org.testng.Assert.assertNotNull;

import java.io.IOException;
import java.io.Serializable;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lambdasys.iot.mqtt.client.entities.login.LoginRequestMessagePayload;

/**
 * 
 * @author Leonardo Luz Fernandes
 * @version 0.1
 * @since 11/06/2018
 * 
 * The IoT device can determine different trips. 
 * The trip is defined by two messages one trip start and the second one when trip ends.
 * 
 */


@SuppressWarnings("serial")
public class TripMessageTest implements Serializable {

	private TripMessage message;

	@BeforeSuite(description="Inicializando recursos para teste de TripMessage...")
	public void setUp() {
		this.message = TripMessage.builder().build();
	}
	
	@AfterSuite(description="Finalizando recursos para teste de TripMessage...")
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
	public void testSerialize( TripMessagePayload payload ) throws JsonProcessingException {
		String json = message.serialize( payload );
		System.out.println("Serialize result - " + json );
		assertNotNull( json );
	}
	
	@Test(dataProvider="dataProviderJson",
		  description="Testing Json deserialization.")
	public void testDeserialize( String json ) throws IOException {
		TripMessagePayload payload = message.deserialize( json );
		System.out.println("Deserialize result - " + payload.toString() );
		assertNotNull( payload );
	}
	
	
}
