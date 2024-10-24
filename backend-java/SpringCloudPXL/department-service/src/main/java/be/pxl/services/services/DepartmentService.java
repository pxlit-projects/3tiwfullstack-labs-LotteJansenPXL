package be.pxl.services.services;

import be.pxl.services.domain.Department;
import be.pxl.services.domain.Employee;
import be.pxl.services.domain.dto.DepartmentRequest;
import be.pxl.services.domain.dto.DepartmentResponse;
import be.pxl.services.domain.dto.EmployeeResponse;
import be.pxl.services.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService implements IDepartmentService{
    private final DepartmentRepository departmentRepository;

    @Override
    public void addDepartment(DepartmentRequest departmentRequest) {
        Department department = Department.builder()
                .name(departmentRequest.getName())
                .employees(departmentRequest.getEmployees())
                .organizationId(departmentRequest.getOrganizationId())
                .build();
        departmentRepository.save(department);
    }

    private DepartmentResponse mapToDepartmentResponse(Department department, boolean withEmployees) {
        DepartmentResponse response =  DepartmentResponse.builder()
                .name(department.getName())
                .position(department.getPosition())
                .organizationId(department.getOrganizationId())
                .build();
        if(withEmployees){
            response.setEmployees(department.getEmployees());
        }
        return response;
    }

    @Override
    public DepartmentResponse findById(Long id) {
        Department department = departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
        return mapToDepartmentResponse(department, false);
    }

    @Override
    public List<DepartmentResponse> findAll() {
        return departmentRepository.findAll().stream()
                .map(department -> mapToDepartmentResponse(department, false)).toList();
    }

    @Override
    public List<DepartmentResponse> findByOrganization(Long organizationId) {
        return departmentRepository.findByOrganization(organizationId)
                .stream().map(department -> mapToDepartmentResponse(department, false)).toList();
    }

    @Override
    public List<DepartmentResponse> findByOrganizationWithEmployees(Long organizationId) {
        return departmentRepository.findByOrganization(organizationId)
                .stream().map(department -> mapToDepartmentResponse(department, true)).toList();
    }
}
