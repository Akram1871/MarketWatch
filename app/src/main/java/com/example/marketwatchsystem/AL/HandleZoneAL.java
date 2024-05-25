package com.example.marketwatchsystem.AL;

import java.util.ArrayList;

public class HandleZoneAL {
  public static ArrayList<String> deliverInfo(ZoneType zt){
	  RetrieveZoneInfoAL rzi = new RetrieveZoneInfoAL();
	  ArrayList<String> zoneInfo;
	  Zone zone;
	  switch(zt) {
	   case REDZONE:
		   zone = new RedZoneAL();
		   zoneInfo = rzi.RedZoneInfo();
		   zone.produceInfo(zoneInfo);
		   return zone.deliverInfo();		  
	   case GREENZONE:
		   zone = new GreenZoneAL();
		   zoneInfo = rzi.GreenZoneInfo();
		   zone.produceInfo(zoneInfo);
		   return zone.deliverInfo();		  
	   case YELLOWZONE:
		   zone = new YellowZoneAL();
		   zoneInfo = rzi.YellowZoneInfo();
		   zone.produceInfo(zoneInfo);
		   return zone.deliverInfo();		  		   
		default:
			return null;
	  }
  }
}
