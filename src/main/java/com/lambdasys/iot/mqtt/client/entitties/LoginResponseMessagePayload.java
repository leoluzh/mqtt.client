package com.lambdasys.iot.mqtt.client.entitties;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

@SuppressWarnings("serial")
public class LoginResponseMessagePayload implements MessagePayload {

	private Integer gpsCicle;
	private Integer gspSampleCicle;
	private Integer dataStreamCicle;
	private Integer dataStreamSampleCicle;
	
}
