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
public class AccelerAlarmDataMessagePayload extends AlarmDataMessagePayload {

	public static final String TYPE_NAME = "acceler" ;
	
	/** Workarond to inherance **/
	@Builder
	public AccelerAlarmDataMessagePayload( Double latitude , Double longitude , Integer tripSn ) {
		super(latitude, longitude, tripSn);
	}
	
}
