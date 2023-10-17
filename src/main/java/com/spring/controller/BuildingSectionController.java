package com.spring.controller;

import static com.spring.enums.ApiKey.DATA;
import static com.spring.enums.ApiKey.SUCCES;

import java.util.EnumMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.BuildingDto;
import com.spring.dto.BuildingSectionDto;
import com.spring.dto.PQDto;
import com.spring.enums.ApiKey;
import com.spring.serviceImpl.BuildingSectionServiceImpl;
import com.spring.services.BuildingSectionService;
import com.spring.services.BuildingService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/building-section")
@RequiredArgsConstructor
@RestController
public class BuildingSectionController {

	private final BuildingSectionService buildingSectionService;

	@PostMapping
	public ResponseEntity<EnumMap<ApiKey, Object>> addSection(@RequestBody BuildingSectionDto buildingSectionDto) {
		EnumMap<ApiKey, Object> map = new EnumMap<>(ApiKey.class);
		map.put(DATA,buildingSectionService.add(buildingSectionDto));
		map.put(SUCCES, true);
		return ResponseEntity.ok(map);
	}
	@PutMapping
	public ResponseEntity<EnumMap<ApiKey, Object>> updateSection(@RequestBody BuildingSectionDto buildingSectionDto) {
		EnumMap<ApiKey, Object> map = new EnumMap<>(ApiKey.class);
		map.put(DATA,buildingSectionService.update(buildingSectionDto));
		map.put(SUCCES, true);
		return ResponseEntity.ok(map);
	}
	
	@DeleteMapping("/sectionId/{sectionId}")
	public ResponseEntity<EnumMap<ApiKey, Object>> deleteSection(@PathVariable Long sectionId) {
		EnumMap<ApiKey, Object> map = new EnumMap<>(ApiKey.class);
		map.put(DATA,buildingSectionService.delete(sectionId));
		map.put(SUCCES, true);
		return ResponseEntity.ok(map);
	}

}
