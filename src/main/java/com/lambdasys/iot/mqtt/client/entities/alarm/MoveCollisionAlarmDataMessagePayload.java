package com.lambdasys.iot.mqtt.client.entities.alarm;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @author Leonardo Luz Fernandes
 * @version 0.1
 * @since 12/06/2018
 *
 */

@Data
@EqualsAndHashCode(callSuper=true)

@SuppressWarnings("serial")
public class MoveCollisionAlarmDataMessagePayload extends AlarmDataMessagePayload {

	public static final String TYPE_NAME = "moveCollision" ;
	
	/**
	 * gensorValue" is the horizontal acceleration，It's based on an algorithm. 4.0 * 9.8 (gravity acceleration const)
	 */
	
	protected Double gensorValue;
	
	/** Workarond to inherance **/
	@Builder
	public MoveCollisionAlarmDataMessagePayload( Double latitude , Double longitude , Integer tripSn , Double gensorValue ) {
		super(latitude, longitude, tripSn);
		this.gensorValue = gensorValue;
	}
	
}
