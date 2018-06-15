package com.lambdasys.iot.mqtt.client.entities.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lambdasys.iot.mqtt.client.entities.MessagePayload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 
 * @author Leonardo Luz Fernandes
 * @version 0.1
 * @since 14/06/2018
 * 
 * Values of signals gathered from the vehicle through OBD interface.
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString

@SuppressWarnings("serial")
public class DataStreamItemMessagePayload implements MessagePayload {
	
	/** examples show integer value - houston we have a problem **/
	/** Hex string in 0x???? format where ‘?’ are hex characters **/

	@JsonSerialize(using=HexaDecimalSerializer.class)
	@JsonDeserialize(using=HexaDecimalDeserializer.class)
	@JsonProperty("id")
	private Integer id;	
	@JsonProperty("name")
	private String name;
	@JsonProperty("value")
	private String value;
		
}
