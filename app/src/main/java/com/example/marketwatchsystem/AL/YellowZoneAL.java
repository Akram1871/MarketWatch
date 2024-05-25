package com.example.marketwatchsystem.AL;

import com.example.marketwatchsystem.AL.Zone;

import java.util.ArrayList;

public class YellowZoneAL implements Zone {
	ArrayList<String> li;
	@Override
	public void produceInfo(ArrayList<String> li) {
		this.li = li;
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<String> deliverInfo() {
		// TODO Auto-generated method stub
		return this.li;
	}

}
