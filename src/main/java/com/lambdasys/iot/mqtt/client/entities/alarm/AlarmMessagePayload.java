package com.lambdasys.iot.mqtt.client.entities.alarm;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.lambdasys.iot.mqtt.client.entities.MessagePayload;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

@SuppressWarnings("serial")
public class AlarmMessagePayload implements MessagePayload {

	private String type;

	/** **/
	//@JsonFormat(shape=Shape.STRING,pattern=MessagePayload.EVENT_TIME_PATTERN)
	//private Date eventTime;
	private String eventTime;

	@JsonProperty(value="data")
	private AlarmDataMessagePayload data; 
	
	
}
