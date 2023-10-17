package com.spring.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Lazy;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class PQ {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "pq_id",nullable = false)
	private Long pQId;
	
	private String type;
	
	private Integer percentage;
	
	@OneToOne(mappedBy = "pQ",cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	BuildingSection buildingSection;
	
//	@OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
//	@JoinColumn(name = "section_id")
//	BuildingSection buldingSections;
	
}
