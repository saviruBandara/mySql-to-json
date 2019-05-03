package com.jrt.app.enigmaWebService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrt.app.enigmaWebService.mapper.ItineraryMapper;
import com.jrt.app.enigmaWebService.model.LocationModel;

@Service
public class ItineraryService {
	
	@Autowired ItineraryMapper itineraryMapper;
	
	public List<LocationModel> getLocatinList(String p1, String p2){
		System.out.println("Service> getTourData > tour no > p1=" + p1 + ", p2="+p2);
		
		return itineraryMapper.getlocationList();
	}
	
	public String getDistance(String p1, String p2){
		System.out.println("Service> getDistance > p1=" + p1 + ", p2="+p2);
		
		return itineraryMapper.getDistance(p1, p2);
	}
	
	public String getTotalDistance(String p1){
		System.out.println("Service> getDistance > p1=");
		
		return itineraryMapper.getTotalDistance(p1);
	}
}
