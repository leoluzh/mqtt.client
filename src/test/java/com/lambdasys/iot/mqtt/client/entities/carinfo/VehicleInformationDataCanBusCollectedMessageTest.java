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
public class VehicleInformationDataCanBusCollectedMessageTest implements Serializable {

	protected VehicleInformationMessage message;

	@BeforeSuite(description="Inicializando recursos para teste de VehicleInformationMessage...")
	public void setUp() {
		this.message = VehicleInformationMessage.builder().build();
	}
	
	@AfterSuite(description="Finalizando recursos para teste de VehicleInformationMessage...")
	public void tearDown() {
		this.message = null;
	}
	
	@DataProvider(name="dataProviderJson")
	public Object[][] dataProviderJson(){
		return new Object[][] {
			{ "{ \"data\": { \"can\": \"yes\" } , \"eventTime\": \"2017-07-11T03:10:40Z\", \"type\": \"canData\" }" } ,
			{ "{ \"data\": { \"can\": \"no\" } , \"eventTime\": \"2017-07-11T03:10:40Z\", \"type\": \"canData\" }" } ,
		};
	}
	
	@DataProvider(name="dataProviderObject")
	public Object[][] dataProviderObject(){
		return new Object[][] {
			{  VehicleInformationMessagePayload.builder()
				.type(VehicleInformationDataCanBusCollectedMessagePayload.TYPE_NAME)
				.eventTime( message.strToDate( "2017-07-11T03:10:40Z" ) )
				.data( VehicleInformationDataCanBusCollectedMessagePayload.builder()
						.can("yes")
						.build() )
				.build()  } , 
		{  VehicleInformationMessagePayload.builder()
				.type(VehicleInformationDataTableIdsMessagePayload.TYPE_NAME)
				.eventTime( message.strToDate( "2017-07-11T03:10:40Z" ) )
				.data( VehicleInformationDataCanBusCollectedMessagePayload.builder()
						.can("no")
						.build() )
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
