package com.lambdasys.iot.mqtt.client.entitties;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

@SuppressWarnings("serial")
public class AlarmMessagePayload implements MessagePayload {

	private AlarmDataMessagePayload data; 
	private String type;
	private String eventType;
	
}
