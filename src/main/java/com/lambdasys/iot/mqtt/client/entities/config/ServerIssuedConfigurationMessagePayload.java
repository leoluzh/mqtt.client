package com.lambdasys.iot.mqtt.client.entities.config;

import java.util.Date;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lambdasys.iot.mqtt.client.entities.MessagePayload;
import com.lambdasys.iot.mqtt.client.entities.utils.HexaDecimalDeserializer;
import com.lambdasys.iot.mqtt.client.entities.utils.HexaDecimalSerializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Leonardo Luz Fernandes
 * @version 0.1
 * @since 16/06/2018
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@SuppressWarnings("serial")
public class ServerIssuedConfigurationMessagePayload implements MessagePayload {

	@JsonDeserialize(using=HexaDecimalDeserializer.class)
	@JsonSerialize(using=HexaDecimalSerializer.class)
	@JsonProperty("id")
	private Integer id;
	
	@JsonProperty("data")
	private JSONObject data;

	@JsonProperty("time")
	@JsonFormat(shape=Shape.STRING,pattern=MessagePayload.EVENT_TIME_PATTERN)
	private Date time;
	
}
