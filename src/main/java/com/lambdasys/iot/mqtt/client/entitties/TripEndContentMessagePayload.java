package com.lambdasys.iot.mqtt.client.entitties;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

@SuppressWarnings("serial")
public class TripEndContentMessagePayload implements MessagePayload {

	private Integer trip_sn;
	private String endTime;
	private Double milage;
	private Float oil;
	private String eventTime;
	private Double start_lat;
	private Double start_lon;
	private Double end_lat;
	private Double end_lon;
	
}
