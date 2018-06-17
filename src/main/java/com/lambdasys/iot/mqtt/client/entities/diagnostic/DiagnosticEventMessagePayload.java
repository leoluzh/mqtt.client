package com.lambdasys.iot.mqtt.client.entities.diagnostic;

import com.lambdasys.iot.mqtt.client.entities.MessagePayload;

import lombok.Builder;
import lombok.Data;

/**
 * 
 * @author Leonardo Luz Fernandes
 * @version 0.1
 * @since 16/06/2018
 *
 */

@Data
@Builder

@SuppressWarnings("serial")
public class DiagnosticEventMessagePayload implements MessagePayload {
	
}
