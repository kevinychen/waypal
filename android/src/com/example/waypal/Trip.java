package com.example.waypal;import java.util.ArrayList;import java.util.List;import android.location.Location;public class Trip {	final String id;	List<POI> pois;		public Trip() {		this.id = "trip" + (int)(Math.random() * 9999);		this.pois = new ArrayList<POI>();	}		public void setNewPOIs(List<POI> newPois) {		if (pois.size() > 3)			pois = pois.subList(0, 3);		pois.addAll(newPois);	}		public static class POI {		final String name;		final Location loc;		final String summary;				public POI(String name, Location loc, String summary) {			this.name = name;			this.loc = loc;			this.summary = summary;		}	}}
