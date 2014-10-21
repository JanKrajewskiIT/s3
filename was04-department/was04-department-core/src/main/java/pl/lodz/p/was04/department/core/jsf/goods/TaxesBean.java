package pl.lodz.p.was04.department.core.jsf.goods;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import pl.lodz.p.was04.department.core.dto.goods.TaxDTO;
import pl.lodz.p.was04.department.core.endpoint.goods.TaxesManagementEndpointLocal;

/**
 *
 * @author Łukasz
 */
@Named(value = "taxesBean")
@Scope("view")
public class TaxesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
    private TaxesManagementEndpointLocal taxesManagementEndpointLocal;

    private List<TaxDTO> taxesList;

    /**
     * Creates a new instance of Units
     */
    public TaxesBean() {
    }

    @PostConstruct
    public void init() {
        setTaxesList(taxesManagementEndpointLocal.getTaxes());
    }

    /**
     * @return the taxesList
     */
    public List<TaxDTO> getTaxesList() {
        return taxesList;
    }

    /**
     * @param taxesList the taxesList to set
     */
    public void setTaxesList(List<TaxDTO> taxesList) {
        this.taxesList = taxesList;
    }

}
