package com.spring.util;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static java.util.stream.Collectors.toList;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class FunctionUtil {

	private FunctionUtil() {}

	private static final ModelMapper mp = new ModelMapper();
	
	static {
		 mp.getConfiguration().setAmbiguityIgnored(true);
		 mp.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}
   

	public static <T, R> List<R> eval(List<T> list, Function<T, R> function) {
		return isNull(list) || list.isEmpty() ? Collections.emptyList() : list.stream().map(function).distinct().collect(toList());
	}

	
	public static <T> Optional<T> evalMapper(Object obj, Class<T> clazz) {
		return isNull(obj) || isNull(clazz) ? Optional.empty() : Optional.of(mp.map(obj, clazz));
	}

	
	
	public static <T> Optional<T> evalMapperProjection(Object obj, Class<T> clazz) {
		return isNull(obj) || isNull(clazz) ? Optional.empty() : Optional.of(mp.map(obj, clazz));
	}
	
	public static <C,T> Collection<T> evalMapperCollection(Collection<C> list, Class<T> clazz) {
		if (isNull(list) || isNull(clazz) || list.isEmpty()) return Collections.emptyList();
		return list.stream().map(e -> evalMapper(e, clazz)).filter(Optional :: isPresent)
			.map(Optional :: get).collect(Collectors 	.toList());
	}
}
