package com.lambdasys.iot.mqtt.client.entities.trip;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lambdasys.iot.mqtt.client.entities.MessagePayload;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @author Leonardo Luz Fernandes
 * @version 0.1
 * @since 12/06/2018
 *
 */

@Data
@EqualsAndHashCode(callSuper=true)
@Builder

@SuppressWarnings("serial")
public class TripEndDataMessagePayload extends TripDataMessagePayload {

	public static final String TYPE_NAME = "end" ;
	
	//houston we have a problem ... example is integer but in doc's is string 
	@JsonProperty("trip_sn")
	private Integer tripSn;
	
	@JsonFormat(shape=Shape.STRING,pattern=MessagePayload.EVENT_TIME_PATTERN)
	private Date endTime;
		
	private Double mileage;
	
	private Float oil;

	@JsonProperty("start_lat")
	private Double startLatitude;
	
	@JsonProperty("start_lon")
	private Double startLongitude;
	
	@JsonProperty("end_lat")
	private Double endLatitude;
	
	@JsonProperty("end_lon")
	private Double endLongitude;
	
	
}
