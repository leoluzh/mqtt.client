package com.lambdasys.iot.mqtt.client.entities.gps;

import com.lambdasys.iot.mqtt.client.entities.Message;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @author Leonardo Luz Fernandes
 * @version 0.1
 * @since 11/06/2018
 * 
 * Contains positioning data gathered through GPS/GLONASS hardware.
 * The device stores and sends any location it has at the time of location sampling. No matter its accuracy or its speed. 
 *
 */

@Builder
@Data
@EqualsAndHashCode(callSuper=true)

@SuppressWarnings("serial")
public class GPSDataMessage extends Message<GPSDataMessagePayload[]> {

	public static final String NAME = "com.launch.obd.device.message.gps" ;
	public static final String VERSION = "1.0.0" ;
	public static final String DIRECTION = "Sent by IoT to Cloud" ;
	public static final Boolean RESPONSE_REQUIRED = false ;
	public static final Boolean CONTAINS_TIMESTAMP = true ;
		
}
