package pl.lodz.p.project.core.domain.document.service;

public enum ServiceDocumentType {

	REPAIR_ORDER("Zgłoszenie serwisowe"), PRODUCTS_REQUEST("Zapotrzebowanie serwisowe"), FIX_SUMMARY("Podsumowanie naprawy");
	
	private final String label;
	
	ServiceDocumentType(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
}
