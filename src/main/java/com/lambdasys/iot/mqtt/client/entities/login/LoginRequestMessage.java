package com.lambdasys.iot.mqtt.client.entities.login;

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
 * 
 * DESCRIPTION: 
 * 
 * 	Some configuration information returned after the successful connection with OM server. 
 * 
 * TRIGGER MECANISM: 
 * 
 * This message will be sent when the device wakes up, or power on, or reconnects to IoT hub 
 * after disconnection.
 *   
 */

@Builder
@Data
@EqualsAndHashCode(callSuper=true)

@SuppressWarnings("serial")
public class LoginRequestMessage extends Message<LoginRequestMessagePayload> {

	public static final String NAME = "com.launch.obd.device.message.login" ;
	public static final String VERSION = "1.0.0" ;
	public static final String DIRECTION = "Sent by IoT to Cloud" ;
	public static final Boolean RESPONSE_REQUIRED = true ;
	public static final Boolean CONTAINS_TIMESTAMP = false ;
	
}
