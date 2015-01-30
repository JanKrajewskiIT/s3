package pl.lodz.p.project.core.dto.document.service;

import pl.lodz.p.project.core.dto.good.GoodDTO;

public class ServiceProductRequestItemDTO {

	private GoodDTO good;
	private double quantity;
	private ServiceProductsRequestDTO document;
	
	public GoodDTO getGood() {
		return good;
	}
	public void setGood(GoodDTO good) {
		this.good = good;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public ServiceProductsRequestDTO getDocument() {
		return document;
	}

	public void setDocument(ServiceProductsRequestDTO document) {
		this.document = document;
	}
}
