package com.lambdasys.iot.mqtt.client.entities.data;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Getter;

/**
 * 
 * @author Leonardo Luz Fernandes
 * @version 0.1
 * @since 16/06/2018
 *
 */

@JsonFormat(shape=Shape.STRING)
public enum DataStreamItem {
	
	LIGHT_STATUS_HIGH_BEAM( 0x0001 , "0x0001" , "Light Status (High Beam)" , DataStreamItemConstants.ON_OFF_VALUES ) ,
	LIGHT_STATUS_LOW_BEAM( 0x0002 , "0x0002" , "Light Status (Low Beam)" , DataStreamItemConstants.ON_OFF_VALUES ) ,
	LIGHT_STATUS_CLEARANCE_LAMP( 0x0008 , "0x0008" , "Light Status (Clerance Lamp)" , DataStreamItemConstants.ON_OFF_VALUES ) ,
	LIGHT_STATUS_FOG_LAMP( 0x02A5 , "0x02A5" , "Light Status (Fog Lamp)" , DataStreamItemConstants.ON_OFF_VALUES ) , 
	LIGHT_STATUS_LEFT_TURN_LIGHT ( 0x0509 , "0x0509" , "Light Status (Left-Turn Light)" , DataStreamItemConstants.ON_OFF_VALUES ) ,
	LIGHT_STATUS_RIGHT_TURN_LIGHT ( 0x050A , "0x050A" , "Light Status (Right-Turn Light)" , DataStreamItemConstants.ON_OFF_VALUES ) ,
	LIGHT_STATUS_HAZARD_LIGHT( 0x050B , "0x050B" , "Light Status (Hazard Light)" , DataStreamItemConstants.ON_OFF_VALUES ) ,
	
	DOOR_STATUS_FRONT_LEFT_DOOR( 0x0180 , "0x0180" , "Door Status (Front Left Door)" , DataStreamItemConstants.OPEN_CLOSE_VALUES ) ,
	DOOR_STATUS_FRONT_RIGTH_DOOR( 0x0188 , "0x0188" , "" , DataStreamItemConstants.OPEN_CLOSE_VALUES ) ,
	DOOR_STATUS_REAR_LEFT_DOOR( 0x0190 , "0x0190" , "" , DataStreamItemConstants.OPEN_CLOSE_VALUES ) ,
	DOOR_STATUS_REAR_RIGTH_DOOR( 0x0198 , "0x0198" , ""  , DataStreamItemConstants.OPEN_CLOSE_VALUES ) ,
	DOOR_STATUS_TRUNK_DOOR( 0x01E0 , "0x01E0" , "" , DataStreamItemConstants.OPEN_CLOSE_VALUES ) ,
	
	DOOR_LOCK_ASSY_CENTRAL_CONTROL_DOOR( 0x050C , "0x050C" , "" , DataStreamItemConstants.OPEN_CLOSE_VALUES ) ,
	DOOR_LOCK_FRONT_LEFT_DOOR( 0x0181 , "0x0181" , "" , DataStreamItemConstants.OPEN_CLOSE_VALUES ) ,
	DOOR_LOCK_FRONT_RIGHT_DOOR( 0x0181 , "0x0189" , "" , DataStreamItemConstants.OPEN_CLOSE_VALUES ) ,
	DOOR_LOCK_REAR_LEFT_DOOR( 0x0181 , "0x0191" , "" , DataStreamItemConstants.OPEN_CLOSE_VALUES ) ,
	DOOR_LOCK_REAR_RIGHT_DOOR( 0x0181 , "0x0199" , "" , DataStreamItemConstants.OPEN_CLOSE_VALUES ) ,
	DOOR_LOCK_TRUNK( 0x050D , "0x050D" , "" , DataStreamItemConstants.OPEN_CLOSE_VALUES ) ,
	
	WINDOWS_STATUS_FRONT_LEFT_WINDOW( 0x0180 , "0x0180" , "" , DataStreamItemConstants.OPEN_CLOSE_VALUES ) ,
	WINDOWS_STATUS_FRONT_RIGTH_WINDOW( 0x0180 , "0x0188" , "" , DataStreamItemConstants.OPEN_CLOSE_VALUES ) ,
	WINDOWS_STATUS_FRONT_REAR_LEFT_WINDOW( 0x01C0 , "0x01C0" , "" , DataStreamItemConstants.OPEN_CLOSE_VALUES ) ,
	WINDOWS_STATUS_FRONT_REAR_RIGTH_WINDOW( 0x01C8 , "0x01C8" , "" , DataStreamItemConstants.OPEN_CLOSE_VALUES ) ,
	WINDOWS_STATUS_SUNROOF ( 0x01D8 , "0x01D8" , "" , DataStreamItemConstants.OPEN_CLOSE_VALUES ) ,
	
