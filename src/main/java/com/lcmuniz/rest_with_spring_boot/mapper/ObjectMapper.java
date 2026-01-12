package com.lcmuniz.rest_with_spring_boot.mapper;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.Collection;

public class ObjectMapper {

    private final static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <O, D> D map(O origin, Class<D> destinationClass) {
        return mapper.map(origin, destinationClass);
    }

    public static <O, D> Collection<D> mapList(Collection<O> origin, Class<D> destinationClass) {
        return origin.stream().map(o -> mapper.map(o, destinationClass)).toList();
    }

}
