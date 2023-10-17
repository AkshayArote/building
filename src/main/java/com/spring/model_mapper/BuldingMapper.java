package com.spring.model_mapper;

import static com.spring.util.FunctionUtil.evalMapper;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.spring.model_mapper.BuildingSectionMapper.TO_BUILDINGSECTIONDTOS;

import org.modelmapper.internal.bytebuddy.asm.Advice.Return;

import com.spring.dto.BuildingDto;
import com.spring.entity.Building;

public class BuldingMapper {

	public BuldingMapper() {
	}

	public static final Function<BuildingDto, Optional<Building>> TO_BUILDING = e -> evalMapper(e, Building.class);

	public static final Function<Building, Optional<BuildingDto>> TO_BUILDINGDTO = e -> {
		Optional<BuildingDto> buildingDto=evalMapper(e, BuildingDto.class);
		buildingDto.get().setBuldingSectionDto(TO_BUILDINGSECTIONDTOS.apply(e.getBuldingSection()));
		return buildingDto;
	};

	public static final Function<Collection<Building>, List<BuildingDto>> TO_BUILDINGDTOS = e -> {
		return e.stream().map(d -> TO_BUILDINGDTO.apply(d).get()).collect(Collectors.toList());
	};

}
