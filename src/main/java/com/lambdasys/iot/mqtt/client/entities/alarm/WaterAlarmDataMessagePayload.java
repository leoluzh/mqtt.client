package com.lambdasys.iot.mqtt.client.entities.alarm;

import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Leonardo Luz Fernandes
 * @version 0.1
 * @since 12/06/2018
 *
 * If the water temperature is greater than 100°C. 
 * And is above the water temperature alarm threshold of 10°C for three times in succession, 
 * then it will send alarm info to OM server.
 * The threshold could be different for different car models because this value is calculated by learning.
 * 
 */

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@JsonTypeName("water")
@SuppressWarnings("serial")
public class WaterAlarmDataMessagePayload extends AlarmDataMessagePayload {

	public static final String TYPE_NAME = "water" ; 
	
	protected Integer waterValue;

	@Builder
	public WaterAlarmDataMessagePayload( Double latitude , Double longitude , Integer tripSn , Integer waterValue ) {
		super(latitude,longitude, tripSn);
		this.waterValue = waterValue;
	}
	
}
