package pl.lodz.p.project.core.service.document.service;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lodz.p.project.core.domain.document.service.ServiceProductsRequest;
import pl.lodz.p.project.core.dto.account.UserDTO;
import pl.lodz.p.project.core.dto.document.service.ServiceProductRequestItemDTO;
import pl.lodz.p.project.core.dto.document.service.ServiceProductsRequestDTO;
import pl.lodz.p.project.core.dto.document.warehouse.InternalInvoiceDTO;
import pl.lodz.p.project.core.dto.document.warehouse.InternalInvoiceGoodDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;
import pl.lodz.p.project.core.service.account.UserService;
import pl.lodz.p.project.core.service.document.items.DocumentNumeratorService;
import pl.lodz.p.project.core.service.document.warehouse.InternalInvoiceService;

import javax.faces.context.FacesContext;
import javax.interceptor.Interceptors;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by milczu on 29.01.15.
 */
@Service
@Interceptors({TrackerInterceptor.class})
public class ServiceProductsRequestServiceImpl extends AbstractBaseService<ServiceProductsRequest, ServiceProductsRequestDTO> implements ServiceProductsRequestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceProductsRequestServiceImpl.class);

    @Autowired
    private InternalInvoiceService internalInvoiceService;

    @Autowired
    private DocumentNumeratorService documentNumeratorService;

    @Autowired
    private UserService userService;

    @Override
    public ServiceProductsRequest save(ServiceProductsRequestDTO objectDTO) {
        boolean createWarehouseDocument = !objectDTO.getGoodList().isEmpty();
        ServiceProductsRequest entity = super.save(objectDTO);

        //LOGGER.info("request: {}", FacesContext.getCurrentInstance().getExternalContext().getRequestServletPath());

        if (createWarehouseDocument) {
            InternalInvoiceDTO internalInvoiceDTO = new InternalInvoiceDTO();
            internalInvoiceDTO.setSymbol(documentNumeratorService.nextNumber(internalInvoiceDTO.getType()));
            internalInvoiceDTO.setDocumentDate(new Date());
            internalInvoiceDTO.setDeliverPerson(StringUtils.EMPTY);
            internalInvoiceDTO.setReceivePerson(StringUtils.EMPTY);
            internalInvoiceDTO.setAnnotation("Wydanie dla serwisu. Zapotrzebowanie serwisowe: " + entity.getSymbol());

            String remoteUser = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
            UserDTO userDTO = userService.getUserByEmail(remoteUser);

            internalInvoiceDTO.setIssuePerson(userDTO);

            List<InternalInvoiceGoodDTO> goodsList = new ArrayList<>(objectDTO.getGoodList().size());
            double total = 0.00;
            for (ServiceProductRequestItemDTO productRequestItemDTO : objectDTO.getGoodList()) {
                InternalInvoiceGoodDTO goodDTO = new InternalInvoiceGoodDTO();
                goodDTO.setGood(productRequestItemDTO.getGood());
                goodDTO.setInvoice(internalInvoiceDTO);
                goodDTO.setQuantity(productRequestItemDTO.getQuantity());
                total += goodDTO.getGood().getPrices().getPriceMagGross();

                goodsList.add(goodDTO);
            }
            internalInvoiceDTO.setTotal(total);
            internalInvoiceDTO.setGoodList(goodsList);
            internalInvoiceService.save(internalInvoiceDTO);
        }

        return entity;
    }
}
