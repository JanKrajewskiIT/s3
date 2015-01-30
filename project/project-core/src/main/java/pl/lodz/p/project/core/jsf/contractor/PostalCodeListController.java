package pl.lodz.p.project.core.jsf.contractor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import pl.lodz.p.project.core.dto.contractor.PostalCodeDTO;
import pl.lodz.p.project.core.jsf.base.EditListController;
import pl.lodz.p.project.core.service.base.ServiceRepository;
import pl.lodz.p.project.core.service.contractor.PostalCodeService;

import javax.annotation.PostConstruct;
import javax.inject.Named;

/**
 * @author Jan Krajewski
 */
@Named
@Scope("view")
public class PostalCodeListController extends EditListController<PostalCodeDTO> {

    @Autowired
    private PostalCodeService service;

    @PostConstruct
    private void init() {
        initList();
    }

    @Override
    public ServiceRepository getService() {
        return service;
    }

    public PostalCodeDTO retrievePostalCode(String code) {
        for(PostalCodeDTO postalCode : items) {
            if(postalCode.getCode().equals(code)) {
                return postalCode;
            }
        }
        return null;
    }

}
