package com.lambdasys.iot.mqtt.client.entities.diagnostic;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Getter;

@JsonTypeName(value=DiagnosticVehicleInspectorErrorEventMessagePayload.TYPE_NAME)
@SuppressWarnings("serial")
public class DiagnosticVehicleInspectorErrorEventMessagePayload extends DiagnosticEventMessagePayload {

	public static final String TYPE_NAME = "vehicle-inspect-error" ;
	
	@JsonProperty("status")
	private Integer status;
	
	@JsonProperty("msg")
	private String message;
	
	public enum DiagnosticVehicleInspectorErrorStatus {
		
		DEVICE_IS_INSPECTING_NOW ( 1 , "The device is inspecting now!" ) ,
		DEVICE_IS_GOING_TO_SLEEP( 2 , "The device is going to slepp!" ) ,
		DPU_IS_UPDATING( 3 , "The DPU is updating!" ) ,
		DEVICE_IS_DOING_FACTORY_TEST( 4 , "The device is doing factory test" ) ,
		DEVICE_NOT_ACTIVATED( 5 , "The device is not actived!" ) ,
		NO_DIGNOSIS_SOFTWARE_DOWNLOADED( 6 , "There is no diagnosis software download!" ) ,
	    INSPECTION_TIMEOUT ( 7 , "The inspection is timeout!" ) ,
	    DIAGNOSIS_PROCESS_IS_ERROR ( 8  ,  "The diagnosis process is error." ) ,
	    VEHICLE_IS_DRIVING_NOW( 9 , "The vehicle is driving new cannot make a diagnosis.") ,
	    EXIT_THE_DIAGNOSIS( 10 , "During the diagnosis, drive the vehicle and exit diagnosis." ) ;
		
		DiagnosticVehicleInspectorErrorStatus( int code , String description ){
			this.code = code ;
			this.description = description ;
		}
		
		@Getter
		private int code ;
		@Getter
		private String description;
		
	}
	
}
