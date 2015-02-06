package pl.lodz.p.project.core.service.document.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.lodz.p.project.core.dao.base.AbstractCrudDao;
import pl.lodz.p.project.core.domain.document.service.ServiceProductsRequest;
import pl.lodz.p.project.core.domain.document.service.ServiceProductsRequestGood;
import pl.lodz.p.project.core.dto.account.UserDTO;
import pl.lodz.p.project.core.dto.document.service.ServiceProductRequestItemDTO;
import pl.lodz.p.project.core.dto.document.service.ServiceProductsRequestDTO;
import pl.lodz.p.project.core.dto.document.warehouse.InternalInvoiceDTO;
import pl.lodz.p.project.core.dto.document.warehouse.InternalInvoiceGoodDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;
import pl.lodz.p.project.core.jsf.config.ConstantElements;
import pl.lodz.p.project.core.service.account.UserService;
import pl.lodz.p.project.core.service.base.AbstractService;
import pl.lodz.p.project.core.service.document.items.DocumentNumeratorService;
import pl.lodz.p.project.core.service.document.warehouse.InternalInvoiceService;

import javax.faces.context.FacesContext;
import javax.interceptor.Interceptors;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by milczu on 29.01.15.
 */
@Service
@Interceptors({TrackerInterceptor.class})
public class ServiceProductsRequestServiceImpl extends AbstractBaseService<ServiceProductsRequest, ServiceProductsRequestDTO> implements ServiceProductsRequestService {

    @Autowired
    private InternalInvoiceService internalInvoiceService;

    @Autowired
    private DocumentNumeratorService documentNumeratorService;

    @Autowired
    private UserService userService;

    @Override
    public ServiceProductsRequest save(ServiceProductsRequestDTO objectDTO) {
        boolean createWarehouseDocument = objectDTO.isNew();
        ServiceProductsRequest entity = super.save(objectDTO);

        if(createWarehouseDocument) {
            InternalInvoiceDTO internalInvoiceDTO = new InternalInvoiceDTO();
            internalInvoiceDTO.setSymbol(documentNumeratorService.nextNumber(internalInvoiceDTO.getType()));
            internalInvoiceDTO.setDocumentDate(new Date());

            String remoteUser = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
            UserDTO userDTO = userService.getUserByEmail(remoteUser);

            internalInvoiceDTO.setIssuePerson(userDTO);

            List<InternalInvoiceGoodDTO> goodsList = new ArrayList<>(objectDTO.getGoodList().size());
            for (ServiceProductRequestItemDTO productRequestItemDTO : objectDTO.getGoodList()) {
                InternalInvoiceGoodDTO goodDTO = new InternalInvoiceGoodDTO();
                goodDTO.setGood(productRequestItemDTO.getGood());
                goodDTO.setInvoice(internalInvoiceDTO);
                goodDTO.setQuantity(productRequestItemDTO.getQuantity());

                goodsList.add(goodDTO);
            }
            internalInvoiceDTO.setGoodList(goodsList);
            internalInvoiceService.save(internalInvoiceDTO);
        }

        return entity;
    }
}
