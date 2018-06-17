package com.lambdasys.iot.mqtt.client.entities.diagnostic;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.lambdasys.iot.mqtt.client.entities.MessagePayload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Leonardo Luz Fernandes
 * @version 0.1
 * @since 16/06/2018
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@SuppressWarnings("serial")
public class DiagnosticMessagePayload implements MessagePayload {

	
	public static final NamedType[] SUBTYPES;
	
	static {
		SUBTYPES = new NamedType[]{
				new NamedType( DiagnosticAppApkChecksumMismatchEventMessagePayload.class , DiagnosticAppApkChecksumMismatchEventMessagePayload.TYPE_NAME ) ,
				new NamedType( DiagnosticCannotInstallAppEventMessagePayload.class, DiagnosticCannotInstallAppEventMessagePayload.TYPE_NAME ) ,
				new NamedType( DiagnosticCannotUploadLogsEventMessagePayload.class, DiagnosticCannotUploadLogsEventMessagePayload.TYPE_NAME ) , 
				new NamedType( DiagnosticUnableToGetTimeFromNtpEventMessagePayload.class, DiagnosticUnableToGetTimeFromNtpEventMessagePayload.TYPE_NAME ) ,
				new NamedType( DiagnosticVehicleInspectorErrorEventMessagePayload.class, DiagnosticVehicleInspectorErrorEventMessagePayload.TYPE_NAME ) ,
				new NamedType( DiagnosticWrongMessageReceivedEventMessagePayload.class, DiagnosticWrongMessageReceivedEventMessagePayload.TYPE_NAME ) ,
		};
	}
	
	
	@JsonTypeId
	@JsonProperty("eventId")
	private String eventId;
	
	@JsonFormat(shape=Shape.STRING,pattern=MessagePayload.EVENT_TIME_PATTERN)
	private Date eventTime;

	@JsonTypeInfo(
			use = JsonTypeInfo.Id.NAME ,
			include = JsonTypeInfo.As.EXTERNAL_PROPERTY , 
			property = "type" )
		@JsonSubTypes({
			@Type(value=DiagnosticAppApkChecksumMismatchEventMessagePayload.class,name=DiagnosticAppApkChecksumMismatchEventMessagePayload.TYPE_NAME) ,
			@Type(value=DiagnosticCannotInstallAppEventMessagePayload.class, name=DiagnosticCannotInstallAppEventMessagePayload.TYPE_NAME) ,
			@Type(value=DiagnosticCannotUploadLogsEventMessagePayload.class, name=DiagnosticCannotUploadLogsEventMessagePayload.TYPE_NAME) ,
			@Type(value=DiagnosticUnableToGetTimeFromNtpEventMessagePayload.class, name=DiagnosticUnableToGetTimeFromNtpEventMessagePayload.TYPE_NAME) ,
			@Type(value=DiagnosticVehicleInspectorErrorEventMessagePayload.class, name=DiagnosticVehicleInspectorErrorEventMessagePayload.TYPE_NAME) ,
			@Type(value=DiagnosticWrongMessageReceivedEventMessagePayload.class,name=DiagnosticWrongMessageReceivedEventMessagePayload.TYPE_NAME) ,
		})			
	@JsonProperty("desc")
	private DiagnosticEventMessagePayload desc;
	
}
