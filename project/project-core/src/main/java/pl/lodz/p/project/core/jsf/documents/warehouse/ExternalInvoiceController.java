package pl.lodz.p.project.core.jsf.documents.warehouse;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import pl.lodz.p.project.core.dto.document.TransportMeanDTO;
import pl.lodz.p.project.core.dto.document.warehouse.ExternalInvoiceDTO;
import pl.lodz.p.project.core.dto.document.warehouse.ExternalInvoiceGoodDTO;
import pl.lodz.p.project.core.dto.good.GoodDTO;
import pl.lodz.p.project.core.dto.good.UnitDTO;
import pl.lodz.p.project.core.jsf.base.DateUtil;
import pl.lodz.p.project.core.jsf.base.EditObjectController;
import pl.lodz.p.project.core.service.document.TransportMeanService;
import pl.lodz.p.project.core.service.document.warehouse.ExternalInvoiceService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Named
@Scope("request")
public class ExternalInvoiceController extends EditObjectController<ExternalInvoiceDTO> {

	private static final long serialVersionUID = 6806332655702953164L;

	@Autowired
	private InvoiceGoodListController invoiceGoodListController;

	@Autowired
	private GoodListController goodListController;

	@Autowired
	private ExternalInvoiceService service;

	@Autowired
	private TransportMeanService transportMeanService;

	private List<TransportMeanDTO> transportMeanList;

	@PostConstruct
	private void init() {
		setExampleData();
		transportMeanList = transportMeanService.getAll();
	}

	private void setExampleData() {
		UnitDTO unit = new UnitDTO();
		unit.setName("kg");

		GoodDTO good = new GoodDTO();
		good.setName("Komputer");
		good.setPkwiu("PKWIU");
		good.setPriceMagGross(BigDecimal.TEN);
		good.setUnit(unit);

		List<ExternalInvoiceGoodDTO> goodList = new ArrayList<>();
		ExternalInvoiceGoodDTO invoiceGood = new ExternalInvoiceGoodDTO();
		invoiceGood.setVersion(1L);
		invoiceGood.setQuantity(BigDecimal.valueOf(3));
		invoiceGood.setGood(good);

		ExternalInvoiceGoodDTO invoiceGood2 = new ExternalInvoiceGoodDTO();
		invoiceGood2.setVersion(1L);
		invoiceGood2.setQuantity(BigDecimal.valueOf(3));
		invoiceGood2.setGood(good);

		ExternalInvoiceDTO invoice = new ExternalInvoiceDTO();
		invoice.setId(1l);
		invoice.setDeliverPerson("Jan Krajewski");
		invoice.setIssuePerson("Łukasz Gadomski");
		invoice.setReceivePerson("Bartosz Milczarek");
		invoice.setDocumentDate(new Date());
		invoice.setSymbol("WZ01/03/13");
		invoice.setAnnotation("Przykładowa faktura magazynowa");
		invoice.setTotal(123d);
		invoice.setVersion(1l);

		invoice.setOrderSymbol("Order Symbol");
		//TODO dosetowac reszte

		invoiceGood.setInvoice(invoice);
		invoiceGood2.setInvoice(invoice);

		goodList.add(invoiceGood);
		goodList.add(invoiceGood2);
		invoice.setGoodList(goodList);
		setSourceObject(invoice);
	}

	public List<TransportMeanDTO> getTransportMeanList() {
		return transportMeanList;
	}

	public void setTransportMeanList(List<TransportMeanDTO> transportMeanList) {
		this.transportMeanList = transportMeanList;
	}

	@Override
	public void save() {
		//getSourceObject().setDocumentDate(DateUtil.getCurrentDate());
		//service.save(getSourceObject());
	}

	public void addGood() {
		//invoiceGoodListController.setVisible(true);
		//goodListController.setVisible(false);
	}

}
