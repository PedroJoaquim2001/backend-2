package com.projectBackend2.projectBackend.controller;

import com.projectBackend2.projectBackend.controller.dto.AdminsDto;
import com.projectBackend2.projectBackend.controller.dto.EmployeeDto;
import com.projectBackend2.projectBackend.controller.form.AdminsForm;
import com.projectBackend2.projectBackend.controller.form.EmployeesForm;
import com.projectBackend2.projectBackend.model.AdminsModel;
import com.projectBackend2.projectBackend.model.EmployeesModel;
import com.projectBackend2.projectBackend.service.EmployeesService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/employee")
public class EmployeesController {
    @Autowired
    private EmployeesService employeesService;

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody @Valid EmployeesForm form, UriComponentsBuilder uriBuilder){
        EmployeesModel employeesModel = form.convert();
        employeesService.save(employeesModel);

        URI uri = uriBuilder.path("/employee/{id}").buildAndExpand(employeesModel.getId()).toUri();
        return ResponseEntity.created(uri).body(new EmployeeDto(employeesModel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable UUID id){
        Optional<EmployeesModel> employeesModelOptional = employeesService.findById(id);
        if(!employeesModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(new EmployeeDto(employeesModelOptional.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable UUID id){
        Optional<EmployeesModel> employeesModelOptional = employeesService.findById(id);
        if (!employeesModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee to delete not found.");
        }
        employeesService.delete(employeesModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Employee deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEmployee(@PathVariable UUID id, @RequestBody @Valid EmployeesForm form){
        Optional<EmployeesModel> employeesModelOptional = employeesService.findById(id);
        if (!employeesModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee to update not found.");
        }
        var employee = new EmployeesModel();
        BeanUtils.copyProperties(form, employee);
        employee = form.convert();
        employee.setId(employeesModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(employeesService.save(employee));
    }

}
