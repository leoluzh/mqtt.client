package com.lambdasys.iot.mqtt.client.entities.login;

import static org.testng.Assert.assertNotNull;

import java.io.IOException;
import java.io.Serializable;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

@SuppressWarnings("serial")
public class LoginResponseMessageTest implements Serializable {

	private LoginResponseMessage message;
	
	@BeforeSuite(description="Inicializando recursos para teste de LoginRequestMessage...")
	public void setUp() {
		this.message = LoginResponseMessage.builder().build();;
	}
	
	@AfterSuite(description="Finalizando recursos para teste de LoginRequestMessage...")
	public void tearDown() {
		this.message = null;
	}

	@DataProvider(name="dataProviderJson")
	public Object[][] dataProviderJson(){
		//TODO: Verificar documento ... campo swVersion ou appVersion??
		return new Object[][] {
			{"{ \"gpsCycle\": 30,\"gpsSampleCycle\": 3, \"dataStreamCycle\": 30, \"dataStreamSampleCycle\": 30 }" } ,
		};
	}
	
	@DataProvider(name="dataProviderObject")
	public Object[][] dataProviderObject(){
		return new Object[][] {
			{ LoginResponseMessagePayload.builder().gpsCycle(30).gpsSampleCycle(3).dataStreamCycle(30).dataStreamSampleCycle(30).build() } ,
		};
	}
	
	@Test(
		  dataProvider="dataProviderObject",
		  description="Testing Json serialization.")
	public void testSerialize( LoginResponseMessagePayload payload ) throws JsonProcessingException {
		String json = message.serialize( payload );
		System.out.println("Serialize result - " + json );
		assertNotNull( json );
	}
	
	@Test(dataProvider="dataProviderJson",
		  description="Testing Json deserialization.")
	public void testDeserialize( String json ) throws IOException {
		LoginResponseMessagePayload payload = message.deserialize( json );
		System.out.println("Deserialize result - " + payload.toString() );
		assertNotNull( payload );
	}
	
	
}
