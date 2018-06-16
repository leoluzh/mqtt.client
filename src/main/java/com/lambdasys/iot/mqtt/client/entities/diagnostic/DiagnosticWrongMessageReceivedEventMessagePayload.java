package com.lambdasys.iot.mqtt.client.entities.diagnostic;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName(value=DiagnosticWrongMessageReceivedEventMessagePayload.TYPE_NAME)
@SuppressWarnings("serial")
public class DiagnosticWrongMessageReceivedEventMessagePayload extends DiagnosticEventMessagePayload {

	public static final String TYPE_NAME = "wrong-message-received" ;
	
}
