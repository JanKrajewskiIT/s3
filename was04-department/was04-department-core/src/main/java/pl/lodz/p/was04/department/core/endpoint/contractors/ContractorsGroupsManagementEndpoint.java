package pl.lodz.p.was04.department.core.endpoint.contractors;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.was04.department.core.domain.contractors.ContractorGroup;
import pl.lodz.p.was04.department.core.dto.contractors.ContractorGroupDTO;
import pl.lodz.p.was04.department.core.interceptor.TrackerInterceptor;
import pl.lodz.p.was04.department.core.manager.contractors.ContractorsGroupsManagerLocal;

/**
 *
 * @author Janiu
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class ContractorsGroupsManagementEndpoint implements ContractorsGroupsManagementEndpointLocal {

    @Autowired
    ContractorsGroupsManagerLocal contractorsGroupsManagerLocal;

    @RolesAllowed("contractorGroupManagement")
    @Override
    public List<ContractorGroupDTO> getContractorsGroups() {
        return createContractorsGroupsDTOList(contractorsGroupsManagerLocal.getContractorsGroups());
    }

    private List<ContractorGroupDTO> createContractorsGroupsDTOList(List<ContractorGroup> listOfEnties) {
        List<ContractorGroupDTO> contractorGroupDTO = new ArrayList<>();
        for (ContractorGroup listOfEntie : listOfEnties) {
            contractorGroupDTO.add(new ContractorGroupDTO(listOfEntie));
        }
        return contractorGroupDTO;
    }

    @RolesAllowed("contractorGroupManagement")
    @Override
    public ContractorGroupDTO getContractorGroup(Long id) {
        return new ContractorGroupDTO(contractorsGroupsManagerLocal.getById(id));
    }

    @RolesAllowed("contractorGroupManagement")
    @Override
    public Long add(ContractorGroupDTO clientGroupDTO) {
        return contractorsGroupsManagerLocal.add(new ContractorGroup(clientGroupDTO));
    }

    @RolesAllowed("contractorGroupManagement")
    @Override
    public void edit(ContractorGroupDTO clientGroupDTO) {
        contractorsGroupsManagerLocal.edit(new ContractorGroup(clientGroupDTO));
    }

    @RolesAllowed("contractorGroupManagement")
    @Override
    public void remove(ContractorGroupDTO clientGroupDTO) {
        contractorsGroupsManagerLocal.remove(new ContractorGroup(clientGroupDTO));
    }

}
