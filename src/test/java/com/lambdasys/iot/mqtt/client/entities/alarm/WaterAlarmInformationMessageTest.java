package com.lambdasys.iot.mqtt.client.entities.alarm;

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
public class WaterAlarmInformationMessageTest implements Serializable {

	protected AlarmInformationMessage message;

	@BeforeSuite(description="Inicializando recursos para teste de AlarmInformationMessage...")
	public void setUp() {
		this.message = AlarmInformationMessage.builder().build();;
	}
	
	@AfterSuite(description="Finalizando recursos para teste de AlarmInformationMessage...")
	public void tearDown() {
		this.message = null;
	}
	
	@DataProvider(name="dataProviderJson")
	public Object[][] dataProviderJson(){
		return new Object[][] {
			{ "{ \"type\": \"water\", \"eventTime\": \"2017-05-03T08:57:11Z\" , \"data\": { \"waterValue\": 101.22 , \"lat\" : 114.05540500000001 , \"lon\" : 22.66381333333333 , \"trip_sn\" : 12345} }" 	},
		};
	}
	
	@DataProvider(name="dataProviderObject")
	public Object[][] dataProviderObject(){
		return new Object[][] {
			{  AlarmMessagePayload.builder()
					.type("water")
					.eventTime(message.strToDate("2017-05-03T08:57:11Z"))
					.data( WaterAlarmDataMessagePayload.builder()
								.waterValue(50)
								.latitude(114.05540500000001)
								.longitude(22.66381333333333)
								.tripSn(12345)
								.build() )
					.build()  } , 
		};
	}
	
	
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
