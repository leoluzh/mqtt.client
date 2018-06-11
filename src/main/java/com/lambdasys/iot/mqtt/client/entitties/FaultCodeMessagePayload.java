package com.lambdasys.iot.mqtt.client.entitties;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

@SuppressWarnings("serial")
public class FaultCodeMessagePayload implements MessagePayload {

	private FaultCodeDataMessagePayload[] data;
	private Double lon;
	private Double lat;
	private String trip_sn;
	private String eventTime;
	
}
