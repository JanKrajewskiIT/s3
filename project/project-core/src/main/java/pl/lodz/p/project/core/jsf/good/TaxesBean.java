package pl.lodz.p.project.core.jsf.good;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import pl.lodz.p.project.core.dto.good.TaxDTO;
import pl.lodz.p.project.core.service.good.TaxService;

/**
 *
 * @author Łukasz
 */
@Named(value = "taxesBean")
@Scope("request")
public class TaxesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
    private TaxService taxesManagementEndpointLocal;

    private List<TaxDTO> taxesList;

    /**
     * Creates a new instance of Units
     */
    public TaxesBean() {
    }

    @PostConstruct
    public void init() {
        setTaxesList(taxesManagementEndpointLocal.getAll());
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
