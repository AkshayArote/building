package com.spring.services;

import java.util.List;
import java.util.Optional;

import com.spring.dto.BuildingDto;

public interface BuildingService {

	Optional<BuildingDto> addBuilding(BuildingDto buildingDto);

	List<BuildingDto> getAll();
	
	Optional<BuildingDto> updateBuilding(BuildingDto buildingDto);	
	
	boolean deletebuilding(Long buildingId);

}
