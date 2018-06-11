package com.lambdasys.iot.mqtt.client.entitties;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

@SuppressWarnings("serial")
public class TripMessagePayload implements MessagePayload {

	private String type;
	private String eventTime;
	
}