	FAULT_SIGNAL_ECM ( 0x02A1 , "0x02A1" , "" , DataStreamItemConstants.ON_OFF_VALUES ) ,
	FAULT_SIGNAL_ABS ( 0x0295 , "0x0295" , "" , DataStreamItemConstants.ON_OFF_VALUES ) ,
	FAULT_SIGNAL_SRS ( 0x029D , "0x029D" , "" , DataStreamItemConstants.ON_OFF_VALUES ) ,
	
	ALERTING_SIGNAL_OIL ( 0x029A , "0x029A" , "" , DataStreamItemConstants.ON_OFF_VALUES ) ,
	ALERTING_SIGNAL_TIRE_PRESSURE( 0x0508 , "0x0508" , "" , DataStreamItemConstants.ON_OFF_VALUES ) ,
	ALERTING_SIGNAL_MAINTENANCE( 0x02AA , "0x02AA" , "" , DataStreamItemConstants.ON_OFF_VALUES ) ,
	
	SRS_STATUS( 0x0240 , "0x0240" , "" , DataStreamItemConstants.ON_OFF_VALUES , true ) ,
	HANDBREAK_STATUS( 0x0360 , "0x0360" , "" , DataStreamItemConstants.ON_OFF_VALUES ) ,
	BREAK_OR_FOOTBREAK_STATUS ( 0x0015 , "0x0015" , "" , DataStreamItemConstants.ON_OFF_VALUES ) ,
	
	SAFETY_BELT_DRIVER( 0x02C0 , "0x02C0" , "" , DataStreamItemConstants.OPEN_CLOSE_VALUES  ) ,
	SAFETY_BELT_PASSENGER_SIDE( 0x02C4 , "0x02C4" , "" , DataStreamItemConstants.OPEN_CLOSE_VALUES ) ,
	
	ACC_SIGNAL ( 0x050E , "0x050E" , "" , DataStreamItemConstants.ON_OFF_VALUES ) ,
	
	KEY_STATUS ( 0x0342 , "0x0342" , "" , DataStreamItemConstants.IN_OUT_VALUES  ) ,
	REMOTE_SIGNAL ( 0x050F , "0x050F" , "" , DataStreamItemConstants.ON_OFF_VALUES ) ,
	WIPERS_STATUS ( 0x0510 , "0x0510" , "" , DataStreamItemConstants.ON_OFF_VALUES ) ,
	
	AIR_CONDITIONING_SWITCH ( 0x0370 , "0x0370" , "" , DataStreamItemConstants.ON_OFF_VALUES ) ,
	GEARS_POSITION_TRANSMISSION_CURRENT_GEAR( 0x0281 , "0x0281" , "" ,  DataStreamItemConstants.GEAR_POSITION_VALUES ) ,
	
	MILEAGE_TOTAL_KM( 0x0290 , "0x0290" , "" ) ,
	MILEAGE_ENDURANCE_KM( 0x0511 , "0x0511" , "" ) ,
	
	INSTANTE_FUEL_CONSUMPTION_LITER ( 0x0517 , "0x0517" , "" , null , true ) ,
	INSTANTE_TANK_LEVEL_PERCENTE( 0x0518 , "0x0518" , "" ) ,
	FUEL_CONSUMPTION_ML_PER_HOUR( 0x0512 , "0x0512" , "" ) ,
	ENGINE_COOLANT_TEMPERATURE_CELSIUS( 0x0305 , "0x0305" , "" ) ,
	ENGINE_INTAKE_AIR_TEMPERATURE_CELSIUS( 0x0303 , "0x0303" , ""  ) ,
	AIR_CONDITION_TEMPERATURE_CELSIUS ( 0x0373 , "0x0373" , "" ) ,
	BATTERY_VOLTAGE_VOLT( 0x01F0 , "0x01F0" , "" ) ,
	
	LEFT_FRONT_WHEEL_SPEED_KM_PER_HOUR( 0x0100 , "0x0100" , "" ) ,
	RIGTH_FRONT_WHELL_SPEED_KM_PER_HOUR( 0x0110 , "0x0110" , "" ) ,
	LEFT_REAR_WHEEL_SPEED_KM_PER_HOUR( 0x0120 , "0x0120" , "" ) ,
	RIGTH_REAR_WHELL_SPEED_KM_PER_HOUR( 0x0130 , "0x0130" , "" ) ,
	
	VEHICLE_SPEED_KM_PER_HOUR( 0x030B , "0x030B" , "" ) ,
	ENGINE_SPEED_RPM ( 0x0300 , "0x0300" , "" ) ,
	
