package com.lambdasys.iot.mqtt.client.entities.trip;

import com.lambdasys.iot.mqtt.client.entities.MessagePayload;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Leonardo Luz Fernandes
 * @version 0.1
 * @since 12/06/2018
 *
 */


/**
@JsonTypeInfo(
		use = JsonTypeInfo.Id.NAME ,
		include = JsonTypeInfo.As.WRAPPER_OBJECT , 
		property = "type" )
	@JsonSubTypes({
		@Type(value=TripStartContentMessagePayload.class,name=TripStartContentMessagePayload.TYPE_NAME) ,
		@Type(value=TripEndContentMessagePayload.class,name=TripEndContentMessagePayload.TYPE_NAME) ,
	})
**/

@Data
@NoArgsConstructor

@SuppressWarnings("serial")
public class TripDataMessagePayload implements MessagePayload {

}
