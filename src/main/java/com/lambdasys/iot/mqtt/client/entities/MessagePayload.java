package com.lambdasys.iot.mqtt.client.entities;

import java.io.Serializable;

/**
 * 
 * @author Leonardo Luz Fernandes
 * @version 0.1
 * @since 13/06/2018
 *
 */

public interface MessagePayload extends Serializable {

	public static final String EVENT_TIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'Z'" ;
	
}
