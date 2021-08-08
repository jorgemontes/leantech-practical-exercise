package com.jorge.montes.leantech.leantechpracticalexercise.mapper;

import com.jorge.montes.leantech.leantechpracticalexercise.dto.PositionDto;
import com.jorge.montes.leantech.leantechpracticalexercise.entity.Employee;
import com.jorge.montes.leantech.leantechpracticalexercise.entity.Position;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PositionMapper {
    PositionDto map(Position position);
}
