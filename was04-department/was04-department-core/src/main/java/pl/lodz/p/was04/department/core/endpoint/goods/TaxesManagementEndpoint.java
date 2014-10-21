package pl.lodz.p.was04.department.core.endpoint.goods;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.was04.department.core.domain.goods.Tax;
import pl.lodz.p.was04.department.core.dto.goods.TaxDTO;
import pl.lodz.p.was04.department.core.interceptor.TrackerInterceptor;
import pl.lodz.p.was04.department.core.manager.goods.TaxesManagerLocal;

/**
 *
 * @author Łukasz, milczu
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class TaxesManagementEndpoint implements TaxesManagementEndpointLocal {

    @Autowired
    TaxesManagerLocal taxesManagerLocal;

    @RolesAllowed({"settings", "goodsManagement"})
    @Override
    public List<TaxDTO> getTaxes() {
        return createTaxesDTOList(taxesManagerLocal.getTaxes());
    }

    private List<TaxDTO> createTaxesDTOList(List<Tax> listOfEnties) {
        List<TaxDTO> taxesDTO = new ArrayList<>();
        for (int i = 0; i < listOfEnties.size(); i++) {
            taxesDTO.add(new TaxDTO(listOfEnties.get(i)));
        }
        return taxesDTO;
    }

    @RolesAllowed("goodsManagement")
    @Override
    public TaxDTO getTax(Long id) {
        return new TaxDTO(taxesManagerLocal.getById(id));
    }

    @RolesAllowed("settings")
    @Override
    public void edit(TaxDTO taxDTO) {
        taxesManagerLocal.edit(new Tax(taxDTO));
    }

    @RolesAllowed("settings")
    @Override
    public void remove(TaxDTO taxDTO) {
        taxesManagerLocal.remove(new Tax(taxDTO));
    }

    @RolesAllowed("settings")
    @Override
    public Long add(TaxDTO taxDTO) {
        return taxesManagerLocal.add(new Tax(taxDTO));
    }
}
