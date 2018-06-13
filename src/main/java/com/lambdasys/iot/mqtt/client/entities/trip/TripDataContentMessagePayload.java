package com.lambdasys.iot.mqtt.client.entities.trip;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.lambdasys.iot.mqtt.client.entities.MessagePayload;

@JsonTypeInfo(
		use = JsonTypeInfo.Id.NAME ,
		include = JsonTypeInfo.As.WRAPPER_OBJECT , 
		property = "type" )
	@JsonSubTypes({
		@Type(value=TripStartContentMessagePayload.class,name=TripStartContentMessagePayload.TYPE_NAME) ,
		@Type(value=TripEndContentMessagePayload.class,name=TripEndContentMessagePayload.TYPE_NAME) ,
	})
@SuppressWarnings("serial")
public class TripDataContentMessagePayload implements MessagePayload {

}
