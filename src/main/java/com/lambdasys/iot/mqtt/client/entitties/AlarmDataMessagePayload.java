package com.lambdasys.iot.mqtt.client.entitties;

import lombok.Data;

@Data

@SuppressWarnings("serial")
public class AlarmDataMessagePayload implements MessagePayload {

	private Double lat;
	private Double lon;
	private Integer trip_sn;
	
}
