package com.jorge.montes.leantech.leantechpracticalexercise.controller;

import com.jorge.montes.leantech.leantechpracticalexercise.dto.PositionDto;
import com.jorge.montes.leantech.leantechpracticalexercise.entity.Employee;
import com.jorge.montes.leantech.leantechpracticalexercise.mapper.PositionMapper;
import com.jorge.montes.leantech.leantechpracticalexercise.repository.EmployeeRepository;
import com.jorge.montes.leantech.leantechpracticalexercise.repository.PositionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/position")
public class PositionController {

    private final EmployeeRepository employeeRepository;

    private final PositionRepository positionRepository;

    private final PositionMapper positionMapper;

    public PositionController(EmployeeRepository employeeRepository, PositionRepository positionRepository, PositionMapper positionMapper) {
        this.employeeRepository = employeeRepository;
        this.positionRepository = positionRepository;
        this.positionMapper = positionMapper;
    }

    @GetMapping
    public List<PositionDto> listPosition() {
        List<PositionDto> result = new ArrayList<>();
        Map<Long, List<Employee>> employeesMap = StreamSupport.stream(employeeRepository.findAllOrderBySalaryDesc().spliterator(), false)
                .collect(Collectors.groupingBy(em -> em.getPosition().getId()));
        employeesMap.forEach((k, v) -> {
            var position = positionRepository.findById(k).orElseGet(() -> null);
            PositionDto positionDto = positionMapper.map(position);
            positionDto.setEmployees(v);
            result.add(positionDto);
        });
        return result;
    }
}
