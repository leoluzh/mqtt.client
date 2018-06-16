package com.lambdasys.iot.mqtt.client.entities.trip;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lambdasys.iot.mqtt.client.entities.MessagePayload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@SuppressWarnings("serial")
public class TripStartDataMessagePayload extends TripDataMessagePayload {

	public static final String TYPE_NAME = "start" ;
	
	@JsonProperty("trip_sn")
	private Integer tripSn;
	
	@JsonFormat(shape=Shape.STRING,pattern=MessagePayload.EVENT_TIME_PATTERN)
	private Date startTime;
	
}
