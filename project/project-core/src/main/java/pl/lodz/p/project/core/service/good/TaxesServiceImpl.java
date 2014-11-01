package pl.lodz.p.project.core.service.good;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.project.core.converter.good.TaxConverter;
import pl.lodz.p.project.core.dao.good.TaxDao;
import pl.lodz.p.project.core.domain.good.Tax;
import pl.lodz.p.project.core.dto.good.TaxDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;

/**
 *
 * @author Janiu, Milczu
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class TaxesServiceImpl implements TaxesService {

    @Autowired
    TaxDao taxesDao;
    
    @Autowired
    TaxConverter taxConverter; 

    @RolesAllowed({"settings", "goodsManagement"})
    @Override
    public List<TaxDTO> getTaxes() {
        List<TaxDTO> taxeList = new ArrayList<>();
        for (Tax tax : taxesDao.findAll()) {
        	TaxDTO taxDTO = taxConverter.convertEntity(tax);
        	taxeList.add(taxDTO);
        }
        return taxeList;
    }

    @RolesAllowed("goodsManagement")
    @Override
    public TaxDTO getTax(Long id) {
    	Tax tax = taxesDao.findOne(id);
        return taxConverter.convertEntity(tax);
    }

    @RolesAllowed("settings")
    @Override
    public void edit(TaxDTO taxDTO) {
    	Tax tax = taxConverter.convertDTO(taxDTO);
        taxesDao.save(tax);
    }

    @RolesAllowed("settings")
    @Override
    public void remove(TaxDTO taxDTO) {
    	Tax tax = taxConverter.convertDTO(taxDTO);
        taxesDao.save(tax);
    }

    @RolesAllowed("settings")
    @Override
    public Long add(TaxDTO taxDTO) {
    	Tax tax = taxConverter.convertDTO(taxDTO);
        taxesDao.save(tax);
        return tax.getId();
    }
}