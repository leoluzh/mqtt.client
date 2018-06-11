package com.lambdasys.iot.mqtt.client.entitties;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Builder

@SuppressWarnings("serial")
public class CarMoveAlarmDataMessagePayload extends AlarmDataMessagePayload {

}
