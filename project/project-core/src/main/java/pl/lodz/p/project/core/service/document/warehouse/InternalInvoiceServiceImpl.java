package pl.lodz.p.project.core.service.document.warehouse;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.lodz.p.project.core.converter.document.warehouse.InternalInvoiceGoodConverter;
import pl.lodz.p.project.core.dao.document.warehouse.InternalInvoiceDao;
import pl.lodz.p.project.core.dao.document.warehouse.InternalInvoiceGoodDao;
import pl.lodz.p.project.core.dao.pagingandsearching.Page;
import pl.lodz.p.project.core.dao.pagingandsearching.PageImpl;
import pl.lodz.p.project.core.dao.pagingandsearching.PageRequest;
import pl.lodz.p.project.core.domain.document.warehouse.InternalInvoice;
import pl.lodz.p.project.core.domain.document.warehouse.InternalInvoiceGood;
import pl.lodz.p.project.core.dto.document.warehouse.InternalInvoiceDTO;
import pl.lodz.p.project.core.dto.document.warehouse.InternalInvoiceGoodDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;
import pl.lodz.p.project.core.service.base.AbstractService;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;
import java.util.List;

/**
 * @author Jan Krajewski
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class InternalInvoiceServiceImpl extends AbstractService<InternalInvoice, InternalInvoiceDTO> implements InternalInvoiceService {

    private final static String ACCESS_LEVEL = "documentManagement";

    @Autowired
    private InternalInvoiceGoodDao invoiceGoodDao;

    @Autowired
    private InternalInvoiceGoodConverter converter;

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public InternalInvoiceDTO getOneById(Long id) {
        return super.getOneById(id);
    }

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public List<InternalInvoiceDTO> getAll() {
        return super.getAll();
    }

    //www.skillbus.guru
    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public InternalInvoice save(InternalInvoiceDTO invoice) {
        InternalInvoice invoiceEntity = super.save(invoice);
        List<InternalInvoiceGood> goodList = Lists.transform(invoice.getGoodList(), new GoodListConverter(invoiceEntity.getId()));
        Iterable<InternalInvoiceGood> goodListEntity = invoiceGoodDao.save(goodList);
        //invoiceEntity.setGoodList(Lists.newArrayList(goodListEntity));
        return invoiceEntity;
    }

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public Page<InternalInvoiceDTO> search(String searchQuery, PageRequest pageRequest) {
        Page<InternalInvoice> page = ((InternalInvoiceDao) dao).search(searchQuery, pageRequest);
        List<InternalInvoiceDTO> list = Lists.transform(page.getContent(), transformer);
        return new PageImpl<>(list, pageRequest, page.getTotalElements());
    }

    private class GoodListConverter implements Function<InternalInvoiceGoodDTO, InternalInvoiceGood> {

        private Long invoiceId;

        public GoodListConverter (Long invoiceId) {
            this.invoiceId = invoiceId;
        }

        @Override
        public InternalInvoiceGood apply(InternalInvoiceGoodDTO input) {
            InternalInvoiceGood good = converter.convertDTO(input);
            good.getId().getInvoice().setId(invoiceId);
            return good;
        }
    }

}
