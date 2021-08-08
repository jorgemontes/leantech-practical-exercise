package com.jorge.montes.leantech.leantechpracticalexercise.mapper;

import com.jorge.montes.leantech.leantechpracticalexercise.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = PersonMapper.class)
public interface EmployeeMapper {

    @Mapping(target = "id", ignore = true)
    void updateEmployeeFromEntity(Employee employee, @MappingTarget Employee employeeToUpdate);
}
