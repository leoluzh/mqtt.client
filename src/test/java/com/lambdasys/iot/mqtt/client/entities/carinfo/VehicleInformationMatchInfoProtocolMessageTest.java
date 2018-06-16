package com.lambdasys.iot.mqtt.client.entities.carinfo;

import static org.testng.Assert.assertNotNull;

import java.io.IOException;
import java.io.Serializable;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

@SuppressWarnings("serial")
public class VehicleInformationMatchInfoProtocolMessageTest implements Serializable {

	protected VehicleInformationMessage message;

	@BeforeSuite(description="Inicializando recursos para teste de VehicleInformationMatchInfoProtocolMessage...")
	public void setUp() {
		this.message = VehicleInformationMessage.builder().build();
	}
	
	@AfterSuite(description="Finalizando recursos para teste de VehicleInformationMatchInfoProtocolMessage...")
	public void tearDown() {
		this.message = null;
	}
	
	@DataProvider(name="dataProviderJson")
	public Object[][] dataProviderJson(){
		return new Object[][] {
			{ "{ \"data\": { \"result\": \"something\" } , \"eventTime\": \"2017-07-11T03:10:40Z\", \"type\": \"matchinfo\" }" } ,
			{ "{ \"data\": { \"result\": \"unknown\" } , \"eventTime\": \"2017-07-11T03:10:40Z\", \"type\": \"matchinfo\" }" } ,
		};
	}
	
	@DataProvider(name="dataProviderObject")
	public Object[][] dataProviderObject(){
		return new Object[][] {
			{  VehicleInformationMessagePayload.builder()
					.type(VehicleInformationMatchInfoProtocolMessagePayload.TYPE_NAME)
					.data(VehicleInformationMatchInfoProtocolMessagePayload.builder()
							.result("something")
							.build())
					.build()  } , 
			{  VehicleInformationMessagePayload.builder()
					.type(VehicleInformationMatchInfoProtocolMessagePayload.TYPE_NAME)
					.data(VehicleInformationMatchInfoProtocolMessagePayload.builder()
							.result("unknown")
							.build())
					.build()  } , 
		};
	}
	
	@Test(dataProvider="dataProviderObject",
		  description="Testing Json serialization.")
	public void testSerialize( VehicleInformationMessagePayload payload ) throws JsonProcessingException {
		String json = message.serialize( payload );
		System.out.println("Serialize result - " + json );
		assertNotNull( json );
	}
		
	@Test(dataProvider="dataProviderJson",
		  description="Testing Json deserialization.")
	public void testDeserialize( String json ) throws IOException {
		VehicleInformationMessagePayload payload = message.deserialize( json );
		System.out.println("Deserialize result - " + payload.toString() );
		assertNotNull( payload );
	}
	
	
}
