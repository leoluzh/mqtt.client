package com.lambdasys.iot.mqtt.client.entities.report;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lambdasys.iot.mqtt.client.entities.MessagePayload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Leonardo Luz Fernandes
 * @version 0.1
 * @since 16/06/2018
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@SuppressWarnings("serial")
public class DiagnosticResultDataStreamMessagePayload implements MessagePayload {

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("unit")
	private String unit;
	
	@JsonProperty("value")
	private String value;
	
}
