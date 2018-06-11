package com.lambdasys.iot.mqtt.client.publisher;

import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

@SuppressWarnings("serial")
public class PublisherExample implements Serializable {

	public static void main( String... args ) throws KeyManagementException, NoSuchAlgorithmException, URISyntaxException, IOException, TimeoutException, InterruptedException {
		
		ConnectionFactory cf = new ConnectionFactory();
		cf.setUri( "mqtt://guest:guest@localhost:1883" );
		cf.setConnectionTimeout( 50000 );
		Connection connection = cf.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare("test-queue", true, false, false, null);
	
		int count = 0;
		
		while( count < 100 ) {
			String message = "{ id : " + count + " , message : \"sending message...\"  }" ;
			channel.basicPublish( "", "test-queue" , null , message.getBytes() );
			System.out.println("Publishing message: " + message );
			Thread.sleep(5000);
			count++;
		}
		
	}
	
}
