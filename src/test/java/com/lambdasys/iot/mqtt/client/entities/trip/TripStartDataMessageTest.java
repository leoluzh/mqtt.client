package com.lambdasys.iot.mqtt.client.entities.trip;

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
 * @since 11/06/2018
 * 
 * The IoT device can determine different trips. 
 * The trip is defined by two messages one trip start and the second one when trip ends.
 * 
 */


@SuppressWarnings("serial")
public class TripStartDataMessageTest implements Serializable {

	private TripMessage message;

	@BeforeSuite(description="Inicializando recursos para teste de TripStartDataMessage...")
	public void setUp() {
		this.message = TripMessage.builder().build();;
	}
	
	@AfterSuite(description="Finalizando recursos para teste de TripStartDataMessage...")
	public void tearDown() {
		this.message = null;
	}

	@DataProvider(name="dataProviderJson")
	public Object[][] dataProviderJson(){
		//TODO: Verificar documento ... campo swVersion ou appVersion??
		return new Object[][] {
			{ "{ \"type\": \"start\", \"data\": { \"startTime\": \"2017-05-03T08:57:11Z\", \"trip_sn\": 87 }, \"eventTime\": \"2017-05-03T08:57:11Z\" }" } ,
			{ "{ \"type\": \"start\", \"data\": { \"startTime\": \"2017-05-03T08:57:11Z\", \"trip_sn\": 87 }, \"eventTime\": \"2017-05-03T08:57:11Z\" }" } ,
		};
	}
	
	@DataProvider(name="dataProviderObject")
	public Object[][] dataProviderObject(){
		return new Object[][] {
			{ TripMessagePayload.builder()
				.type(TripStartDataMessagePayload.TYPE_NAME)
				.eventTime( message.strToDate( "2017-05-03T08:57:11Z" ) )
				.data( TripStartDataMessagePayload.builder()
						.startTime( message.strToDate( "2017-05-03T08:57:11Z" ) )
						.tripSn( 87 ).build() ).build() } ,
			{ TripMessagePayload.builder()
				.type(TripStartDataMessagePayload.TYPE_NAME)
				.eventTime( message.strToDate( "2017-05-03T08:57:11Z" ) )
				.data( TripStartDataMessagePayload.builder()
						.startTime( message.strToDate( "2017-05-03T08:57:11Z" ) )
						.tripSn( 87 ).build() ).build() } ,
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
