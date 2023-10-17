package com.spring.serviceImpl;

import org.springframework.stereotype.Service;
import static com.spring.model_mapper.BuldingMapper.TO_BUILDING;
import static com.spring.model_mapper.BuldingMapper.TO_BUILDINGDTO;
import static com.spring.model_mapper.BuldingMapper.TO_BUILDINGDTOS;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.spring.dto.BuildingDto;
import com.spring.entity.Building;
import com.spring.entity.PQ;
import com.spring.repository.BuildingRepository;
import com.spring.repository.PQRepository;
import com.spring.services.BuildingService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BuildingServiceImpl implements BuildingService{

	private final BuildingRepository buildingRepository;
	private final PQRepository pqRepository;
	
	@Override
	public  Optional<BuildingDto> addBuilding(BuildingDto buildingDto) {
		
		Optional<Building> building=TO_BUILDING.apply(buildingDto);
		return  TO_BUILDINGDTO.apply(buildingRepository.save(building.get()));
		
	}
	@Override
	public List<BuildingDto> getAll() {
		System.out.println(buildingRepository.findAll().get(0).getBuldingSection()+"  repo");
		return TO_BUILDINGDTOS.apply(buildingRepository.findAll());
	}
	@Override
	public Optional<BuildingDto> updateBuilding(BuildingDto buildingDto) {
		
		return TO_BUILDINGDTO.apply(buildingRepository.save(TO_BUILDING.apply(buildingDto).get()));
	}
	@Override
	public boolean deletebuilding(Long buildingId) {
		List<PQ>pQ=pqRepository.findByBuildingSectionBuildingBuilidingId(buildingId);
		for(PQ p:pQ) {
			pqRepository.deleteById(p.getPQId());
		}
		buildingRepository.deleteById(buildingId);	
		return true;
	}
}
