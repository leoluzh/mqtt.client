package com.lambdasys.iot.mqtt.client.entities.trip;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.lambdasys.iot.mqtt.client.entities.MessagePayload;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@SuppressWarnings("serial")
public class TripMessagePayload implements MessagePayload {

	private String type;
	
	//@JsonFormat(shape=Shape.STRING,pattern=MessagePayload.EVENT_TIME_PATTERN)
	//private Date eventTime;
	private String eventTime;
	
	@JsonProperty("data")
	private TripDataContentMessagePayload data;
	
}
