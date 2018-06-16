package com.lambdasys.iot.mqtt.client.entities.diagnostic;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName(value=DiagnosticCannotUploadLogsEventMessagePayload.TYPE_NAME)
@SuppressWarnings("serial")
public class DiagnosticCannotUploadLogsEventMessagePayload extends DiagnosticEventMessagePayload {

	public static final String TYPE_NAME = "cannot-upload-logs" ;
	
}
