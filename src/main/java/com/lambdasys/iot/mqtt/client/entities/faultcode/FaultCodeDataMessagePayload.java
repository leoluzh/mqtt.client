package com.lambdasys.iot.mqtt.client.entities.faultcode;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.lambdasys.iot.mqtt.client.entities.MessagePayload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
@NoArgsConstructor
@AllArgsConstructor

@SuppressWarnings("serial")
public class FaultCodeDataMessagePayload implements MessagePayload {

	//Houston we have a problem ... where is the value in doc's example??
	private String token;
	
	@JsonProperty("faultDes")
	private String faultDescription;
	
	private String faultId;
	private String sysId;
	private String faultValue;
	//private Integer faultStatus;
	@JsonProperty("faultStatus")
	private FaultStatusCode faultStatus;
	
	
	@JsonFormat(shape=Shape.NUMBER_INT)
	public enum FaultStatusCode {
		
		PERMANENT( 1 , "Permanent" ) ,
		CURRENT( 2 , "Current" ) ,
		UNSOLVED( 3 , "Unsolved" ) ,
		HISTORICAL( 4 , "Historical" ) ;
		
		FaultStatusCode( int code , String description ){
			this.code = code ; 
			this.description = description ; 
		}
		
		private static final Map<Integer,FaultStatusCode> CACHE; 
		
		static{
			//transform list to map
			CACHE = valuesAsList()
						.stream()
						.collect(Collectors.toMap( 
								x -> x.getCode() , 
								x -> x ) );
		}
		
		@JsonValue
		@Getter
		private int code;
		
		@Getter
		private String description;
		
		//use to deserialize value...
		@JsonCreator
		public static FaultStatusCode fromCode( int code ) {
			return CACHE.get( code );
		}
		
		public static List<FaultStatusCode> valuesAsList(){
			return Arrays.asList( FaultStatusCode.values() );
		}
		
		public static Map<Integer,FaultStatusCode> valuesAsMap(){
			return CACHE;
		}
		
	}
	
}
