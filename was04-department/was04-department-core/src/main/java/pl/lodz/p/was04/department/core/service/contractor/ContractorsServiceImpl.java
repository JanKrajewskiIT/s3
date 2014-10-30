package pl.lodz.p.was04.department.core.service.contractor;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.was04.department.core.converter.contractor.ContractorConverter;
import pl.lodz.p.was04.department.core.dao.contractor.ContractorDao;
import pl.lodz.p.was04.department.core.dao.pagingandsearching.Page;
import pl.lodz.p.was04.department.core.dao.pagingandsearching.PageImpl;
import pl.lodz.p.was04.department.core.dao.pagingandsearching.PageRequest;
import pl.lodz.p.was04.department.core.domain.contractor.Contractor;
import pl.lodz.p.was04.department.core.dto.contractor.ContractorDTO;
import pl.lodz.p.was04.department.core.interceptor.TrackerInterceptor;

/**
 *
 * @author Janiu, Milczu
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class ContractorsServiceImpl implements ContractorsService {

    @Autowired
    private ContractorDao contractorsDao;
    
    @Autowired
    private ContractorConverter contractorConverter;


    @RolesAllowed("contractorManagement")
    @Override
    public List<ContractorDTO> getAllContractors() {
        List<ContractorDTO> contractorList = new ArrayList<>();
        for (Contractor contractor : contractorsDao.findAll()) {
        	ContractorDTO contractorDTO = contractorConverter.convertEntity(contractor);
        	contractorList.add(contractorDTO);
        }
        return contractorList;
    }

    @RolesAllowed("contractorManagement")
    @Override
    public void removeContractor(Long id) {
        contractorsDao.delete(id);
    }

    @RolesAllowed("contractorManagement")
    @Override
    public void addContractor(ContractorDTO contractorDTO) {
        Contractor contractor = contractorConverter.convertDTO(contractorDTO);
        contractorsDao.save(contractor, false);
    }
    
    @Override
    public void editContractor(ContractorDTO contractorDTO) {
        Contractor contractor = contractorConverter.convertDTO(contractorDTO);
        contractorsDao.save(contractor, true);
    }

    @RolesAllowed("contractorManagement")
    @Override
    public ContractorDTO findById(Long id) {
    	Contractor contractor = contractorsDao.findOne(id);
    	return contractorConverter.convertEntity(contractor);
    }

    @Override
    public Page<ContractorDTO> search(String searchQuery, PageRequest pageRequest) {
        Page<Contractor> pageGoods = contractorsDao.search(searchQuery, pageRequest);
        List<ContractorDTO> contractorList = new ArrayList<>();
        for (Contractor contractor : pageGoods.getContent()) {
        	ContractorDTO contractorDTO = contractorConverter.convertEntity(contractor);
        	contractorList.add(contractorDTO);
        }
        return new PageImpl<>(contractorList, pageRequest, pageGoods.getTotalElements());
    }

}
