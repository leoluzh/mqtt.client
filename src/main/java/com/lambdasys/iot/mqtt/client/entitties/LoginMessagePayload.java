package com.lambdasys.iot.mqtt.client.entitties;

import lombok.Builder;
import lombok.Data;


@Data
@Builder

@SuppressWarnings("serial")
public class LoginMessagePayload implements MessagePayload {

	private String imei;
	private String serialNumber;
	private String sim;
	private String swVersion;
	
}
