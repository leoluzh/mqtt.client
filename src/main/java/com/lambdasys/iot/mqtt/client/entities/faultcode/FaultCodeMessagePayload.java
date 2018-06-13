package com.lambdasys.iot.mqtt.client.entities.faultcode;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.lambdasys.iot.mqtt.client.entities.MessagePayload;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Leonardo Luz Fernandes
 * @version 0.1
 * @since 11/06/2018
 * 
 * 
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@SuppressWarnings("serial")
public class FaultCodeMessagePayload implements MessagePayload {

	private FaultCodeDataMessagePayload[] data;
	
	@JsonProperty("lon")
	private Double longitude;
	
	@JsonProperty("lat")
	private Double latitude;
	
	@JsonProperty("trip_sn")
	private String tripSn;
	
	//@JsonFormat(shape=Shape.STRING,pattern=MessagePayload.EVENT_TIME_PATTERN)
	//private Date eventTime;
	private String eventTime;
	
}
