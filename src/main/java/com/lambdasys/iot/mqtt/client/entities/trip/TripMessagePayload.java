package com.lambdasys.iot.mqtt.client.entities.trip;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.lambdasys.iot.mqtt.client.entities.MessagePayload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Leonardo Luz Fernandes
 * @version 0.1
 * @since 11/06/2018
 * 
 * The IoT device can determine different trips. 
 * The trip is defined by two messages one trip start and the second one when trip ends.
 * 
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@SuppressWarnings("serial")
public class TripMessagePayload implements MessagePayload {
	
	public static final NamedType SUBTYPES[]; 
	
	static {
		SUBTYPES = new NamedType[] {
				new NamedType(TripStartDataMessagePayload.class,TripStartDataMessagePayload.TYPE_NAME) ,
				new NamedType(TripEndDataMessagePayload.class,TripEndDataMessagePayload.TYPE_NAME)
		};
	}
	

	@JsonTypeId
	@JsonProperty("type")
	private String type;
	
	@JsonFormat(shape=Shape.STRING,pattern=MessagePayload.EVENT_TIME_PATTERN)
	private Date eventTime;
	
	@JsonTypeInfo(
			use = JsonTypeInfo.Id.NAME ,
			include = JsonTypeInfo.As.EXTERNAL_PROPERTY , 
			property = "type" )
		@JsonSubTypes({
			@Type(value=TripEndDataMessagePayload.class,name=TripEndDataMessagePayload.TYPE_NAME) ,
			@Type(value=TripEndDataMessagePayload.class, name=TripEndDataMessagePayload.TYPE_NAME) ,
		})		
	@JsonProperty("data")
	private TripDataMessagePayload data;
	
}
