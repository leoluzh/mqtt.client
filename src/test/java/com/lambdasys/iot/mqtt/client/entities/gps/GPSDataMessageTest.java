package com.lambdasys.iot.mqtt.client.entities.gps;

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
public class GPSDataMessageTest implements Serializable {

	private GPSDataMessage message;

	@BeforeSuite(description="Inicializando recursos para teste de LoginRequestMessage...")
	public void setUp() {
		this.message = GPSDataMessage.builder().build();;
	}
	
	@AfterSuite(description="Finalizando recursos para teste de LoginRequestMessage...")
	public void tearDown() {
		this.message = null;
	}

	@DataProvider(name="dataProviderJson")
	public Object[][] dataProviderJson(){
		//TODO: Verificar documento ... campo swVersion ou appVersion??
		return new Object[][] {
			{"[" 
		    +" {\"eventTime\": \"2017-05-05T10:54:18Z\",\"alt\": 89,\"lon\": 114.05540500000001,\"lat\": 22.66381333333333,\"accuracy\": 21,\"mode\": 1,\"speed\": 0,\"direct\": 155,\"carSpeed\": 15 } , "  
			+" {\"eventTime\": \"2017-05-05T10:54:28Z\",\"alt\": 89,\"lon\": 114.05540500000001,\"lat\": 22.66381333333333,\"accuracy\": 21,\"mode\": 1,\"speed\": 0,\"direct\": 155,\"carSpeed\": -1 }  " 
			+"]"},
		};
	}
	
	@DataProvider(name="dataProviderObject")
	public Object[][] dataProviderObject(){
		return new Object[][] {
			{  GPSDataMessagePayload.builder().eventTime( message.strToDate("2017-05-05T10:54:18Z") ).altitude(89.0).longitude(114.05540500000001).latitude(22.66381333333333).accuracy(21.0).mode(1).speed(0.0).direct(155).carSpeed(15.0).build() } , 
			{  GPSDataMessagePayload.builder().eventTime( message.strToDate("2017-05-05T10:54:28Z") ).altitude(89.0).longitude(114.05540500000001).latitude(22.66381333333333).accuracy(21.0).mode(1).speed(0.0).direct(155).carSpeed(-1.0).build() }
		};
	}
	
	@Test(
		  dataProvider="dataProviderObject",
		  description="Testing Json serialization.")
	public void testSerialize( GPSDataMessagePayload payload[] ) throws JsonProcessingException {
		String json = message.serialize( payload );
		System.out.println("Serialize result - " + json );
		assertNotNull( json );
	}
	
	@Test(dataProvider="dataProviderJson",
		  description="Testing Json deserialization.")
	public void testDeserialize( String json ) throws IOException {
		GPSDataMessagePayload payload[] = message.deserialize( json );
		System.out.println("Deserialize result - " + payload.toString() );
		assertNotNull( payload );
	}
	
	
}
