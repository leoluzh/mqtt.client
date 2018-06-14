package com.lambdasys.iot.mqtt.client.entities.data;

import java.io.Serializable;

@SuppressWarnings("serial")
public final class DataStreamItemConstants implements Serializable {

	public static final Integer OFF = 0 ;
	public static final Integer ON = 1 ;
	public static final Integer CLOSE = 0 ;
	public static final Integer OPEN = 1 ;
	public static final Integer OUT = 0 ;
	public static final Integer IN = 1 ;
	
	public static final Integer[] ON_OFF_VALUES = new Integer[] { OFF , ON } ;
	public static final String[] ON_OFF_STR = new String[] { "off" , "on" } ; 
	public static final Integer[] OPEN_CLOSE_VALUES = new Integer[] { CLOSE , OPEN } ;
	public static final String[] OPEN_CLOSE_STR = new String[] { "close" , "open" } ;
	public static final Integer[] IN_OUT_VALUES = new Integer[] { OUT , IN } ;
	public static final String[] IN_OUT_STR = new String[] { "in" , "out" } ;
	
	public static final Integer[] GEAR_POSITION_VALUES = new Integer[] {};
	public static final String[] GEAR_POSITION_STR = new String[] {};
	
}
