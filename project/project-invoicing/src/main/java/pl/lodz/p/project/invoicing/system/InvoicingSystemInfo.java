package pl.lodz.p.project.invoicing.system;

import org.springframework.stereotype.Component;

import pl.lodz.p.project.commons.system.SystemInfo;

@Component
public class InvoicingSystemInfo implements SystemInfo {

	private static final String NAME = "Invoicing";

	@Override
	public String getSystemName() {
		return NAME;
	}

}
