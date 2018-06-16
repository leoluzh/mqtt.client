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
public class VehicleInformationSoftwareVersionMessageTest implements Serializable {

	protected VehicleInformationMessage message;

	@BeforeSuite(description="Inicializando recursos para teste de VehicleInformationSoftwareVersionMessage...")
	public void setUp() {
		this.message = VehicleInformationMessage.builder().build();
	}
	
	@AfterSuite(description="Finalizando recursos para teste de VehicleInformationSoftwareVersionMessage...")
	public void tearDown() {
		this.message = null;
	}
	
	@DataProvider(name="dataProviderJson")
	public Object[][] dataProviderJson(){
		return new Object[][] {
			{ "{ \"data\": { \"main\": \"xpto\" , \"guard\" : \"xpto\" , \"OS\" : \"android\" , \"download\" : \"sw.apk\" , \"EOBD2\" : \"v3\" , \"CRVII\" : \"xpto\" , \"canOffline\" : \"yes\" ,\"libSo\" : \"xpto\"  } , \"eventTime\": \"2017-07-11T03:10:40Z\", \"type\": \"VIN\" }" } ,
			{ "{ \"data\": { \"main\": \"xpto\" , \"guard\" : \"xpto\" , \"OS\" : \"ios\" , \"download\" : \"sw.dmg\" , \"EOBD2\" : \"v3\" , \"CRVII\" : \"xpto\" , \"canOffline\" : \"yes\" ,\"libSo\" : \"xpto\"  } , \"eventTime\": \"2017-07-11T03:10:40Z\", \"type\": \"VIN\" }" } ,
		};
	}
	
	@DataProvider(name="dataProviderObject")
	public Object[][] dataProviderObject(){
		return new Object[][] {
			{  VehicleInformationMessagePayload.builder()
					.type(VehicleInformationSoftwareVersionMessagePayload.TYPE_NAME)
					.data(VehicleInformationSoftwareVersionMessagePayload.builder()
							.main("main")
							.guard("xpto")
							.os("android")
							.download("sw.apk")
							.eobd2("v3")
							.crvii("xpto")
							.canOffline("yes")
							.libSo("xpto")
							.build())
					.build()  } , 
			{  VehicleInformationMessagePayload.builder()
					.type(VehicleInformationSoftwareVersionMessagePayload.TYPE_NAME)
					.data(VehicleInformationSoftwareVersionMessagePayload.builder()
							.main("main")
							.guard("xpto")
							.os("ios")
							.download("sw.dmg")
							.eobd2("v3")
							.crvii("xpto")
							.canOffline("no")
							.libSo("xpto")
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
