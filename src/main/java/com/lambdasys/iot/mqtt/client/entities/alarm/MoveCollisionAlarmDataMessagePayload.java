package com.lambdasys.iot.mqtt.client.entities.alarm;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Builder

@SuppressWarnings("serial")
public class MoveCollisionAlarmDataMessagePayload extends AlarmDataMessagePayload {

	public static final String TYPE_NAME = "moveCollision" ;
	
	/**
	 * gensorValue" is the horizontal acceleration，It's based on an algorithm. 4.0 * 9.8 (gravity acceleration const)
	 */
	
	private Double gensorValue;
	
}
