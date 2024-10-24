package be.pxl.services.services;

import be.pxl.services.domain.dto.DepartmentRequest;
import be.pxl.services.domain.dto.DepartmentResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IDepartmentService {
    void addDepartment(DepartmentRequest departmentRequest);

    DepartmentResponse findById(Long id);

    List<DepartmentResponse> findAll();

    List<DepartmentResponse> findByOrganization(Long organizationId);

    List<DepartmentResponse> findByOrganizationWithEmployees(Long organizationId);
}
