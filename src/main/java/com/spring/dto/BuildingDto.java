package com.spring.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.spring.entity.BuildingSection;
import com.spring.entity.PQ;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BuildingDto {

	private Long builidingId;

	private String builidingName;

	private String address;

	List<BuildingSectionDto> buldingSectionDto = new ArrayList();

}
