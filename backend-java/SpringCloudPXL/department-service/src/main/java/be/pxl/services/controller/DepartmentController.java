package be.pxl.services.controller;

import be.pxl.services.domain.dto.DepartmentRequest;
import be.pxl.services.domain.dto.DepartmentResponse;
import be.pxl.services.services.IDepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
@RequiredArgsConstructor //lombok: autowiring van service
public class DepartmentController {
    private final IDepartmentService departmentService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void addDepartment(@RequestBody DepartmentRequest departmentRequest){
        departmentService.addDepartment(departmentRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentResponse> findById(@PathVariable Long id){
        return new ResponseEntity(departmentService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentResponse>> findAll(){
        return new ResponseEntity(departmentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/organization/{organizationId}")
    public ResponseEntity<List<DepartmentResponse>> findByOrganization(@PathVariable Long organizationId){
        return new ResponseEntity<>(departmentService.findByOrganization(organizationId), HttpStatus.OK);
    }

    @GetMapping("/organization/{organizationId}/with-employees")
    public ResponseEntity<List<DepartmentResponse>> findByOrganizationWithEMployees(@PathVariable Long organizationId){
        return new ResponseEntity<>(departmentService.findByOrganizationWithEmployees(organizationId), HttpStatus.OK);
    }

}
