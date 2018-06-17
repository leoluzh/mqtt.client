package com.lambdasys.iot.mqtt.client.entities.report;

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
 * @since 16/06/2018
 *
 */


@SuppressWarnings("serial")
public class DiagnosticResultMessageTest implements Serializable {

	private DiagnosticResultMessage message;

	@BeforeSuite(description="Inicializando recursos para teste de DiagnosticResultMessage...")
	public void setUp() {
		this.message = DiagnosticResultMessage.builder().build();
	}
	
	@AfterSuite(description="Finalizando recursos para teste de DiagnosticResultMessage...")
	public void tearDown() {
		this.message = null;
	}

	@DataProvider(name="dataProviderJson")
	public Object[][] dataProviderJson(){
		//TODO: Verificar documento ... campo swVersion ou appVersion??
		return new Object[][] {
			{ "{\n" + 
					"    \"eventTime\": \"2017-07-11T02:30:10Z\",\n" + 
					"    \"items\": [\n" + 
					"        {\n" + 
					"            \"system\": \"Engine and ECT\",\n" + 
					"            \"system_type\": \"1\",\n" + 
					"            \"dtcs\": [],\n" + 
					"            \"datastreams\": []\n" + 
					"        },\n" + 
					"        {\n" + 
					"            \"dtcs\": [\n" + 
					"                {\n" + 
					"                    \"faultDes\": \"Mass or Volume Air Flow Circuit Low Input\",\n" + 
					"                    \"faultId\": \"00370102\",\n" + 
					"                    \"sysId\": \"fffd0400\",\n" + 
					"                    \"faultValue\": \"P0102\",\n" + 
					"                    \"faultStatus\": 0\n" + 
					"                },\n" + 
					"                {\n" + 
					"                    \"faultDes\": \"Fuel Shutoff Valve Control Circuit / Open\",\n" + 
					"                    \"faultId\": \"00370005\",\n" + 
					"                    \"sysId\": \"fffd0400\",\n" + 
					"                    \"faultValue\": \"P0005\",\n" + 
					"                    \"faultStatus\": 0\n" + 
					"                }\n" + 
					"            ],\n" + 
					"            \"datastreams\": [],\n" + 
					"            \"system\": \"Cruise Control\",\n" + 
					"            \"system_type\": \"7\"\n" + 
					"        },\n" + 
					"        {\n" + 
					"            \"dtcs\": [\n" + 
					"                {\n" + 
					"                    \"faultDes\": \"Mass or Volume Air Flow Circuit Low Input\",\n" + 
					"                    \"faultId\": \"00010102\",\n" + 
					"                    \"sysId\": \"fffd8200\",\n" + 
					"                    \"faultValue\": \"P0102\",\n" + 
					"                    \"faultStatus\": 0\n" + 
					"                },\n" + 
					"                {\n" + 
					"                    \"faultDes\": \"Fuel Shutoff Valve Control Circuit / Open\",\n" + 
					"                    \"faultId\": \"00010005\",\n" + 
					"                    \"sysId\": \"fffd8200\",\n" + 
					"                    \"faultValue\": \"P0005\",\n" + 
					"                    \"faultStatus\": 0\n" + 
					"                }\n" + 
					"            ],\n" + 
					"            \"datastreams\": [],\n" + 
					"            \"system\": \"Immobiliser\",\n" + 
					"            \"system_type\": \"13\"\n" + 
					"        },\n" + 
					"        {\n" + 
					"            \"datastreams\": [\n" + 
					"                {\n" + 
					"                    \"id\": \"00000537\",\n" + 
					"                    \"name\": \"IGN Advance\",\n" + 
					"                    \"unit\": \"degree\",\n" + 
					"                    \"value\": \"38\"\n" + 
					"                },\n" + 
					"                {\n" + 
					"                    \"id\": \"0000015a\",\n" + 
					"                    \"name\": \"CALC LOAD\",\n" + 
					"                    \"unit\": \"%\",\n" + 
					"                    \"value\": \"80\"\n" + 
					"                },\n" + 
					"                {\n" + 
					"                    \"id\": \"000000da\",\n" + 
					"                    \"name\": \"MAF\",\n" + 
					"                    \"unit\": \"gm/s\",\n" + 
					"                    \"value\": \"524.28\"\n" + 
					"                },\n" + 
					"                {\n" + 
					"                    \"id\": \"0000007c\",\n" + 
					"                    \"name\": \"MAP\",\n" + 
					"                    \"unit\": \"kPa\",\n" + 
					"                    \"value\": \"204\"\n" + 
					"                },\n" + 
					"                {\n" + 
					"                    \"id\": \"000003be\",\n" + 
					"                    \"name\": \"ENGINE SPD\",\n" + 
					"                    \"unit\": \"rpm\",\n" + 
					"                    \"value\": \"13106.40\"\n" + 
					"                },\n" + 
					"                {\n" + 
					"                    \"id\": \"00000535\",\n" + 
					"                    \"name\": \"Coolant Temp\",\n" + 
					"                    \"unit\": \"degree C\",\n" + 
					"                    \"value\": \"164\"\n" + 
					"                }\n" + 
					"            ],\n" + 
					"            \"dtcs\": [],\n" + 
					"            \"system\": \"OBD\",\n" + 
					"            \"system_type\": \"255\"\n" + 
					"        }\n" + 
					"    ]\n" + 
					"}\n" + 
					"" }
		};
	}
	
