package com.lambdasys.iot.mqtt.client.entities.alarm;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.lambdasys.iot.mqtt.client.entities.MessagePayload;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.Data;


@JsonTypeInfo(
	use = JsonTypeInfo.Id.NAME ,
	include = JsonTypeInfo.As.WRAPPER_OBJECT , 
	property = "type" )
@JsonSubTypes({
	@Type(value=WaterAlarmDataMessagePayload.class,name=WaterAlarmDataMessagePayload.TYPE_NAME) ,
	@Type(value=AccelerAlarmDataMessagePayload.class, name=AccelerAlarmDataMessagePayload.TYPE_NAME) ,
	@Type(value=DccelerAlarmDataMessagePayload.class, name=DccelerAlarmDataMessagePayload.TYPE_NAME) ,
	@Type(value=CarMoveAlarmDataMessagePayload.class, name=CarMoveAlarmDataMessagePayload.TYPE_NAME) ,
	@Type(value=MoveCollisionAlarmDataMessagePayload.class, name=MoveCollisionAlarmDataMessagePayload.TYPE_NAME) ,
	@Type(value=ShakeAlarmDataMessagePayload.class,name=ShakeAlarmDataMessagePayload.TYPE_NAME) ,
})

@Data

@SuppressWarnings("serial")
public class AlarmDataMessagePayload implements MessagePayload {

	private Double lat;
	private Double lon;
	private Integer trip_sn;
	
}
