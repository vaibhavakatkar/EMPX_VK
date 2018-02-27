package com.abc.common;

import java.time.Instant;
import java.util.Date;

import java.util.UUID;

public class Helper {
	
	public static String getNextUUID(){
		return UUID.randomUUID().toString();
	}
	
	public static String getVersion(){
		System.out.println("Instant.now().getEpochSecond()"+Instant.now().getEpochSecond());
		return (Long.toString(Instant.now().getEpochSecond()));
	}
	
	public static String getCurrentTimeStamp(){
		String timestamp = new java.text.SimpleDateFormat("EEE, dd MMM yyyy hh:mm:ss z").format(new Date());
		return timestamp;
	}
	
	
	
}
