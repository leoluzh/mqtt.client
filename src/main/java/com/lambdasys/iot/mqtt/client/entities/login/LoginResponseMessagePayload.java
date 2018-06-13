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
 * 
 * 
 * This message is reply to the login request. It is send by the cloud to the device. 
 * It contains several settings device should use. 
 * The settings should be persisted on the device and should be used until next login response message will arrive. 
 * The device should not be blocked by waiting to the login reply. 
 * Settings from last login reply or default settings should be used after power up. 
 * Any data can be sampled right after power up.
 * 
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@SuppressWarnings("serial")
public class LoginResponseMessagePayload implements MessagePayload {

	private Integer gpsCycle;
	private Integer gpsSampleCycle;
	private Integer dataStreamCycle;
	private Integer dataStreamSampleCycle;
	
}
