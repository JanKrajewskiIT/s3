package pl.lodz.p.project.core.jsf.documents.warehouse;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import pl.lodz.p.project.core.domain.document.warehouse.InternalInvoice;
import pl.lodz.p.project.core.dto.document.warehouse.InternalInvoiceDTO;
import pl.lodz.p.project.core.dto.document.warehouse.InternalInvoiceGoodDTO;
import pl.lodz.p.project.core.dto.good.GoodDTO;
import pl.lodz.p.project.core.dto.good.UnitDTO;
import pl.lodz.p.project.core.jsf.base.DateUtil;
import pl.lodz.p.project.core.jsf.base.EditObjectController;
import pl.lodz.p.project.core.service.document.DocumentNumeratorService;
import pl.lodz.p.project.core.service.document.warehouse.InternalInvoiceService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Named
@Scope("request")
public class InternalInvoiceController extends EditObjectController<InternalInvoiceDTO> {

	private static final long serialVersionUID = 7763768017180337728L;

	private enum Type {
		ANY, WZ, PZ
	}

	@Autowired
	private InternalInvoiceService service;

	@Autowired
	private DocumentNumeratorService documentNumeratorService;

	@PostConstruct
	private void init() {
		setSourceObject(new InternalInvoiceDTO());
		getSourceObject().setTotal(12d);
		getSourceObject().setType(Type.WZ.name());
		getSourceObject().setSymbol(documentNumeratorService.nextNumber(Type.WZ.name()));
	}

	public String getCurrentDate() {
		return DateUtil.getCurrentDateValue();
	}

	@Override
	public void save() {
		getSourceObject().setDocumentDate(DateUtil.getCurrentDate());
		service.save(getSourceObject());
	}
}
