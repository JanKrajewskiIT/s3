package pl.lodz.p.was04.department.core.jsf.settings;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import pl.lodz.p.was04.department.core.dto.goods.GoodGroupDTO;
import pl.lodz.p.was04.department.core.dto.goods.TaxDTO;
import pl.lodz.p.was04.department.core.dto.goods.UnitDTO;
import pl.lodz.p.was04.department.core.endpoint.goods.GoodsGroupsManagementEndpointLocal;
import pl.lodz.p.was04.department.core.endpoint.goods.TaxesManagementEndpointLocal;
import pl.lodz.p.was04.department.core.endpoint.goods.UnitsManagementEndpointLocal;

/**
 *
 * @author milczu
 */
@Named(value = "settingsGoodsPageBean")
@Scope("view")
public class SettingsGoodsPageBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private TaxDTO newTax = new TaxDTO();
    private UnitDTO newUnit = new UnitDTO();
    private GoodGroupDTO newGoodGroup = new GoodGroupDTO();
    private List<TaxDTO> taxes;
    private List<UnitDTO> units;
    private List<GoodGroupDTO> goodGroups;

    @Autowired
    private TaxesManagementEndpointLocal taxesManagementEndpointLocal;

    @Autowired
    private GoodsGroupsManagementEndpointLocal goodsGroupsManagementEndpointLocal;

    @Autowired
    private UnitsManagementEndpointLocal unitsManagementEndpointLocal;

    @PostConstruct
    public void init() {
        loadTaxes();
        loadUnits();
        loadGoodGroups();
    }

    private void loadTaxes() {
        taxes = taxesManagementEndpointLocal.getTaxes();
    }

    private void loadUnits() {
        units = unitsManagementEndpointLocal.getUnits();
    }

    private void loadGoodGroups() {
        goodGroups = goodsGroupsManagementEndpointLocal.getGoodsGroups();
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
        taxesManagementEndpointLocal.edit(editedTax);
        loadTaxes();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Zapisano stawkę vat: ", editedTax.getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void removeTax(TaxDTO tax) {
        taxesManagementEndpointLocal.remove(tax);
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
        taxesManagementEndpointLocal.add(taxToSave);
        loadTaxes();
        newTax = new TaxDTO();
    }

    public void onUnitEdit(RowEditEvent event) {
        UnitDTO editedUnit = (UnitDTO) event.getObject();
        unitsManagementEndpointLocal.edit(editedUnit);
        loadUnits();

        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Zapisano jednostkę miary: ", editedUnit.getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void removeUnit(UnitDTO unit) {
        unitsManagementEndpointLocal.remove(unit);
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
        unitsManagementEndpointLocal.add(unitToSave);
        loadUnits();
        newUnit = new UnitDTO();
    }

    public void onGoodGroupEdit(RowEditEvent event) {
        GoodGroupDTO editedGroup = (GoodGroupDTO) event.getObject();
        goodsGroupsManagementEndpointLocal.edit(editedGroup);
        loadGoodGroups();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Zapisano grupę: ", editedGroup.getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void removeGoodGroup(GoodGroupDTO goodGroup) {
        goodsGroupsManagementEndpointLocal.remove(goodGroup);
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
        goodsGroupsManagementEndpointLocal.add(newGoodGroup);
        loadGoodGroups();
        newGoodGroup = new GoodGroupDTO();
    }
}
