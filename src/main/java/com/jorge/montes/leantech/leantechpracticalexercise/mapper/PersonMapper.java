package com.jorge.montes.leantech.leantechpracticalexercise.mapper;

import com.jorge.montes.leantech.leantechpracticalexercise.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    void updatePersonFromEntity(Person person, @MappingTarget Person personToUpdate);
}
