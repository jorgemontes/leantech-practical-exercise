package com.jorge.montes.leantech.leantechpracticalexercise.dto;

import com.jorge.montes.leantech.leantechpracticalexercise.entity.Employee;

import java.util.List;

public class PositionDto {

    private Long id;

    private String name;

    private List<Employee> employees;

    public PositionDto() {
    }

    public PositionDto(Long id, String name, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.employees = employees;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
