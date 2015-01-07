package pl.lodz.p.project.core.domain.document.service;

public enum ServiceDocumentState {

	NEW("Nowy"), IN_PROGRESS("W realizacji"), DONE("Zakończony");
	
	private final String label;
	
	ServiceDocumentState(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
