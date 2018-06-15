package com.lambdasys.iot.mqtt.client.entities.data;

import java.io.IOException;
import java.io.Serializable;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;


/**
 * 
 * @author Leonardo Luz Fernandes
 * @version 0.1
 * @since 14/06/2018
 * 
 */

@SuppressWarnings("serial")
public class HexaDecimalDeserializer extends StdDeserializer<Integer> implements Serializable {

	public HexaDecimalDeserializer() {
		super(Integer.class);
	}
	
	protected HexaDecimalDeserializer(Class<Integer> vc) {
		super(vc);
	}

	@Override
	public Integer deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		return Integer.parseInt( p.getText() ) ;
	}

}
