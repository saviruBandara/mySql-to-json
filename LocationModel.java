package com.jrt.app.enigmaWebService.model;

public class LocationModel {
	private String locationname;
	private String idlocations;
	private double distancefromColombo;

	public String getLocationname() {
		return locationname;
	}
	public void setLocationname(String locationname) {
		this.locationname = locationname;
	}
	public double getDistancefromColombo() {
		return distancefromColombo;
	}
	public void setDistancefromColombo(double distancefromColombo) {
		this.distancefromColombo = distancefromColombo;
	}
	public String getIdlocations() {
		return idlocations;
	}
	public void setIdlocations(String idlocations) {
		this.idlocations = idlocations;
	}
}
