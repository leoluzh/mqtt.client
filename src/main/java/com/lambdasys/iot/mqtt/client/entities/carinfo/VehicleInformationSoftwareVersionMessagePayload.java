package com.lambdasys.iot.mqtt.client.entities.carinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.lambdasys.iot.mqtt.client.entities.MessagePayload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
@Builder

@JsonTypeName(VehicleInformationSoftwareVersionMessagePayload.TYPE_NAME)
@SuppressWarnings("serial")
public class VehicleInformationSoftwareVersionMessagePayload extends VehicleInformationDataMessagePayload {

	public static final String TYPE_NAME = "softVersion" ;
	
	@JsonProperty("main")
	private String main;
	
	@JsonProperty("guard")
	private String guard;
	
	@JsonProperty("OS")
	private String os;
	
	@JsonProperty("download")
	private String download;
	
	@JsonProperty("EOBD2")
	private String eobd2;
	
	@JsonProperty("CRVII")
	private String crvii;
	
	@JsonProperty("canOffline")
	private String canOffline;
	
	@JsonProperty("libSo")
	private String libSo;
	
}
