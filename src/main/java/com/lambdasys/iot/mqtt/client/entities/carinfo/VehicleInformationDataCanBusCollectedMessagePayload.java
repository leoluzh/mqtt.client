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

@JsonTypeName(VehicleInformationDataCanBusCollectedMessagePayload.TYPE_NAME)
@SuppressWarnings("serial")
public class VehicleInformationDataCanBusCollectedMessagePayload extends VehicleInformationDataMessagePayload {

	public static final String TYPE_NAME = "canData" ;

	@JsonProperty("can")
	private String can;
	
}
