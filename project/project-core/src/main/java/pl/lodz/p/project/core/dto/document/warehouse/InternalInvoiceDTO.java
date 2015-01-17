package pl.lodz.p.project.core.dto.document.warehouse;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Jan Krajewski
 *
 */
public class InternalInvoiceDTO extends WarehouseInvoiceDTO {

	private static final long serialVersionUID = 1L;

	private List<InternalInvoiceGoodDTO> goodList = new ArrayList<>();

	public List<InternalInvoiceGoodDTO> getGoodList() {
		return goodList;
	}

	public void setGoodList(List<InternalInvoiceGoodDTO> goodList) {
		this.goodList = goodList;
	}
	
}
