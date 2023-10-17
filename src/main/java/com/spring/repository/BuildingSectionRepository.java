package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.BuildingSection;

@Repository
public interface BuildingSectionRepository extends JpaRepository<BuildingSection, Long>{

}
