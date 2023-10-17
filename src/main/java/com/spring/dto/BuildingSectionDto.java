package com.spring.dto;

import java.util.ArrayList;
import java.util.List;

import com.spring.entity.Building;
import com.spring.entity.PQ;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BuildingSectionDto {
	private Long sectionId;

	private Integer floorArea;

	BuildingDto buildingDto;
	
	PQDto pQDto;
}
