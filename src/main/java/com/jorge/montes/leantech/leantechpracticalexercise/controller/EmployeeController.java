package com.jorge.montes.leantech.leantechpracticalexercise.controller;

import com.jorge.montes.leantech.leantechpracticalexercise.entity.Employee;
import com.jorge.montes.leantech.leantechpracticalexercise.entity.Position;
import com.jorge.montes.leantech.leantechpracticalexercise.mapper.EmployeeMapper;
import com.jorge.montes.leantech.leantechpracticalexercise.repository.EmployeeRepository;
import com.jorge.montes.leantech.leantechpracticalexercise.repository.PositionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    private final PositionRepository positionRepository;

    private final EmployeeMapper employeeMapper;

    public EmployeeController(EmployeeRepository employeeRepository, PositionRepository positionRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.positionRepository = positionRepository;
        this.employeeMapper = employeeMapper;
    }

    @PostMapping("/")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        positionRepository.findByName(employee.getPosition().getName()).ifPresentOrElse(position -> employee.setPosition(position), () -> {
            var savedPosition = positionRepository.save(employee.getPosition());
            employee.setPosition(savedPosition);
        });
        return ResponseEntity.ok(employeeRepository.save(employee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(name = "id") Long id, @RequestBody Employee employee) {
        Optional<Position> positionByName = positionRepository.findByName(employee.getPosition().getName());
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (!optionalEmployee.isPresent() || !positionByName.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Employee employeeInDatabase = optionalEmployee.get();
        employeeMapper.updateEmployeeFromEntity(employee, employeeInDatabase);
        employeeInDatabase.setPosition(positionByName.get());
        return ResponseEntity.ok(employeeRepository.save(employeeInDatabase));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEmployee(@PathVariable(name = "id") Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (!optionalEmployee.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        employeeRepository.delete(optionalEmployee.get());
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Employee> listEmployee(@RequestParam(name = "personName", required = false, defaultValue = "") String personName,
                                       @RequestParam(name = "positionName", required = false, defaultValue = "") String positionName) {
        return employeeRepository.findAllByPerson_NameLikeAndPosition_NameLike("%" + personName + "%", "%" + positionName + "%");
    }

}
