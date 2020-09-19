package com.ilab.safety.sac.leetcode;

import java.util.Map;
import java.util.AbstractMap.SimpleEntry;

class UndergroundSystem {
	private Map<Integer, SimpleEntry<String, Integer>> checkIn = new HashMap<>();
	private Map<String, SimpleEntry<Double, Double>> journey = new HashMap<>();

	public UndergroundSystem() {

	}

	public void checkIn(int id, String stationName, int t) {
		// Put it in checkins HashMap
		checkIn.put(id, new SimpleEntry<>(stationName, t));
	}

	public void checkOut(int id, String stationName, int t) {
		// Get all the value from checkin DS
		SimpleEntry<String, Integer> checkinData = checkIn.get(id);
		String startStationName = checkinData.getKey();
		Integer startTime = checkinData.getValue();

		// Create a new Hash for journey DS
		String routeName = startStationName + ":" + stationName;

		// Try to find out if the particular journey hash exists in the DS or not
		SimpleEntry<Double, Double> journeyStats = journey.getOrDefault(routeName,
				new SimpleEntry<Double, Double>(0.0, 0.0));
		Double totalTripTime = journeyStats.getKey();
		Double tripCounts = journeyStats.getValue();

		// Update the values in the list
		journey.put(routeName, new SimpleEntry<Double, Double>(totalTripTime + (t - startTime), tripCounts + 1));
		checkIn.remove(id);
	}

	public double getAverageTime(String startStation, String endStation) {
		SimpleEntry<Double, Double> commute = journey.get(startStation + ":" + endStation);
		return commute.getKey() / commute.getValue();
	}
}