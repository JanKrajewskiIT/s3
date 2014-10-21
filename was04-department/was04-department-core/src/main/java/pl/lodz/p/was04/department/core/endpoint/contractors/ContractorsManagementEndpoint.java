package pl.lodz.p.was04.department.core.endpoint.contractors;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.was04.department.core.dao.pagingandsearching.Page;
import pl.lodz.p.was04.department.core.dao.pagingandsearching.PageImpl;
import pl.lodz.p.was04.department.core.dao.pagingandsearching.PageRequest;
import pl.lodz.p.was04.department.core.domain.contractors.Contractor;
import pl.lodz.p.was04.department.core.dto.contractors.ContractorDTO;
import pl.lodz.p.was04.department.core.interceptor.TrackerInterceptor;
import pl.lodz.p.was04.department.core.manager.contractors.ContractorsManagerLocal;

/**
 *
 * @author Janiu
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class ContractorsManagementEndpoint implements ContractorsManagementEndpointLocal {

    @Autowired
    private ContractorsManagerLocal contractorsManagerLocal;

    private List<ContractorDTO> createContractorsDTOList(List<Contractor> listOfEnties) {
        List<ContractorDTO> list = new ArrayList<>();
        for (Contractor listOfEntie : listOfEnties) {
            list.add(new ContractorDTO(listOfEntie));
        }
        return list;
    }

    @RolesAllowed("contractorManagement")
    @Override
    public List<ContractorDTO> getAllContractors() {
        return createContractorsDTOList(contractorsManagerLocal.getAllContractors());
    }

    @RolesAllowed("contractorManagement")
    @Override
    public void removeContractor(Long id) {
        contractorsManagerLocal.removeContractor(id);
    }

    @RolesAllowed("contractorManagement")
    @Override
    public void addContractor(ContractorDTO contractorDTO) {
        Contractor contractor = new Contractor(contractorDTO);
        contractorsManagerLocal.saveContractor(contractor, false);
    }
    
    @Override
    public void editContractor(ContractorDTO contractorDTO) {
        Contractor contractor = new Contractor(contractorDTO);
        contractorsManagerLocal.saveContractor(contractor, true);
    }

    @RolesAllowed("contractorManagement")
    @Override
    public ContractorDTO findById(Long id) {
        return new ContractorDTO(contractorsManagerLocal.findById(id));
    }

    @Override
    public Page<ContractorDTO> search(String searchQuery, PageRequest pageRequest) {
        Page<Contractor> pageGoods = contractorsManagerLocal.search(searchQuery, pageRequest);
        List<ContractorDTO> contactorDTOs = createContractorsDTOList(pageGoods.getContent());
        return new PageImpl<>(contactorDTOs, pageRequest, pageGoods.getTotalElements());
    }

}
