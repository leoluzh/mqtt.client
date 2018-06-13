package com.lambdasys.iot.mqtt.client.entities.login;

import com.lambdasys.iot.mqtt.client.entities.MessagePayload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@SuppressWarnings("serial")
public class LoginRequestMessagePayload implements MessagePayload {

	private String imei;
	private String serialNumber;
	private String sim;
	private String swVersion;
	
}
