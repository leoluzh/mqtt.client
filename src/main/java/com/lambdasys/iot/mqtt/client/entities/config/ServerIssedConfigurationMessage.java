package com.lambdasys.iot.mqtt.client.entities.config;

import com.lambdasys.iot.mqtt.client.entities.Message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @author Leonardo Luz Fernandes
 * @version 0.1
 * @since 16/06/2018
 * 
 * Values of signals gathered from the vehicle through OBD interface
 * 
 */

@Builder
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)

@SuppressWarnings("serial")
public class ServerIssedConfigurationMessage extends Message<ServerIssuedConfigurationMessagePayload> {

	public static final String NAME = "com.launch.obd.device.message.config" ;
	public static final String VERSION = "1.0.0" ;
	public static final String DIRECTION = "Sent by IoT to Cloud" ;
	public static final Boolean RESPONSE_REQUIRED = false ;
	public static final Boolean CONTAINS_TIMESTAMP = false ;
		
}
