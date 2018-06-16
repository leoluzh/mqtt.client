package com.lambdasys.iot.mqtt.client.entities.diagnostic;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName(value=DiagnosticUnableToGetTimeFromNtpEventMessagePayload.TYPE_NAME)
@SuppressWarnings("serial")
public class DiagnosticUnableToGetTimeFromNtpEventMessagePayload extends DiagnosticEventMessagePayload {

	public static final String TYPE_NAME = "unable-to-get-time-from-NTP" ; 
	
}
