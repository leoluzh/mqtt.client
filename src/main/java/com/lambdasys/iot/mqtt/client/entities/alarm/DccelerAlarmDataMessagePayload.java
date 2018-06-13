package com.lambdasys.iot.mqtt.client.entities.alarm;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Builder

@SuppressWarnings("serial")
public class DccelerAlarmDataMessagePayload extends AlarmDataMessagePayload {

	public static final String TYPE_NAME = "dcceler" ;
	
}
