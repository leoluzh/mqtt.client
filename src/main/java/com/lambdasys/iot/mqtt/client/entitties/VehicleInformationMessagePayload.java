package com.lambdasys.iot.mqtt.client.entitties;

import lombok.Builder;
import lombok.Data;

/**
 * This message transfers static vehicle information such as VIN code of the vehicle and available signals.
 *
 * @author Leonardo Luz Fernandes
 * @version 0.1
 * @since 10/06/2018
 * 
 */

@Data
@Builder

@SuppressWarnings("serial")
public class VehicleInformationMessagePayload implements MessagePayload {

	private String type;
	private String eventTime;
	
}
