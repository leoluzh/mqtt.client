package com.lambdasys.iot.mqtt.client.entities.report;

import com.fasterxml.jackson.annotation.JsonProperty;
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
@NoArgsConstructor
@AllArgsConstructor
@Builder

@SuppressWarnings("serial")
public class DiagnosticResultDataMessagePayload implements MessagePayload {

	@JsonProperty("system_uid")
	private String systemUid;
	
	@JsonProperty("name_id")
	private String nameId;
	
	@JsonProperty("system")
	private String system;
	
	@JsonProperty("system_type")
	private String systemType;
	
	@JsonProperty("is_new_sys")
	private String isNewSys;
	
	@JsonProperty("dtcs")
	private DiagnosticResultDataDtcsMessagePayload[] dtcs;
	
	@JsonProperty("datastreams")
	private DiagnosticResultDataStreamMessagePayload[] dataStreams;
	
}
