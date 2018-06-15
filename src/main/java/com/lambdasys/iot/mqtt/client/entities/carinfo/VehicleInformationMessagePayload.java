package com.lambdasys.iot.mqtt.client.entities.carinfo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.lambdasys.iot.mqtt.client.entities.MessagePayload;

import lombok.Builder;
import lombok.Data;

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

@SuppressWarnings("serial")
public class VehicleInformationMessagePayload implements MessagePayload {

	private String type;
	
	@JsonFormat(shape=Shape.STRING,pattern=MessagePayload.EVENT_TIME_PATTERN)
	private Date date;
	//private String eventTime;
	
}
