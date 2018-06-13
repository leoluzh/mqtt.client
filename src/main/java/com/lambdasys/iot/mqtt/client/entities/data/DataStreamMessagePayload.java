package com.lambdasys.iot.mqtt.client.entities.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lambdasys.iot.mqtt.client.entities.MessagePayload;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

@SuppressWarnings("serial")
public class DataStreamMessagePayload implements MessagePayload {

	private String eventTime;
	
	@JsonProperty("itens")
	private DataStreamItemMessagePayload[] itens;
	
}
