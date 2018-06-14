package com.lambdasys.iot.mqtt.client.entities.alarm;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Leonardo Luz Fernandes
 * @version 0.1
 * @since 13/06/2018
 *
 */

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)

@SuppressWarnings("serial")
public class CarMoveAlarmDataMessagePayload extends AlarmDataMessagePayload {

	public static final String TYPE_NAME = "carMove" ;
	
	/** Workarond to inherance **/
	@Builder
	public CarMoveAlarmDataMessagePayload( Double latitude , Double longitude , Integer tripSn ) {
		super(latitude, longitude, tripSn);
	}
	
	
}
