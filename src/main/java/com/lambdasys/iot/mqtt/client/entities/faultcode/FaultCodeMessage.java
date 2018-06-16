package com.lambdasys.iot.mqtt.client.entities.faultcode;

import com.lambdasys.iot.mqtt.client.entities.Message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @author Leonardo Luz Fernandes
 * @version 0.1
 * @since 11/06/2018
 * 
 * 
 */

@Builder
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)

@SuppressWarnings("serial")
public class FaultCodeMessage extends Message<FaultCodeMessagePayload> {

	public static final String NAME = "com.launch.obd.device.message.faultCode" ;
	public static final String VERSION = "1.0.0" ;
	public static final String DIRECTION = "Sent by IoT to Cloud" ;
	public static final Boolean RESPONSE_REQUIRED = false ;
	public static final Boolean CONTAINS_TIMESTAMP = true ;
		
}
