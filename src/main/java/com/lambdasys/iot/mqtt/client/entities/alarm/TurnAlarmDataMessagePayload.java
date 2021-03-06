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
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@JsonTypeName("turn")
@SuppressWarnings("serial")
public class TurnAlarmDataMessagePayload extends AlarmDataMessagePayload {

	public static final String TYPE_NAME = "turn" ;
	
	/** Workarond to inherance **/
	@Builder
	public TurnAlarmDataMessagePayload( Double latitude , Double longitude , Integer tripSn ) {
		super(latitude, longitude, tripSn);
	}
		
}
