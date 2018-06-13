package com.lambdasys.iot.mqtt.client.entities.gps;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lambdasys.iot.mqtt.client.entities.MessagePayload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Leonardo Luz Fernandes
 * @version 0.1
 * @since 12/06/2018
 * 
 * DESCRIPTION:
 * Transmit GPS data
 * 
 * TRIGGER MECHANISM:
 * The device collects GPS data at a fixed frequency and stores it locally. 
 * The GPS data will be upload at a fixed frequency given I login response message
 * 
 * 
 * Contains positioning data gathered through GPS/GLONASS hardware.
 * The device stores and sends any location it has at the time of location sampling. No matter its accuracy or its speed. 
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@SuppressWarnings("serial")
public class GPSDataMessagePayload implements MessagePayload {
	
	/** escolher tipo primitivo ou enum? **/
	private Integer mode;
	//private Mode mode;
	
	private Integer direct;
	private Double speed;

	
	@JsonProperty("alt")
	private Double altitude;
	//private Double alt;
	
	@JsonProperty("lon")
	private Double longitude;
	//private Double long;
	
	@JsonProperty("lat")
	private Double latitude;
	//private Double lat;
	
	private Double accuracy;
	
	/** escolher tipo primitivo ou string??**/
	@JsonFormat(shape=Shape.STRING,pattern=MessagePayload.EVENT_TIME_PATTERN)
	private Date eventTime;
	//private String eventTime;
	
	private Double carSpeed;
	
	@JsonProperty("trip_sn")
	private Integer tripSn;
	
	public static enum Mode {
		GPS(1,"GPS") ,
		LBS(2,"LBS") ;
		
		Mode( int mode , String description ){
			this.mode = mode ;
			this.description = description;
		}
		@Getter
		private int mode;
		@Getter
		private String description;
		
	}
	
}
