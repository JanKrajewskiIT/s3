package pl.lodz.p.project.core.jsf.documents.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import pl.lodz.p.project.core.dto.document.items.TransportMeanDTO;
import pl.lodz.p.project.core.jsf.base.EditListController;
import pl.lodz.p.project.core.service.base.ServiceRepository;
import pl.lodz.p.project.core.service.document.items.TransportMeanService;

import javax.annotation.PostConstruct;
import javax.inject.Named;

/**
 * @author Jan Krajewski
 */
@Named
@Scope("view")
public class TransportMeanListController extends EditListController<TransportMeanDTO> {

    @Autowired
    private TransportMeanService service;

    @PostConstruct
    private void init() {
        initList();
    }

    @Override
    public ServiceRepository getService() {
        return service;
    }
}
