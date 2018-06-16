package com.lambdasys.iot.mqtt.client.entities.carinfo;

import com.lambdasys.iot.mqtt.client.entities.Message;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Builder

@SuppressWarnings("serial")
public class VehicleInformationMessage extends Message<VehicleInformationMessagePayload> {

	public static final String NAME = "com.launch.obd.device.message.carInfo" ;
	public static final String VERSION = "1.0.0" ;
	public static final String DIRECTION = "Sent by IoT to Cloud" ;
	public static final Boolean RESPONSE_REQUIRED = false ;
	public static final Boolean CONTAINS_TIMESTAMP = true ;
	
}
