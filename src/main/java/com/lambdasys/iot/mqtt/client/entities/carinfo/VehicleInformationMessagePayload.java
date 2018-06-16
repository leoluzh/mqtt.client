package com.lambdasys.iot.mqtt.client.entities.carinfo;

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
 * This message transfers static vehicle information such as VIN code of the vehicle and available signals.
 *
 * @author Leonardo Luz Fernandes
 * @version 0.1
 * @since 10/06/2018
 * 
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@SuppressWarnings("serial")
public class VehicleInformationMessagePayload implements MessagePayload {

	public static final NamedType[] SUBTYPES;
	
	static {
		SUBTYPES = new NamedType[]{
				new NamedType( VehicleInformationDataCanBusCollectedMessagePayload.class , VehicleInformationDataCanBusCollectedMessagePayload.TYPE_NAME ) ,
				new NamedType( VehicleInformationDataTableIdsMessagePayload.class, VehicleInformationDataTableIdsMessagePayload.TYPE_NAME ) ,
				new NamedType( VehicleInformationMatchInfoProtocolMessagePayload.class, VehicleInformationMatchInfoProtocolMessagePayload.TYPE_NAME ) , 
				new NamedType( VehicleInformationNumberMessagePayload.class, VehicleInformationNumberMessagePayload.TYPE_NAME ) ,
				new NamedType( VehicleInformationSoftwareVersionMessagePayload.class, VehicleInformationSoftwareVersionMessagePayload.TYPE_NAME ) ,
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
			@Type(value=VehicleInformationDataCanBusCollectedMessagePayload.class,name=VehicleInformationDataCanBusCollectedMessagePayload.TYPE_NAME) ,
			@Type(value=VehicleInformationDataTableIdsMessagePayload.class, name=VehicleInformationDataTableIdsMessagePayload.TYPE_NAME) ,
			@Type(value=VehicleInformationMatchInfoProtocolMessagePayload.class, name=VehicleInformationMatchInfoProtocolMessagePayload.TYPE_NAME) ,
			@Type(value=VehicleInformationNumberMessagePayload.class, name=VehicleInformationNumberMessagePayload.TYPE_NAME) ,
			@Type(value=VehicleInformationSoftwareVersionMessagePayload.class, name=VehicleInformationSoftwareVersionMessagePayload.TYPE_NAME) ,
	})			
	@JsonProperty(value="data")
	private VehicleInformationDataMessagePayload data;
	
}
