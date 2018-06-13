package com.lambdasys.iot.mqtt.client.entities.trip;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

@SuppressWarnings("serial")
public class TripStartContentMessagePayload extends TripDataContentMessagePayload {

	public static final String TYPE_NAME = "start" ;
	
	@JsonProperty("trip_sn")
	private Integer tripSn;
	
	//@JsonFormat(shape=Shape.STRING,pattern=MessagePayload.EVENT_TIME_PATTERN)
	//private Date startTime;
	private String startTime;
	
}
