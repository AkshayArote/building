package com.spring.entity;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Building {
	
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "builiding_id",nullable = false)
  private Long builidingId;
  
  private String bulidingName;
  
  private String address;
  
  @OneToMany(mappedBy = "building", cascade = { CascadeType.ALL })
  Set<BuildingSection> buldingSection=new HashSet();
//
//  @OneToMany(mappedBy = "building", cascade = { CascadeType.DETACH })
//  Set<PQ> pQ=new HashSet();
}