	@DataProvider(name="dataProviderObject")
	public Object[][] dataProviderObject(){
		return new Object[][] {
			{ DiagnosticResultMessagePayload.builder()
				.eventTime( message.strToDate( "2017-07-11T02:30:10Z" ) )
				.items( new DiagnosticResultDataMessagePayload[] {
						
						DiagnosticResultDataMessagePayload.builder()
							.system("Engine and ECT")
							.systemType("1")
							.dtcs( new DiagnosticResultDataDtcsMessagePayload[] {} )
							.dataStreams( new DiagnosticResultDataStreamMessagePayload[] {} )
							.build() ,
							
						DiagnosticResultDataMessagePayload.builder()
							.system("Cruise Control")
							.systemType("7")
							.dataStreams( new DiagnosticResultDataStreamMessagePayload[] {} )
							.dtcs( new DiagnosticResultDataDtcsMessagePayload[] {
									DiagnosticResultDataDtcsMessagePayload.builder()
										.faultDescription("Mass or Volume Air Flow Circuit Low Input")
										.faultId("00370102")
										.systemId("fffd0400")
										.faultValue("P0102")
										.faultStatus( 0 )
									.build() ,
									DiagnosticResultDataDtcsMessagePayload.builder()
										.faultDescription("Fuel Shutoff Valve Control Circuit / Open")
										.faultId("00370005")
										.systemId("fffd0400")
										.faultValue("P0005")
										.faultStatus( 0 )
									.build() ,
							}).build() ,
							
							DiagnosticResultDataMessagePayload.builder()
							.system("Immobiliser")
							.systemType("13")
							.dataStreams( new DiagnosticResultDataStreamMessagePayload[] {} )
							.dtcs( new DiagnosticResultDataDtcsMessagePayload[] {
									DiagnosticResultDataDtcsMessagePayload.builder()
										.faultDescription("Mass or Volume Air Flow Circuit Low Input")
										.faultId("00370102")
										.systemId("fffd0400")
										.faultValue("P0102")
										.faultStatus( 0 )
									.build() ,
									DiagnosticResultDataDtcsMessagePayload.builder()
										.faultDescription("Fuel Shutoff Valve Control Circuit / Open")
										.faultId("00370005")
										.systemId("fffd0400")
										.faultValue("P0005")
										.faultStatus( 0 )
									.build() ,
							}).build() ,
							
							DiagnosticResultDataMessagePayload.builder()
							.system("OBD")
							.systemType("255")
							.dtcs( new DiagnosticResultDataDtcsMessagePayload[] {})
							.dataStreams( new DiagnosticResultDataStreamMessagePayload[] {
									DiagnosticResultDataStreamMessagePayload.builder()
										.id("00000537")
										.name("IGN Advance")
										.unit("degree")
										.value("38").build() ,
									DiagnosticResultDataStreamMessagePayload.builder()
										.id("0000015a")
										.name("CALC LOAD")
										.unit("%")
										.value("80").build() ,
									DiagnosticResultDataStreamMessagePayload.builder()
										.id("000000da")
										.name("MAF")
										.unit("am/s")
										.value("524.28").build() ,
									DiagnosticResultDataStreamMessagePayload.builder()
										.id("0000007c")
										.name("MAP")
										.unit("kPa")
										.value("204").build() ,
									DiagnosticResultDataStreamMessagePayload.builder()
										.id("000003be")
										.name("ENGINE SPD")
										.unit("rpm")
										.value("13106.40").build() ,
									DiagnosticResultDataStreamMessagePayload.builder()
										.id("00000535")
										.name("Coolant Temp")
										.unit("Degree C")
										.value("164").build() ,
							} )
							.build() ,		
							
							
				}).build() } ,
			
		};
	}
	
	@Test(
		  dataProvider="dataProviderObject",
		  description="Testing Json serialization.")
	public void testSerialize( DiagnosticResultMessagePayload payload ) throws JsonProcessingException {
		String json = message.serialize( payload );
		System.out.println("Serialize result - " + json );
		assertNotNull( json );
	}
	
	@Test(dataProvider="dataProviderJson",
		  description="Testing Json deserialization.")
	public void testDeserialize( String json ) throws IOException {
		DiagnosticResultMessagePayload payload = message.deserialize( json );
		System.out.println("Deserialize result - " + payload.toString() );
		assertNotNull( payload );
	}
	
}
