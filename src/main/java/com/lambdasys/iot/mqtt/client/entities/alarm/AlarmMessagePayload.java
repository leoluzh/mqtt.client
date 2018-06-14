package com.lambdasys.iot.mqtt.client.entities.alarm;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.lambdasys.iot.mqtt.client.entities.MessagePayload;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Leonardo Luz Fernandes
 * @version 0.1
 * @since 12/06/2018
 * 
 * DESCRIPTION:
 * Upload alarm information
 * 
 * TRIGGER MECHANISM:
 * The alarm information will sent to server after the alarm condition is met.
 * 
 * Send by IoT when some vehicle based event, which requires attention happens.
 *
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@SuppressWarnings("serial")
public class AlarmMessagePayload implements MessagePayload {

	private String type;

	@JsonFormat(shape=Shape.STRING,pattern=MessagePayload.EVENT_TIME_PATTERN)
	private Date eventTime;
	//private String eventTime;

	@JsonProperty(value="data")
	private AlarmDataMessagePayload data; 
	
	
}
