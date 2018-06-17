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

@JsonTypeName(value=DiagnosticCannotInstallAppEventMessagePayload.TYPE_NAME)
@SuppressWarnings("serial")
public class DiagnosticCannotInstallAppEventMessagePayload extends DiagnosticEventMessagePayload {

	public static final String TYPE_NAME = "cannot-install-app" ;
	
	@JsonProperty("desc")
	private JSONObject description;
	
}
