package com.lambdasys.iot.mqtt.client.entities.report;

import com.lambdasys.iot.mqtt.client.entities.Message;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Leonardo Luz Fernandes
 * @version 0.1
 * @since 16/06/2018
 *
 */

@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@Builder

@SuppressWarnings("serial")
public class DiagnosticResultMessage extends Message<DiagnosticResultMessagePayload> {

	public static final String NAME = "com.launch.obd.device.message.report" ;
	public static final String VERSION = "1.0.0" ;
	public static final String DIRECTION = "Sent by IoT to Cloud" ;
	public static final Boolean RESPONSE_REQUIRED = false ;
	public static final Boolean CONTAINS_TIMESTAMP = true ;
		
}
