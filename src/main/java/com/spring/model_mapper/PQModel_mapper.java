package com.spring.model_mapper;

import static com.spring.util.FunctionUtil.evalMapper;

import java.util.Optional;
import java.util.function.Function;

import com.spring.dto.BuildingDto;
import com.spring.dto.PQDto;
import com.spring.entity.Building;
import com.spring.entity.PQ;

public class PQModel_mapper {
	public PQModel_mapper() {
	}
	
	public static final Function<PQDto,Optional<PQ>> TO_PQ = e-> evalMapper(e, PQ.class);

	public static final Function<PQ,Optional<PQDto>> TO_PQDTO = e-> evalMapper(e, PQDto.class);

	
}
