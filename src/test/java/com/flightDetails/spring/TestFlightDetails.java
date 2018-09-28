package com.flightDetails.spring;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.flightDetails.spring.controller.FlightRestURIConstants;
import com.flightDetails.spring.model.FlightDetails;

public class TestFlightDetails {

	public static final String SERVER_URI = "http://localhost:8080/FlightRestSample/";
	
	public static void main(String args[]){
		testGetDummyFlight();
		System.out.println("*****");
		testAddFlight();
		System.out.println("*****");
		testGetFlight();
		System.out.println("*****");
		testGetAllFlights();
	}

	private static void testGetAllFlights() {
		RestTemplate restTemplate = new RestTemplate();
		//we can't get List<Employee> because JSON convertor doesn't know the type of
		//object in the list and hence convert it to default JSON object type LinkedHashMap
		List<LinkedHashMap> flights = restTemplate.getForObject(SERVER_URI+FlightRestURIConstants.GET_ALL_FLIGHT, List.class);
		System.out.println(flights.size());
		for(LinkedHashMap map : flights){
			System.out.println("ID="+map.get("id")+",Name="+map.get("name"));;
		}
	}

	private static void testAddFlight() {
		RestTemplate restTemplate = new RestTemplate();
		FlightDetails fligthDetails = new FlightDetails();
		fligthDetails.setFlightID(072);
		fligthDetails.setFlightName("JetBlue");
		FlightDetails response = restTemplate.postForObject(SERVER_URI+FlightRestURIConstants.CREATE_FLIGHT, fligthDetails, FlightDetails.class);
		printFlightData(response);
	}

	private static void testGetFlight() {
		RestTemplate restTemplate = new RestTemplate();
		FlightDetails flightDetails = restTemplate.getForObject(SERVER_URI+"/rest/flight/072", FlightDetails.class);
		printFlightData(flightDetails);
	}
	private static void testGetDummyFlight() {
		RestTemplate restTemplate = new RestTemplate();
		FlightDetails flightDetails = restTemplate.getForObject(SERVER_URI+FlightRestURIConstants.DUMMY_FLIGHT, FlightDetails.class);
		printFlightData(flightDetails);
	}

		
	public static void printFlightData(FlightDetails flightDetails){
		System.out.println("ID="+flightDetails.getFlightID()+",Name="+flightDetails.getFlightName());
	}
}
