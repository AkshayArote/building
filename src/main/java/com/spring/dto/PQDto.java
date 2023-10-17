package com.spring.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
public class PQDto {

	private Long pQId;
	
	private String type;
	
	private Integer percentage;
	
}
