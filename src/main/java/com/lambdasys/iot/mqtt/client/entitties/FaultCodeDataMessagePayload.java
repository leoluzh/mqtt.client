package com.lambdasys.iot.mqtt.client.entitties;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

/**
 * Fault code v 1.0.0
 * Transfers detected DTC fault codes. It is send automatically whenever any EOBD fault code is detected. The DTCs are read and sent every 5 minutes. If there is no DTC, nothing is sent.
 *
 * @author Leonardo Luz Fernandes
 * @version 0.1
 * @since 10/06/2018
 *
 */

@Data
@Builder

@SuppressWarnings("serial")
public class FaultCodeDataMessagePayload implements MessagePayload {

	private String token;
	private String faultDes;
	private String faultId;
	private String sysId;
	private String faultValue;
	private Integer faultStatus;
	
	public enum FaultStatusCode {
		PERMANENT( 1 , "Permanent" ) ,
		CURRENT( 2 , "Current" ) ,
		UNSOLVED( 3 , "Unsolved" ) ,
		HISTORICAL( 4 , "Historical" ) ;
		FaultStatusCode( int code , String description ){
			this.code = code ; 
			this.description = description ; 
		}
		@Getter
		private int code;
		@Getter
		private String description;
	}
	
}
