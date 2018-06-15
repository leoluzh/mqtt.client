package com.lambdasys.iot.mqtt.client.entities.alarm;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.lambdasys.iot.mqtt.client.entities.MessagePayload;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Leonardo Luz Fernandes
 * @version 0.1
 * @since 12/06/2018
 * 
 * DESCRIPTION:
 * Upload alarm information
 * 
 * TRIGGER MECHANISM:
 * The alarm information will sent to server after the alarm condition is met.
 * 
 * Send by IoT when some vehicle based event, which requires attention happens.
 *
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@SuppressWarnings("serial")
public class AlarmMessagePayload implements MessagePayload {

	public static final NamedType[] SUBTYPES;
	
	static {
		SUBTYPES = new NamedType[]{
				new NamedType( WaterAlarmDataMessagePayload.class , WaterAlarmDataMessagePayload.TYPE_NAME ) ,
				new NamedType( AccelerAlarmDataMessagePayload.class, AccelerAlarmDataMessagePayload.TYPE_NAME ) ,
				new NamedType( DccelerAlarmDataMessagePayload.class, DccelerAlarmDataMessagePayload.TYPE_NAME ) , 
				new NamedType( CarMoveAlarmDataMessagePayload.class, MoveCollisionAlarmDataMessagePayload.TYPE_NAME ) ,
				new NamedType( MoveCollisionAlarmDataMessagePayload.class, MoveCollisionAlarmDataMessagePayload.TYPE_NAME ) ,
				new NamedType( ShakeAlarmDataMessagePayload.class, ShakeAlarmDataMessagePayload.TYPE_NAME ) ,
				new NamedType( TurnAlarmDataMessagePayload.class, TurnAlarmDataMessagePayload.TYPE_NAME )
		};
	}
	
	@JsonTypeId
	@JsonProperty("type")
	protected String type;

	@JsonFormat(shape=Shape.STRING,pattern=MessagePayload.EVENT_TIME_PATTERN)
	protected Date eventTime;
	//private String eventTime;

	@JsonTypeInfo(
			use = JsonTypeInfo.Id.NAME ,
			include = JsonTypeInfo.As.EXTERNAL_PROPERTY , 
			property = "type" )
		@JsonSubTypes({
			@Type(value=WaterAlarmDataMessagePayload.class,name=WaterAlarmDataMessagePayload.TYPE_NAME) ,
			@Type(value=AccelerAlarmDataMessagePayload.class, name=AccelerAlarmDataMessagePayload.TYPE_NAME) ,
			@Type(value=DccelerAlarmDataMessagePayload.class, name=DccelerAlarmDataMessagePayload.TYPE_NAME) ,
			@Type(value=CarMoveAlarmDataMessagePayload.class, name=CarMoveAlarmDataMessagePayload.TYPE_NAME) ,
			@Type(value=MoveCollisionAlarmDataMessagePayload.class, name=MoveCollisionAlarmDataMessagePayload.TYPE_NAME) ,
			@Type(value=ShakeAlarmDataMessagePayload.class,name=ShakeAlarmDataMessagePayload.TYPE_NAME) ,
			@Type(value=TurnAlarmDataMessagePayload.class,name=TurnAlarmDataMessagePayload.TYPE_NAME) ,
		})		
	@JsonProperty(value="data")
	protected AlarmDataMessagePayload data; 
	
	
}
