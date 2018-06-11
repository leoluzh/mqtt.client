package com.lambdasys.iot.mqtt.client.entitties;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Builder

@SuppressWarnings("serial")
public class MoveCollisionAlarmDataMessagePayload extends AlarmDataMessagePayload {

	/**
	 * gensorValue" is the horizontal acceleration，It's based on an algorithm. 4.0 * 9.8 (gravity acceleration const)
	 */
	
	private Double gensorValue;
	
}
