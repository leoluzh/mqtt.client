package com.lambdasys.iot.mqtt.client.entities.alarm;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
