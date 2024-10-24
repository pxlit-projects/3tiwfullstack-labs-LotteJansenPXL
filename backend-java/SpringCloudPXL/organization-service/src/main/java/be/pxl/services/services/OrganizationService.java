package be.pxl.services.services;

import be.pxl.services.domain.Organization;
import be.pxl.services.domain.dto.EmployeeResponse;
import be.pxl.services.domain.dto.OrganizationResponse;
import be.pxl.services.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationService implements IOrganizationService{
    private final OrganizationRepository organizationRepository;
    @Override
    public OrganizationResponse findById(Long id) {
        Organization organization = organizationRepository.findById(id).orElseThrow(() -> new RuntimeException("Organization not found"));
        return mapToOrganizationResponse(organization, false, false);
    }

    private OrganizationResponse mapToOrganizationResponse(Organization organization, boolean includeDepartments, boolean includeEmployees) {
        OrganizationResponse response = new OrganizationResponse();
        response.setName(organization.getName());
        response.setAddress(organization.getAddress());

        if(includeDepartments){
            response.setDepartments(organization.getDepartments());
        }
        if(includeEmployees){
            response.setEmployees(organization.getEmployees());
        }
        return response;
    }

    @Override
    public OrganizationResponse findByIdWithDepartments(Long id) {
        Organization organization = organizationRepository.findById(id).orElseThrow(() -> new RuntimeException("Organization not found"));
        return mapToOrganizationResponse(organization, true, false);

    }

    @Override
    public OrganizationResponse findByIdWithDepartmentsandEmployees(Long id) {
        Organization organization = organizationRepository.findById(id).orElseThrow(() -> new RuntimeException("Organization not found"));
        return mapToOrganizationResponse(organization, true, true);
    }

    @Override
    public OrganizationResponse findByIdWithEmployees(Long id) {
        Organization organization = organizationRepository.findById(id).orElseThrow(() -> new RuntimeException("Organization not found"));
        return mapToOrganizationResponse(organization, false,true);
    }
}
