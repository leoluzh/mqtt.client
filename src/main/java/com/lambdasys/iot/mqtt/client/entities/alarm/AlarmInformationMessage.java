package com.lambdasys.iot.mqtt.client.entities.alarm;

import com.lambdasys.iot.mqtt.client.entities.Message;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @author Leonardo Luz Fernandes
 * @version 0.1
 * @since 12/06/2018
 * 
 * Send by IoT when some vehicle based event, which requires attention happens.
 *
 */

@Builder
@Data
@EqualsAndHashCode(callSuper=true)

@SuppressWarnings("serial")
public class AlarmInformationMessage extends Message<AlarmMessagePayload> {

	public static final String NAME = "com.launch.obd.device.message.alarm" ;
	public static final String VERSION = "1.0.0" ;
	public static final String DIRECTION = "Sent by IoT to Cloud" ;
	public static final Boolean RESPONSE_REQUIRED = true ;
	public static final Boolean CONTAINS_TIMESTAMP = true ;
		
}
