package com.lambdasys.iot.mqtt.client.entities.diagnostic;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName(value=DiagnosticCannotInstallAppEventMessagePayload.TYPE_NAME)
@SuppressWarnings("serial")
public class DiagnosticCannotInstallAppEventMessagePayload extends DiagnosticEventMessagePayload {

	public static final String TYPE_NAME = "cannot-install-app" ;
	
}
