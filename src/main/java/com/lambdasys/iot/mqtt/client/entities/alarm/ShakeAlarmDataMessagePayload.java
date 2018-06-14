package com.lambdasys.iot.mqtt.client.entities.alarm;

import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Leonardo Luz Fernandes
 * @version 0.1
 * @since 12/06/2018
 *
 */

@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@JsonTypeName("shake")
@SuppressWarnings("serial")
public class ShakeAlarmDataMessagePayload extends AlarmDataMessagePayload {

	public static final String TYPE_NAME = "shake";
	
	protected Double gensorValue;
	
	/** Workarond to inherance **/
	@Builder
	public ShakeAlarmDataMessagePayload( Double latitude , Double longitude , Integer tripSn , Double gensorValue ) {
		super(latitude, longitude, tripSn);
		this.gensorValue = gensorValue;
	}
	
	
}
