package com.lambdasys.iot.mqtt.client.entitties;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

@SuppressWarnings("serial")
public class TripStartContentMessagePayload implements MessagePayload {

	private Integer trip_sn;
	private String startTime;
	
}
