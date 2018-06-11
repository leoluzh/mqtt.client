package com.lambdasys.iot.mqtt.client.entitties;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Builder

@SuppressWarnings("serial")
public class WaterAlarmDataMessagePayload extends AlarmDataMessagePayload {

	private Integer warterValue;
		
}