	FUEL_CONSUMPTION_AVERAGE_LITER_PER_100_KM( 0x040F , "0x040F" , "" ) ,
	FUEL_CONSUMPTION_INSTANTANEOUS_LITER_PER_100KM( 0x0514 , "0x0514" , "" ) ,
	FUEL_CONSUMPTION_INSTANTANEOUS_LITER_PER_HOUR( 0x0513 , "0x0513" , "") ,
	OIL_LIFE_PERCENTE( 0x0404 , "0x0404" , "" ) ,
	OIL_PRESSURE_KPA( 0x0293 , "0x0293" , "" ) ,
	AIR_FLOW_G_PER_S ( 0x041E , "0x041E" , "" ) ,
	MAP_MAINFOLD_ABSOLUTE_PRESSURE_KPA( 0x041F , "0x041F" , "" ) ,
	INJECTION_PULSE_WIDTH_MS ( 0x0411 , "0x0411" , "" ) ,
	ACCELERATOR_PEDAL_RELATIVE_LOCATION_PERCENTE( 0x0515 , "0x0515" , "" ) ,
	ACCELERATOR_PEDAL( 0x0516 , "0x0516" , "" ) ,
	STEERING_WHEEL_ANGLE( 0x0350 , "0x0350" , "" ) ,
	STEERING_WHEEL_ANGLE_STATUS( 0x0351 , "0x0351" , "" ) ,
	FUEL_CONSUMPTION_LITER( 0x040C , "0x040C" , "" ) ,
	FUEL_TANK_LEVEL_PERCENTE( 0x040D , "0x040D" , "" ) ,
	TRIP_SERIAL_NUMBER( 0x051B , "0x051B" , "" ) ,
	TOTAL_TRIP_MILEAGE_KM( 0x051A , "0x051A" , "" ) ,
	MONITOR_STATUS_SINCE_DTC_CLEARED( 0x0600 , "0x0600" , "" ) ,
	FUEL_SYSTEM_STATUS( 0x0601 , "0x0601" , "" ) ,
	CALCULATED_ENGINE_LOAD_PERCENT( 0x0603 , "0x0603" , "" ) ,
	FUEL_PRESSURE_GAUGE_PRESSURE_KPA( 0x0608 , "0x0608" , "" ) ,
	TIMING_ADVANCE_BTDC( 0x0609 , "0x0609" , "" ) ,
	OXYGEN_SENSORS_PRESENT_IN_2_BANKS( 0x060C , "0x060C" , "" ) ,
	ODB_STANDARDS_THIS_VEHICLE_CONFORMS_TO( 0x061D , "0x061D" , "" ) ,
	OXYGEN_SENSORS_PRESENT_IN_4_BANKS( 0x061E , "0x061E" , "" ) ,
	DISTANCE_TRAVELED_WITH_MALFUNCTION_INDICATOR_LAMP_MIL_ON_KM( 0x0621 , "0x0621" , "" ) ,
	DISTANCE_TRAVELED_SINCE_CODES_CLEARED_KM( 0x0638 , "0x0638" , "" ) ,
	FREEZE_DTC( 0x066B , "0x066B" , "" ) ;
	
	DataStreamItem( Integer id , String xId , String name ){
		this.id= id ;
		this.xId = xId;
		this.name = name ;
		this.options = null;
	}
	
	DataStreamItem( Integer id , String xId , String name , Object[] options ){
		this.id= id ;
		this.xId = xId; 
		this.options = options;
	}

	DataStreamItem( Integer id , String xId , String name , Object[] options , boolean deprecated ){
		this.id= id ;
		this.xId = xId; 
		this.name = name;
		this.options = options ;
		this.deprecated = deprecated;
	}

	@JsonValue
	@JsonProperty("id")
	@Getter
	private String xId;
		
	@Getter
	private Integer id;
	
	@Getter
	private String name;
	
	@Getter
	private boolean deprecated;
	
	@Getter
	private Object[] options;
	
	private static final Map<Integer,DataStreamItem> CACHE;
	
	static {
		CACHE = valuesAsList()
				.stream()
				.collect(Collectors.toMap( 
						x -> x.getId() , 
						x -> x ) ) ;
	}
	
	public static List<DataStreamItem> valuesAsList(){
		return Arrays.asList( DataStreamItem.values() );
	}
	
	public static Map<Integer,DataStreamItem> valuesAsMap(){
		return CACHE;
	}
	
	public static DataStreamItem fromId( Integer id ) {
		return CACHE.get( id );
	}
	
	@JsonCreator
	public static DataStreamItem fromId( String xId ) {
		return CACHE.get( Integer.decode( xId ) );
	}
	
	public static String toHexa( Integer value ) {
		return "0x" + Integer.toHexString( value );
	}
	
	public static Integer toInt( String hexadecimal ) {
		return Integer.decode( hexadecimal );
	}
	
}
