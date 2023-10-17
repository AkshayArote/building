package com.spring.controller;

import java.io.IOException;
import java.util.EnumMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring.dto.BuildingDto;
import com.spring.enums.ApiKey;
import com.spring.services.BuildingService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import static com.spring.enums.ApiKey.DATA;
import static com.spring.enums.ApiKey.SUCCES;

@RestController
@RequestMapping("/building")
@RequiredArgsConstructor
public class BuildingController {

	private final BuildingService buildingService;

	@PostMapping
	public ResponseEntity<EnumMap<ApiKey, Object>> addBulding(@RequestBody BuildingDto buildingDto) throws IOException {
		EnumMap<ApiKey, Object> map = new EnumMap<>(ApiKey.class);
		try {
			map.put(DATA, buildingService.addBuilding(buildingDto));
			map.put(SUCCES, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(map);
	}

	@GetMapping
	public ResponseEntity<EnumMap<ApiKey, Object>> getAllBuilding() {
		EnumMap<ApiKey, Object> map = new EnumMap<>(ApiKey.class);

		map.put(DATA, buildingService.getAll());
		map.put(SUCCES, true);
		return ResponseEntity.ok(map);
	}

	@PutMapping
	public ResponseEntity<EnumMap<ApiKey, Object>> updateBuilding(@RequestBody BuildingDto buildingDto) {
		EnumMap<ApiKey, Object> map = new EnumMap<>(ApiKey.class);
		map.put(DATA, buildingService.updateBuilding(buildingDto));
		map.put(SUCCES, true);
		
		return ResponseEntity.ok(map);
	}
	
	@DeleteMapping("/{buildingId}")
	public ResponseEntity<EnumMap<ApiKey, Object>> deleteBuilding(@PathVariable Long buildingId) {
		EnumMap<ApiKey, Object> map = new EnumMap<>(ApiKey.class);

		map.put(DATA, buildingService.deletebuilding(buildingId));
		map.put(SUCCES, true);
		
		return ResponseEntity.ok(map);
	}
}
