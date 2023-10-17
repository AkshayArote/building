package com.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.PQ;
@Repository
public interface PQRepository extends JpaRepository<PQ, Long>{

	List<PQ> findByBuildingSectionBuildingBuilidingId(Long buidling);
	
	PQ findByBuildingSectionSectionId(Long buidling);
}
