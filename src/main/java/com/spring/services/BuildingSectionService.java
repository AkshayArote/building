package com.spring.services;

import java.util.Optional;

import com.spring.dto.BuildingSectionDto;

public interface BuildingSectionService {

	BuildingSectionDto add(BuildingSectionDto buildingSectionDto);
	
	Optional<BuildingSectionDto> update(BuildingSectionDto buildingSectionDto);

	boolean delete(Long sectionId);

}
