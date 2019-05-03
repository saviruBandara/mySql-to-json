package com.jrt.app.enigmaWebService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jrt.app.enigmaWebService.model.LocationModel;
import com.jrt.app.enigmaWebService.service.ItineraryService;

@RestController
public class ItineraryController {
	
	@Autowired
	private ItineraryService  itineraryService;
	
	@ResponseBody
	@RequestMapping(value="/EnigmaServices/rest/itinerary/getLocationList",method=RequestMethod.GET,produces="application/json")
	public List<LocationModel> getLocationList() {
		List<LocationModel> locationmodel = itineraryService.getLocatinList("", "");
		return locationmodel;
	}
	
	@ResponseBody
	@RequestMapping(value="/EnigmaServices/rest/itinerary/getDistance/location1/{location1}/location2/{location2}",method=RequestMethod.GET,produces="application/json")
	public String getDistance(@PathVariable("location1") String p1,@PathVariable("location2") String p2) {
		System.out.println(p1+"-----"+p2);
		String distance = itineraryService.getDistance(p1, p2);
		return distance;
	}
	
	@ResponseBody
	@RequestMapping(value="/EnigmaServices/rest/itinerary/getTotalDistance/{location1}",method=RequestMethod.GET,produces="application/json")
	public String getTotalDistance(@PathVariable("location1") String p1) {
		System.out.println(p1+"-----");
		String distance = itineraryService.getTotalDistance(p1);
		System.out.println("print output values--"+distance);
		return distance;
	}

}
