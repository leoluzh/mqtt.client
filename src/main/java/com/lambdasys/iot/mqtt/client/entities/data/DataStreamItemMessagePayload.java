package com.lambdasys.iot.mqtt.client.entities.data;

import com.lambdasys.iot.mqtt.client.entities.MessagePayload;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

@SuppressWarnings("serial")
public class DataStreamItemMessagePayload implements MessagePayload {

	private Integer id;
	private String name;
	private String value;
		
}
