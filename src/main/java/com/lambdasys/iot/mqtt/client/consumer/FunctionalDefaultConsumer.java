package com.lambdasys.iot.mqtt.client.consumer;

import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;

@SuppressWarnings("serial")
public class FunctionalDefaultConsumer extends DefaultConsumer implements Serializable {

	/** Functional Programming  **/
	private Consumer4<String,Envelope,AMQP.BasicProperties,byte[]> handleDelivery;
	private java.util.function.Consumer<String> handleOk;
	private java.util.function.Consumer<String> handleCancel;
	private java.util.function.Consumer<String> handleCancelOk;
	private Consumer2<String,ShutdownSignalException> handleShutdownSignal;
	private java.util.function.Consumer<String> handleRecorverOk;
	
	public FunctionalDefaultConsumer(Channel channel) {
		super(channel);
	}

    public void addHandleCancelOk( java.util.function.Consumer<String> handleCancelOk ) {
    	this.handleCancelOk = handleCancelOk;
    }
	
    @Override
    public void handleCancelOk(String consumerTag) {
    	if( Objects.nonNull( this.handleCancelOk )  ) {
    		handleOk.accept(consumerTag);
    	}
    }
    
    
    public void addHandleCancel( java.util.function.Consumer<String> handleCancel  ) throws IOException {
    	this.handleCancel = handleCancel;
    }
    
    @Override
    public void handleCancel(String consumerTag) throws IOException {
    	if( Objects.nonNull( this.handleCancel ) ) {
    		handleCancel.accept( consumerTag );
    	}
    }

    /**
     * No-op implementation of {@link Consumer#handleShutdownSignal}.
     */
    @Override
    public void handleShutdownSignal(String consumerTag, ShutdownSignalException sig) {
    	if( Objects.nonNull( handleShutdownSignal ) ) {
    		handleShutdownSignal.accept(consumerTag,sig);
    	}
    }

     /**
     * No-op implementation of {@link Consumer#handleRecoverOk}.
     */
    @Override
    public void handleRecoverOk(String consumerTag) {
        if( Objects.nonNull( handleRecorverOk ) ) {
        	handleRecorverOk.accept(consumerTag);
        }
    }
	
	public void addHandleDelivery( Consumer4<String,Envelope,AMQP.BasicProperties,byte[]> handleDelivery ) {
		this.handleDelivery = handleDelivery;
	}
	
    @Override
    public void handleDelivery(String consumerTag,
                               Envelope envelope,
                               AMQP.BasicProperties properties,
                               byte[] body) throws IOException {
    	if( Objects.nonNull( handleDelivery ) ) {
    		handleDelivery.accept(consumerTag,envelope,properties,body);
    	}
    }
	

}
