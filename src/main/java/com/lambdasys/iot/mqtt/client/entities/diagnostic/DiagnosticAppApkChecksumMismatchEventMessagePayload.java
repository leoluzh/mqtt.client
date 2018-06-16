package com.lambdasys.iot.mqtt.client.entities.diagnostic;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName(value=DiagnosticAppApkChecksumMismatchEventMessagePayload.TYPE_NAME)
@SuppressWarnings("serial")
public class DiagnosticAppApkChecksumMismatchEventMessagePayload extends DiagnosticEventMessagePayload {

	public static final String TYPE_NAME = "app-apk-checksum-mismatch" ;
	
}
