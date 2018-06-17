package com.lambdasys.iot.mqtt.client.entities.carinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.lambdasys.iot.mqtt.client.entities.MessagePayload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Leonardo Luz Fernandes
 * @version 0.1
 * @since 16/06/2018
 *
 */

@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
@Builder

@JsonTypeName(VehicleInformationNumberMessagePayload.TYPE_NAME)
@SuppressWarnings("serial")
public class VehicleInformationNumberMessagePayload extends VehicleInformationDataMessagePayload {

	public static final String TYPE_NAME = "VIN" ;
	
	@JsonProperty("VIN")
	private String vin;
	
}
