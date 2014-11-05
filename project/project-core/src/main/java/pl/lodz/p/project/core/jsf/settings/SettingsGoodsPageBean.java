package pl.lodz.p.project.core.jsf.settings;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import pl.lodz.p.project.core.dto.good.GoodGroupDTO;
import pl.lodz.p.project.core.dto.good.TaxDTO;
import pl.lodz.p.project.core.dto.good.UnitDTO;
import pl.lodz.p.project.core.service.good.GoodGroupService;
import pl.lodz.p.project.core.service.good.TaxService;
import pl.lodz.p.project.core.service.good.UnitService;

/**
 *
 * @author milczu
 */
@Named(value = "settingsGoodsPageBean")
@Scope("request")
public class SettingsGoodsPageBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private TaxDTO newTax = new TaxDTO();
    private UnitDTO newUnit = new UnitDTO();
    private GoodGroupDTO newGoodGroup = new GoodGroupDTO();
    private List<TaxDTO> taxes;
    private List<UnitDTO> units;
    private List<GoodGroupDTO> goodGroups;

    @Autowired
    private TaxService taxesManagementEndpointLocal;

    @Autowired
    private GoodGroupService goodsGroupsManagementEndpointLocal;

    @Autowired
    private UnitService unitsManagementEndpointLocal;

    @PostConstruct
    public void init() {
        loadTaxes();
        loadUnits();
        loadGoodGroups();
    }

    private void loadTaxes() {
        taxes = taxesManagementEndpointLocal.getAll();
    }

    private void loadUnits() {
        units = unitsManagementEndpointLocal.getAll();
    }

    private void loadGoodGroups() {
        goodGroups = goodsGroupsManagementEndpointLocal.getAll();
    }

    public List<TaxDTO> getTaxes() {
        return taxes;
    }

    public List<UnitDTO> getUnits() {
        return units;
    }

    public List<GoodGroupDTO> getGoodGroups() {
        return goodGroups;
    }

    public void onTaxEdit(RowEditEvent event) {
        TaxDTO editedTax = ((TaxDTO) event.getObject());
        taxesManagementEndpointLocal.save(editedTax);
        loadTaxes();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Zapisano stawkę vat: ", editedTax.getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void removeTax(TaxDTO tax) {
        taxesManagementEndpointLocal.delete(tax);
        loadTaxes();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usunięto stawkę vat: ", tax.getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public TaxDTO getNewTax() {
        return newTax;
    }

    public void saveNewTax() {
        TaxDTO taxToSave = new TaxDTO(newTax);
        System.out.println("New tax: " + taxToSave);
        taxesManagementEndpointLocal.save(taxToSave);
        loadTaxes();
        newTax = new TaxDTO();
    }

    public void onUnitEdit(RowEditEvent event) {
        UnitDTO editedUnit = (UnitDTO) event.getObject();
        unitsManagementEndpointLocal.save(editedUnit);
        loadUnits();

        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Zapisano jednostkę miary: ", editedUnit.getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void removeUnit(UnitDTO unit) {
        unitsManagementEndpointLocal.delete(unit);
        loadUnits();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usunięto jednostkę miary: ", unit.getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public UnitDTO getNewUnit() {
        return newUnit;
    }

    public void saveNewUnit() {
        UnitDTO unitToSave = new UnitDTO(newUnit);
        System.out.println("Zapisz: " + unitToSave);
        unitsManagementEndpointLocal.save(unitToSave);
        loadUnits();
        newUnit = new UnitDTO();
    }

    public void onGoodGroupEdit(RowEditEvent event) {
        GoodGroupDTO editedGroup = (GoodGroupDTO) event.getObject();
        goodsGroupsManagementEndpointLocal.save(editedGroup);
        loadGoodGroups();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Zapisano grupę: ", editedGroup.getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void removeGoodGroup(GoodGroupDTO goodGroup) {
        goodsGroupsManagementEndpointLocal.delete(goodGroup);
        loadGoodGroups();
        
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usunięto grupę: ", goodGroup.getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public GoodGroupDTO getNewGoodGroup() {
        return newGoodGroup;
    }

    public void saveNewGoodGroup() {
        GoodGroupDTO groupToSave = new GoodGroupDTO(newGoodGroup);
        System.out.println("New goodGroup: " + groupToSave);
        goodsGroupsManagementEndpointLocal.save(newGoodGroup);
        loadGoodGroups();
        newGoodGroup = new GoodGroupDTO();
    }
    
}
