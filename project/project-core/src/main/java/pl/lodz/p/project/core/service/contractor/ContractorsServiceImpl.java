package pl.lodz.p.project.core.service.contractor;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.project.core.converter.contractor.ContractorConverter;
import pl.lodz.p.project.core.dao.contractor.ContractorDao;
import pl.lodz.p.project.core.dao.pagingandsearching.Page;
import pl.lodz.p.project.core.dao.pagingandsearching.PageImpl;
import pl.lodz.p.project.core.dao.pagingandsearching.PageRequest;
import pl.lodz.p.project.core.domain.contractor.Contractor;
import pl.lodz.p.project.core.dto.contractor.ContractorDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;
import pl.lodz.p.project.core.service.Transformer;

import com.google.common.collect.Lists;

/**
 *
 * @author Janiu, Milczu
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class ContractorsServiceImpl implements ContractorsService {

    @Autowired
    private ContractorDao contractorDao;
    
    @Autowired
    private ContractorConverter contractorConverter;


    @RolesAllowed("contractorManagement")
    @Override
    public List<ContractorDTO> getAllContractors() {
    	Transformer<Contractor, ContractorDTO> transformer = new Transformer<>(contractorConverter);
    	return Lists.transform(contractorDao.findAll(), transformer);
    }

    @RolesAllowed("contractorManagement")
    @Override
    public void removeContractor(Long id) {
        contractorDao.delete(id);
    }

    @RolesAllowed("contractorManagement")
    @Override
    public void addContractor(ContractorDTO contractorDTO) {
        Contractor contractor = contractorConverter.convertDTO(contractorDTO);
        contractorDao.save(contractor, false);
    }
    
    @Override
    public void editContractor(ContractorDTO contractorDTO) {
        Contractor contractor = contractorConverter.convertDTO(contractorDTO);
        contractorDao.save(contractor, true);
    }

    @RolesAllowed("contractorManagement")
    @Override
    public ContractorDTO findById(Long id) {
    	Contractor contractor = contractorDao.findOne(id);
    	return contractorConverter.convertEntity(contractor);
    }

    @Override
    public Page<ContractorDTO> search(String searchQuery, PageRequest pageRequest) {
        Page<Contractor> pageGoods = contractorDao.search(searchQuery, pageRequest);       
        Transformer<Contractor, ContractorDTO> transformer = new Transformer<>(contractorConverter);
        List<ContractorDTO> contractorList = Lists.transform(pageGoods.getContent(), transformer);
        return new PageImpl<>(contractorList, pageRequest, pageGoods.getTotalElements());
    }

}
