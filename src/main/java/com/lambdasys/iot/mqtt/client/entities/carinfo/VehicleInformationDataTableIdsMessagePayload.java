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
@Builder
@NoArgsConstructor
@AllArgsConstructor

@JsonTypeName(VehicleInformationDataTableIdsMessagePayload.NAME)
@SuppressWarnings("serial")
public class VehicleInformationDataTableIdsMessagePayload extends VehicleInformationDataMessagePayload {

	public static final String TYPE_NAME = "data";
	
	@JsonProperty("ids")
	private Integer[] ids;
	
}
