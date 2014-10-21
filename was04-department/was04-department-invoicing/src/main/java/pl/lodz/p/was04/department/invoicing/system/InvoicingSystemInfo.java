package pl.lodz.p.was04.department.invoicing.system;

import org.springframework.stereotype.Component;

import pl.lodz.p.was04.department.commons.system.SystemInfo;

@Component
public class InvoicingSystemInfo implements SystemInfo {

	private static final String NAME = "Invoicing";

	@Override
	public String getSystemName() {
		return NAME;
	}

}
