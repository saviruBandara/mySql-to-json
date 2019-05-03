package com.jrt.app.enigmaWebService.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.jrt.app.enigmaWebService.model.LocationModel;

@Mapper
public interface ItineraryMapper {
	
	/* Location List
	 */
	@Select("SELECT * FROM locationsmaster;")
	List<LocationModel> getlocationList();
	
	@Select("SELECT distance FROM locationmatrix WHERE locationid1=#{p1} AND locationid2=#{p2};")
	String getDistance(@Param("p1") String locationid,@Param("p2") String locationid2);
	
	@Select("SELECT totalDistance(#{p1});")
	String getTotalDistance(@Param("p1") String locationList);
}
