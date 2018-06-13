package com.lambdasys.iot.mqtt.client.entities.trip;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
@Builder

@SuppressWarnings("serial")
public class TripEndContentMessagePayload extends TripDataContentMessagePayload {

	public static final String TYPE_NAME = "end" ;
	
	@JsonProperty("trip_sn")
	private String tripSn;
	
	//@JsonFormat(shape=Shape.STRING,pattern=MessagePayload.EVENT_TIME_PATTERN)
	//private Date endTime;
	private String endTime;
	
	
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
