package com.lambdasys.iot.mqtt.client.entities.data;

import static org.testng.Assert.assertNotNull;

import java.io.IOException;
import java.io.Serializable;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

@Test(enabled=DataStreamMessageTest.TEST_ENABLED)
@SuppressWarnings("serial")
public class DataStreamMessageTest implements Serializable {

	public static final boolean TEST_ENABLED = false;
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
			{"{ \"imei\": \"7997444561\", \"serialNumber\": \"7997444561\", \"sim\": \"34234324\", \"swVersion\": \"EN_0.21-8.25-8.5.0-16.64\" }"} ,
		};
	}
	
	@DataProvider(name="dataProviderObject")
	public Object[][] dataProviderObject(){
		return new Object[][] {
			{ DataStreamMessagePayload.builder().build() } ,
			{ DataStreamMessagePayload.builder().build() } ,
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
