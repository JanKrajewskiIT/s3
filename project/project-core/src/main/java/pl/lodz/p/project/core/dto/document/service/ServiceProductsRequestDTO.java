package pl.lodz.p.project.core.dto.document.service;

import java.util.ArrayList;
import java.util.List;

import pl.lodz.p.project.core.domain.document.service.ServiceDocumentType;

public class ServiceProductsRequestDTO extends BaseServiceDocumentDTO {
	
	public ServiceProductsRequestDTO() {
		super(ServiceDocumentType.PRODUCTS_REQUEST);
	}
	
	private List<ServiceProductRequestItemDTO> items = new ArrayList<>();
	private String serviceRepairOrderSymbol;

	public List<ServiceProductRequestItemDTO> getItems() {
		return items;
	}
	public void setItems(List<ServiceProductRequestItemDTO> items) {
		this.items = items;
	}
	public String getServiceRepairOrderSymbol() {
		return serviceRepairOrderSymbol;
	}
	public void setServiceRepairOrderSymbol(String serviceRepairOrderSymbol) {
		this.serviceRepairOrderSymbol = serviceRepairOrderSymbol;
	}
	
	
}
