package com.lambdasys.iot.mqtt.client.entities.data;

import static org.testng.Assert.assertNotNull;

import java.io.IOException;
import java.io.Serializable;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lambdasys.iot.mqtt.client.entities.Message;

@Test(enabled=DataStreamMessageTest.TEST_ENABLED)
@SuppressWarnings("serial")
public class DataStreamMessageTest implements Serializable {

	public static final boolean TEST_ENABLED = true;
	protected DataStreamMessage message;

	@BeforeSuite(description="Inicializando recursos para teste de DataStreamMessage...")
	public void setUp() {
		this.message = DataStreamMessage.builder().build();;
	}
	
	@AfterSuite(description="Finalizando recursos para teste de DataStreamMessage...")
	public void tearDown() {
		this.message = null;
	}

	@DataProvider(name="dataProviderJson")
	public Object[][] dataProviderJson(){
		//TODO: Verificar documento ... campo swVersion ou appVersion??
		return new Object[][] {
			{ "[ { \"eventTime\": \"2017-05-03T08:57:11Z\", \"items\": " + 
		     " [ { \"id\": 496, \"name\": \"battery_voltage\", \"value\": \"13\" }," + 
				"{ \"id\": 768, \"name\":\"rotating_speed\", \"value\": \"5000\" } ] } , " + 
		     " { \"eventTime\": \"2017-05-03T08:57:11Z\", \"items\": " + 
				"[ { \"id\": 496, \"name\": \"battery_voltage\",\"value\": \"13\" }," + 
		         " { \"id\": 768, \"name\": \"rotating_speed\", \"value\": \"5000\" } ] } ]" } ,
		};
	}
	
	@DataProvider(name="dataProviderObject")
	public Object[][] dataProviderObject(){
		return new Object[][] {
			//TODO: Find something to replace array to list ... 
			{ DataStreamMessagePayload.builder().eventTime( this.message.strToDate("2017-05-03T08:57:11Z") ).itens( new DataStreamItemMessagePayload[] {
					DataStreamItemMessagePayload.builder().id( 496 ).name( "battery_voltage" ).value("13").build() ,
					DataStreamItemMessagePayload.builder().id( 768 ).name( "rotating_speed" ).value("5000").build() ,
			} ).build() } ,
			{ DataStreamMessagePayload.builder().eventTime( this.message.strToDate("2017-05-03T08:57:11Z") ).itens( new DataStreamItemMessagePayload[] {
					DataStreamItemMessagePayload.builder().id( 496 ).name( "battery_voltage" ).value("13").build() ,
					DataStreamItemMessagePayload.builder().id( 768 ).name( "rotating_speed" ).value("5000").build() ,
			} ).build() } ,
		};
	}
	
	@Test(
		  dataProvider="dataProviderObject",
		  description="Testing Json serialization.",
		  enabled=DataStreamMessageTest.TEST_ENABLED)
	public void testSerialize( DataStreamMessagePayload[] payload ) throws JsonProcessingException {
		String json = message.serialize( payload );
		System.out.println("Serialize result - " + json );
		assertNotNull( json );
	}
	
	@Test(dataProvider="dataProviderJson",
		  description="Testing Json deserialization.",
		  enabled=DataStreamMessageTest.TEST_ENABLED)
	public void testDeserialize( String json ) throws IOException {
		DataStreamMessagePayload[] payload = message.deserialize( json );
		System.out.println("Deserialize result - " + payload.toString() );
		assertNotNull( payload );
	}
	
	
}
