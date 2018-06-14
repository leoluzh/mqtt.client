package com.lambdasys.iot.mqtt.client.entities.alarm;

import org.testng.annotations.DataProvider;

/**
 * 
 * @author Leonardo Luz Fernandes
 * @version 0.1
 * @since 12/06/2018
 *
 */

@SuppressWarnings("serial")
public class ShakeAlarmInformationMessageTest extends AlarmInfomationMessageTest {

	@DataProvider(name="dataProviderJson")
	@Override
	public Object[][] dataProviderJson(){
		return new Object[][] {
			{ "{ \"type\": \"shake\", \"eventTime\": \"2017-05-03T08:57:11Z\" , \"data\": { \"gensorValue\": 101.22 , \"lat\" : 114.05540500000001 , \"lon\" : 22.66381333333333 , \"trip_sn\" : 12345} }" 	},
		};
	}
	
	@DataProvider(name="dataProviderObject")
	@Override
	public Object[][] dataProviderObject(){
		return new Object[][] {
			{  AlarmMessagePayload.builder()
					.type("shake")
					.eventTime(message.strToDate("2017-05-03T08:57:11Z"))
					.data( ShakeAlarmDataMessagePayload.builder()
								.gensorValue(101.22)
								.latitude(114.05540500000001)
								.longitude(22.66381333333333)
								.tripSn(12345)
								.build() )
					.build()  } , 
		};
	}
	
	
}
