package com.lambdasys.iot.mqtt.client.entities.trip;

import com.lambdasys.iot.mqtt.client.entities.Message;

/**
 * 
 * @author Leonardo Luz Fernandes
 * @version 0.1
 * @since 11/06/2018
 * 
 * The IoT device can determine different trips. 
 * The trip is defined by two messages one trip start and the second one when trip ends.
 * 
 */

@SuppressWarnings("serial")
public class TripMessage extends Message<TripMessagePayload> {

	public static final String NAME = "com.launch.obd.device.message.trip" ;
	public static final String VERSION = "1.0.0" ;
	public static final String DIRECTION = "Sent by IoT to Cloud" ;
	public static final Boolean RESPONSE_REQUIRED = false ;
	public static final Boolean CONTAINS_TIMESTAMP = true ;
		
}
