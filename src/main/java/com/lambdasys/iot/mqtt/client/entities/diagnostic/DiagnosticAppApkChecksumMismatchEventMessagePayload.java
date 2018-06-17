package com.lambdasys.iot.mqtt.client.entities.diagnostic;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * 
 * @author Leonardo Luz Fernandes
 * @version 0.1
 * @since 16/06/2018
 *
 */


@JsonTypeName(value=DiagnosticAppApkChecksumMismatchEventMessagePayload.TYPE_NAME)
@SuppressWarnings("serial")
public class DiagnosticAppApkChecksumMismatchEventMessagePayload extends DiagnosticEventMessagePayload {

	public static final String TYPE_NAME = "app-apk-checksum-mismatch" ;
	
	@JsonProperty("desc")
	private JSONObject description;
	
}
