package com.lambdasys.iot.mqtt.client.entities.carinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=true)
@Builder
@NoArgsConstructor
@AllArgsConstructor

@JsonTypeName(VehicleInformationDataTableIdsMessagePayload.TYPE_NAME)
@SuppressWarnings("serial")
public class VehicleInformationDataTableIdsMessagePayload extends VehicleInformationDataMessagePayload {

	public static final String TYPE_NAME = "data";
	
	@JsonProperty("ids")
	private String[] ids;
	
}
