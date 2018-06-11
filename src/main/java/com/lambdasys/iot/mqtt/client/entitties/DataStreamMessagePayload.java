package com.lambdasys.iot.mqtt.client.entitties;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

@SuppressWarnings("serial")
public class DataStreamMessagePayload implements MessagePayload {

	private String eventTime;
	private DataStreamItemMessagePayload[] itens;
	
}
