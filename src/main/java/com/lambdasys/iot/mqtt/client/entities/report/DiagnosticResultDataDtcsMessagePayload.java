package com.lambdasys.iot.mqtt.client.entities.report;

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
 * @since 16/06/2018
 *
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@SuppressWarnings("serial")
public class DiagnosticResultDataDtcsMessagePayload implements MessagePayload {

	@JsonProperty("faultDes")
	private String faultDescription;
	
	@JsonProperty("faultId")
	private String faultId;
	
	@JsonProperty("sysId")
	private String systemId;
	
	@JsonProperty("faultValue")
	private String faultValue;
	
	@JsonProperty("faultStatus")
	private Integer faultStatus;
	
	
	public enum FaultStautsCode {
		
		PERMANENT( 1  , "Permanent" ) ,
		CURRENT( 2 , "Current" ) ,
		UNSOLVED( 3 , "Unsolved" ) ,
		HISTORICAL( 4 , "Historical" ) ;
		
		private FaultStautsCode( int code , String description ) {
			this.code = code ;
			this.description = description ;
		}
		
		@Getter
		private int code;
		@Getter
		private String description;
		
	}
	
}
