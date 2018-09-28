package com.flightDetails.spring.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flightDetails.spring.model.FlightDetails;

/**
 * Handles requests for the Employee service.
 */
@Controller
public class FlightController {
	
	private static final Logger logger = LoggerFactory.getLogger(FlightController.class);
	
	//Map to store flightDetails, ideally we should use database
	Map<Integer,FlightDetails> flightData = new HashMap<Integer, FlightDetails>();
	
	@RequestMapping(value = FlightRestURIConstants.DUMMY_FLIGHT, method = RequestMethod.GET)
	public @ResponseBody FlightDetails getFlightDetails() {
		logger.info("Start getDummyEmployee");
		FlightDetails flightDetails = new FlightDetails();
		flightDetails.setFlightID(072);
		flightDetails.setFlightName("JetBlue");
		flightDetails.setRoute("LGA-FLL");
		
		flightDetails.setFlightID(073);
		flightDetails.setFlightName("UNITED	");
		flightDetails.setRoute("JFK-MIA");
		
		flightDetails.setFlightID(074);
		flightDetails.setFlightName("Delta");
		flightDetails.setRoute("LGA-MIA");
		
		flightDetails.setFlightID(075);
		flightDetails.setFlightName("CVG");
		flightDetails.setRoute("LGA-MIA");
		
		flightDetails.setFlightID(076);
		flightDetails.setFlightName("IAD");
		flightDetails.setRoute("LGA-MIA");
		
		flightDetails.setFlightID(077);
		flightDetails.setFlightName("CLE");
		flightDetails.setRoute("LGA-FLL");
		
		flightData.put(072, flightDetails);
		flightData.put(073, flightDetails);
		flightData.put(074, flightDetails);
		flightData.put(075, flightDetails);
		flightData.put(076, flightDetails);
		return (FlightDetails) flightData;
		
		
	}
	
	@RequestMapping(value = FlightRestURIConstants.GET_FLIGHT, method = RequestMethod.GET)
	public @ResponseBody FlightDetails getFlightId(@PathVariable("id") int flightID) {
		logger.info("Flight .Number="+flightID);
		
		return flightData.get(flightID);
	}
	
	@RequestMapping(value = FlightRestURIConstants.GET_ALL_FLIGHT, method = RequestMethod.GET)
	public @ResponseBody List<FlightDetails> getAllFlight() {
		logger.info("Start getAllFlightDetails.");
		List<FlightDetails> flightList = new ArrayList<FlightDetails>();
		Set<Integer> flightIdKeys = flightData.keySet();
		for(Integer i : flightIdKeys){
			flightList.add(flightData.get(i));
		}
		return flightList;
	}
	
	@RequestMapping(value = FlightRestURIConstants.CREATE_FLIGHT, method = RequestMethod.POST)
	public @ResponseBody FlightDetails addFlight(@RequestBody FlightDetails flight) {
		logger.info("Start addFlightDetails.");
		flightData.put(flight.getFlightID(), flight);
		return flight;
	}
	
	@RequestMapping(value = FlightRestURIConstants.DELETE_FLIGHT, method = RequestMethod.PUT)
	public @ResponseBody FlightDetails deleteFlight(@PathVariable("id") int flightId) {
		logger.info("Start deleteflightDetails.");
		FlightDetails flight = flightData.get(flightId);
		flightData.remove(flightId);
		return flight;
	}
	
}
