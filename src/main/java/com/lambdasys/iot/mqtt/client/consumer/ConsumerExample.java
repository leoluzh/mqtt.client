package com.lambdasys.iot.mqtt.client.consumer;

import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

@SuppressWarnings("serial")
public class ConsumerExample implements Serializable {

	public static void main( String... args ) throws KeyManagementException, NoSuchAlgorithmException, URISyntaxException, IOException, TimeoutException, InterruptedException {
		
		ConnectionFactory cf = new ConnectionFactory();
		cf.setUri( "mqtt://guest:guest@localhost:1883" );
		cf.setConnectionTimeout( 50000 );
		Connection connection = cf.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare("test-queue", true, false, false, null);

		
		
		FunctionalDefaultConsumer consumer = new FunctionalDefaultConsumer(channel); 
		/**
		DefaultConsumer consumer = new DefaultConsumer( channel ){
		{
			@Override
			public void handleDelivery(
					String consumerTag , 
					Envelope envelope , 
					AMQP.BasicProperties properties , 
					byte[] body ) throws IOException {
				String message = new String( body , "UTF-8" );
				System.out.println("Message received: " + message );
				
			}
		};
		**/
		
		consumer.addHandleDelivery( ( consumerTag, envelope, properties, body ) ->  {
			try {
				String message = new String( body , "UTF-8" );
				System.out.println("Message received: " + message );
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		});
		
		channel.basicConsume( "test-queue", false , consumer );
			
	}
	
	
}
