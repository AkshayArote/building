package com.spring.serviceImpl;

import org.springframework.stereotype.Service;

import static com.spring.model_mapper.BuildingSectionMapper.TO_BUILDINGSECTION;
import static com.spring.model_mapper.BuildingSectionMapper.TO_BUILDINGSECTIONDTO;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.spring.dto.BuildingSectionDto;
import com.spring.entity.BuildingSection;
import com.spring.entity.PQ;
import com.spring.repository.BuildingSectionRepository;
import com.spring.repository.PQRepository;
import com.spring.services.BuildingSectionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BuildingSectionServiceImpl implements BuildingSectionService {

	private final BuildingSectionRepository buildingSectionRepository;
	private final PQRepository pqRepository;
	
	@Override
	public BuildingSectionDto add(BuildingSectionDto buildingSectionDto) {
		
		return TO_BUILDINGSECTIONDTO.apply(buildingSectionRepository.save(TO_BUILDINGSECTION.apply(buildingSectionDto).get())).get();
	
	}
	
	@Override
	public Optional<BuildingSectionDto> update(BuildingSectionDto buildingSectionDto) {
		
		Optional<BuildingSection> buildingSection=buildingSectionRepository.findById(buildingSectionDto.getSectionId());
		buildingSection.get().setFloorArea(buildingSectionDto.getFloorArea());
		if(Objects.nonNull(buildingSectionDto.getPQDto())) {
			if(Objects.nonNull(buildingSectionDto.getPQDto().getType()))
				buildingSection.get().getPQ().setType(buildingSectionDto.getPQDto().getType());
			if(Objects.nonNull(buildingSectionDto.getPQDto().getPercentage()))
				buildingSection.get().getPQ().setPercentage(buildingSectionDto.getPQDto().getPercentage());
		}
		return TO_BUILDINGSECTIONDTO.apply(buildingSectionRepository.save(buildingSection.get()));
	}
	public boolean delete(Long sectionId) {
		
		PQ pQ=pqRepository.findByBuildingSectionSectionId(sectionId);
		System.out.println(pQ.getPQId());
		buildingSectionRepository.deleteById(sectionId);
		pqRepository.deleteById(pQ.getPQId());
		
		return true;
	}

}
