package com.lambdasys.iot.mqtt.client.entities.faultcode;

import static org.testng.Assert.assertNotNull;

import java.io.IOException;
import java.io.Serializable;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lambdasys.iot.mqtt.client.entities.faultcode.FaultCodeDataMessagePayload.FaultStatusCode;

/**
 * 
 * @author Leonardo Luz Fernandes
 * @version 0.1
 * @since 11/06/2018
 * 
 * 
 */


@SuppressWarnings("serial")
public class FaultCodeMessageTest implements Serializable {

	public static final boolean TEST_ENABLED = true;
	protected FaultCodeMessage message;

	@BeforeSuite(description="Inicializando recursos para teste de FaultCodeMessage...")
	public void setUp() {
		this.message = FaultCodeMessage.builder().build();;
	}
	
	@AfterSuite(description="Finalizando recursos para teste de FaultCodeMessage...")
	public void tearDown() {
		this.message = null;
	}

	@DataProvider(name="dataProviderJson")
	public Object[][] dataProviderJson(){
		//TODO: Verificar documento ... campo swVersion ou appVersion??
		return new Object[][] { {
			"{ \"data\": [ " + 
					"{ \"faultDes\": \"Fuel Volume Regulator Control Circuit/Open\", \"faultId\": \"00000001\", \"sysId\": \"ffffffff\", \"faultValue\": \"P0001\", \"faultStatus\": 3 }, " + 
					"{ \"faultDes\": \"Fuel Volume Regulator Control Circuit Range/Performance\", \"faultId\": \"00000002\", \"sysId\": \"ffffffff\", \"faultValue\": \"P0002\", \"faultStatus\": 3 } " + 
					" ], " + 
					"\"lon\": 114.05540500000001, \"lat\": 22.66381333333333, \"trip_sn\":\"123\", \"eventTime\": \"2017-05-03T08:57:11Z\" }"  
		}};
	}
	
	@DataProvider(name="dataProviderObject")
	public Object[][] dataProviderObject(){
		return new Object[][] {
			//TODO: Find something to replace array to list ... 
			{ FaultCodeMessagePayload.builder()
				.eventTime( message.strToDate("2017-05-03T08:57:11Z") ).longitude(114.05540500000001).latitude(22.66381333333333).tripSn("123")
				.data( new FaultCodeDataMessagePayload[]{
						FaultCodeDataMessagePayload.builder()
							.faultDescription("Fuel Volume Regulator Control Circuit/Open")
							.faultId("00000001")
							.sysId("ffffffff")
							.faultValue("P0001")
							.faultStatus( FaultStatusCode.fromCode( 3 ) ).build() ,
						FaultCodeDataMessagePayload.builder()
							.faultDescription("Fuel Volume Regulator Control Circuit Range/Performance")
							.faultId("00000002")
							.sysId("ffffffff")
							.faultValue("P0002")
							.faultStatus( FaultStatusCode.fromCode( 3 ) ).build() ,
				}).build() } ,
			{ FaultCodeMessagePayload.builder()
				.eventTime( message.strToDate("2017-05-03T08:57:11Z") ).longitude(114.05540500000001).latitude(22.66381333333333).tripSn("123")
				.data( new FaultCodeDataMessagePayload[]{
						FaultCodeDataMessagePayload.builder()
						.faultDescription("Fuel Volume Regulator Control Circuit/Open")
						.faultId("00000001")
						.sysId("ffffffff")
						.faultValue("P0001")
						.faultStatus( FaultStatusCode.fromCode( 3 ) ).build() ,
					FaultCodeDataMessagePayload.builder()
						.faultDescription("Fuel Volume Regulator Control Circuit Range/Performance")
						.faultId("00000002")
						.sysId("ffffffff")
						.faultValue("P0002")
						.faultStatus( FaultStatusCode.fromCode( 3 ) ).build() ,
				}).build() } ,
			
		};
	}
	
	@Test(
		  dataProvider="dataProviderObject",
		  description="Testing Json serialization.",
		  enabled=FaultCodeMessageTest.TEST_ENABLED)
	public void testSerialize( FaultCodeMessagePayload payload ) throws JsonProcessingException {
		String json = message.serialize( payload );
		System.out.println("Serialize result - " + json );
		assertNotNull( json );
	}
	
	@Test(dataProvider="dataProviderJson",
		  description="Testing Json deserialization.",
		  enabled=FaultCodeMessageTest.TEST_ENABLED)
	public void testDeserialize( String json ) throws IOException {
		FaultCodeMessagePayload payload = message.deserialize( json );
		System.out.println("Deserialize result - " + payload.toString() );
		assertNotNull( payload );
	}
		
	
}
