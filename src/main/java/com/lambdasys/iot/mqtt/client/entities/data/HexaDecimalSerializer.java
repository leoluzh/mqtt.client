package com.lambdasys.iot.mqtt.client.entities.data;

import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/**
 * 
 * @author Leonardo Luz Fernandes
 * @version 0.1
 * @since 14/06/2018
 * 
 */

@SuppressWarnings("serial")
public class HexaDecimalSerializer extends StdSerializer<Integer> implements Serializable {

	private static final String HEXADECIMAL_PREFIX = "0x" ;
	
	public HexaDecimalSerializer() {
		super(Integer.class);
	}
	
	public HexaDecimalSerializer( Class<Integer> klass ) {
		super( klass );
	}
	
	@Override
	public void serialize(Integer value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		if( Objects.nonNull( value ) ) {
			gen.writeString( HEXADECIMAL_PREFIX + Integer.toHexString( value ) );
		}
		
	}
	
	/**
	public static void main( String... args ) {
		System.out.println( "Integer To Hexadecimal: 0x" +  Integer.toHexString( 12 ) );
		System.out.println( "Hexadecimal To Integer: " + Integer.decode( HEX_PREFIX + Integer.toHexString( 12 ) ) );
	}
	**/

}
