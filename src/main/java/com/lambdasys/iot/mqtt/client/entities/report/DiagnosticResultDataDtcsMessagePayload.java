package com.lambdasys.iot.mqtt.client.entities.report;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
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
	//private FaultStatusCode faultStatus;
	
	@JsonFormat(shape=Shape.NUMBER_INT)
	public enum FaultStatusCode {
		
		PERMANENT( 1  , "Permanent" ) ,
		CURRENT( 2 , "Current" ) ,
		UNSOLVED( 3 , "Unsolved" ) ,
		HISTORICAL( 4 , "Historical" ) ;
		
		private FaultStatusCode( int code , String description ) {
			this.code = code ;
			this.description = description ;
		}

		@JsonValue
		@JsonProperty("code")		
		@Getter
		private int code;
		@Getter
		private String description;
		
		private static final Map<Integer,FaultStatusCode> CACHE;
		
		static {
			CACHE = valuesAsList()
					.stream()
					.collect(Collectors.toMap( 
							x -> x.getCode() , 
							x -> x ) ) ;
		}
		
		public static List<FaultStatusCode> valuesAsList(){
			return Arrays.asList( FaultStatusCode.values() );
		}
		
		public static Map<Integer,FaultStatusCode> valuesAsMap(){
			return CACHE;
		}
		
		@JsonCreator
		public static FaultStatusCode fromCode( Integer code ) {
			return CACHE.get( code );
		}
				
	}
	
}
