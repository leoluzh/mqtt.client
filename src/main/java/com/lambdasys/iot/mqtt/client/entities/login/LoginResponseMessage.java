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
 */

@Builder
@Data
@EqualsAndHashCode(callSuper=true)

@SuppressWarnings("serial")
public class LoginResponseMessage extends Message<LoginResponseMessagePayload> {

	public static final String NAME = "com.launch.obd.device.message.loginresponse" ;
	public static final String VERSION = "1.0.0" ;
	public static final String DIRECTION = "Sent by Cloud to IoT" ;
	public static final Boolean RESPONSE_REQUIRED = false ;
	public static final Boolean CONTAINS_TIMESTAMP = false ;
	
}
