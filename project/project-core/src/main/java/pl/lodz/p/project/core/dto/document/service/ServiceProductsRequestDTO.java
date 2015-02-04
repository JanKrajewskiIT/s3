package pl.lodz.p.project.core.dto.document.service;

import pl.lodz.p.project.core.domain.document.service.ServiceDocumentType;
import pl.lodz.p.project.core.domain.document.service.ServiceProductsRequest;

import java.util.ArrayList;
import java.util.List;

public class ServiceProductsRequestDTO extends BaseServiceDocumentDTO {
	
	public ServiceProductsRequestDTO() {
		super(ServiceDocumentType.PRODUCTS_REQUEST);
		setType(ServiceProductsRequest.DOCUMENT_TYPE);
	}

	private List<ServiceProductRequestItemDTO> goodList = new ArrayList<>();
	private String serviceRepairOrderSymbol;

	public List<ServiceProductRequestItemDTO> getGoodList() {
		return goodList;
	}

	public void setGoodList(List<ServiceProductRequestItemDTO> goodList) {
		this.goodList = goodList;
	}
	public String getServiceRepairOrderSymbol() {
		return serviceRepairOrderSymbol;
	}
	public void setServiceRepairOrderSymbol(String serviceRepairOrderSymbol) {
		this.serviceRepairOrderSymbol = serviceRepairOrderSymbol;
	}
	
	
}
