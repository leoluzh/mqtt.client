package com.lambdasys.iot.mqtt.client.entities.alarm;

import static org.testng.Assert.assertNotNull;

import java.io.IOException;
import java.io.Serializable;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lambdasys.iot.mqtt.client.entities.gps.GPSDataMessagePayload;

/**
 * 
 * @author Leonardo Luz Fernandes
 * @version 0.1
 * @since 13/06/2018
 *
 */

@Test(enabled=false)
@SuppressWarnings("serial")
public class AlarmInfomationMessageTest implements Serializable {

	protected AlarmInformationMessage message;

	@BeforeSuite(description="Inicializando recursos para teste de AlarmInformationMessage...")
	public void setUp() {
		this.message = AlarmInformationMessage.builder().build();;
	}
	
	@AfterSuite(description="Finalizando recursos para teste de AlarmInformationMessage...")
	public void tearDown() {
		this.message = null;
	}

	public Object[][] dataProviderJson(){ return null ; };
	
	public Object[][] dataProviderObject(){ return null; };
	
	@Test(dataProvider="dataProviderObject",
		  description="Testing Json serialization.")
	public void testSerialize( AlarmMessagePayload payload ) throws JsonProcessingException {
		String json = message.serialize( payload );
		System.out.println("Serialize result - " + json );
		assertNotNull( json );
	}
	
	@Test(dataProvider="dataProviderJson",
		  description="Testing Json deserialization.")
	public void testDeserialize( String json ) throws IOException {
		AlarmMessagePayload payload = message.deserialize( json );
		System.out.println("Deserialize result - " + payload.toString() );
		assertNotNull( payload );
	}
	
	
}
