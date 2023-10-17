package com.spring.model_mapper;

import static com.spring.util.FunctionUtil.evalMapper;

import static com.spring.model_mapper.BuldingMapper.TO_BUILDING;
import static com.spring.model_mapper.PQModel_mapper.TO_PQ;
import static com.spring.model_mapper.PQModel_mapper.TO_PQDTO;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.spring.dto.BuildingDto;
import com.spring.dto.BuildingSectionDto;
import com.spring.entity.Building;
import com.spring.entity.BuildingSection;

public class BuildingSectionMapper {
	public BuildingSectionMapper() {
	}
	
	public static final Function<BuildingSectionDto,Optional<BuildingSection>> TO_BUILDINGSECTION = e-> {
		Optional<BuildingSection> buildingSection =evalMapper(e, BuildingSection.class);
		TO_BUILDING.apply(e.getBuildingDto()).ifPresent(buildingSection.get()::setBuilding);
		TO_PQ.apply(e.getPQDto()).ifPresent(buildingSection.get()::setPQ);
		return buildingSection;
	};
	

	public static final Function<BuildingSection,Optional<BuildingSectionDto>> TO_BUILDINGSECTIONDTO = e->{ 
		Optional<BuildingSectionDto> BuildingSectionDto= evalMapper(e, BuildingSectionDto.class);
		TO_PQDTO.apply(e.getPQ()).ifPresent(BuildingSectionDto.get()::setPQDto);;
	return BuildingSectionDto;
	};
	
	public static final Function<Collection<BuildingSection>,List<BuildingSectionDto>> TO_BUILDINGSECTIONDTOS = e->{ 
	return e.stream().map(b->TO_BUILDINGSECTIONDTO.apply(b).get()).collect(Collectors.toList());
	};
	

}
