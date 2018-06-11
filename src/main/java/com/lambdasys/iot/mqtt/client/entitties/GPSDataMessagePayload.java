package com.lambdasys.iot.mqtt.client.entitties;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder

@SuppressWarnings("serial")
public class GPSDataMessagePayload implements MessagePayload {
	
	private Integer mode;
	private Integer direct;
	private Double speed;
	private Double alt;
	private Double lon;
	private Double lat;
	private Double accuracy;
	private String eventTime;
	private Double carSpeed;
	private Integer trip_sn;
	
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
