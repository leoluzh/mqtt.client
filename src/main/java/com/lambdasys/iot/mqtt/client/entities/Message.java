package com.lambdasys.iot.mqtt.client.entities;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data

@SuppressWarnings("serial")
public class Message<T> implements Serializable {

	protected ObjectMapper objectMapper;
	
	protected Class<T> payload;
	
	{
		this.objectMapper = new ObjectMapper();
		this.payload = getTypeParameterEntityClazz();
	}
	
	public static enum DIRECTION {
		SENT_BY_IOT_TO_CLOUD("Sent by IoT to Cloud") ,
		SENT_BY_CLOUD_TO_IOT("Sent by Cloud to IoT");
		DIRECTION(String description){
			this.description = description ;
		}
		@Getter
		private String description;
	}
	
    @SuppressWarnings("unchecked")
    private Class<T> getTypeParameterEntityClazz(){
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
	
    public T deserialize( String json ) throws IOException {
    	return this.objectMapper.readValue( json , this.payload );
    }
    
    public String serialize( T object ) throws JsonProcessingException {
    	return this.objectMapper.writeValueAsString( object );
    }
    
}
