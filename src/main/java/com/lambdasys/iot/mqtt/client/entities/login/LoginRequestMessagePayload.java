package com.lambdasys.iot.mqtt.client.entities.login;

import com.lambdasys.iot.mqtt.client.entities.MessagePayload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Leonardo Luz Fernandes
 * @verion 0.1
 * @since 12/06/2018
 * 
 * DESCRIPTION:
 * Some configuration information returned after the successful connection with OM server.   
 * 
 * TRIGGER MECHANISM: 
 * This message will be sent when the device wakes up, or power on, or reconnects to IoT hub after disconnection.
 * Login request message is send immediately after power up when the IoT device obtains connection to IoT Hub (Broker).
 * 
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@SuppressWarnings("serial")
public class LoginRequestMessagePayload implements MessagePayload {

	private String imei;
	private String serialNumber;
	private String sim;
	private String swVersion;
	
}
