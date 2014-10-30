package pl.lodz.p.was04.department.core.jsf.good;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import pl.lodz.p.was04.department.core.dto.good.GoodDTO;
import pl.lodz.p.was04.department.core.service.good.GoodsGroupsService;
import pl.lodz.p.was04.department.core.service.good.GoodsService;
import pl.lodz.p.was04.department.core.service.good.TaxesService;
import pl.lodz.p.was04.department.core.service.good.UnitsService;

/**
 *
 * @author Łukasz
 */
@Named(value = "goodAddEditBean")
@Scope("request")
public class GoodAddEditBean implements Serializable {

	private static final long serialVersionUID = -5504508900103108521L;

	@Autowired
    private GoodsService goodsManagementEndpointLocal;

    @Autowired
    private GoodsGroupsService goodsGroupsManagementEndpointLocal;

    @Autowired
    private TaxesService taxesManagementEndpointLocal;

    @Autowired
    private UnitsService unitsManagementEndpointLocal;

    private GoodDTO good;
    private String breadcrumb;

    @PostConstruct
    public void init() {
        String goodId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        if (StringUtils.isBlank(goodId)) {
            good = new GoodDTO();
            getGood().setTax(taxesManagementEndpointLocal.getTaxes().get(0));
            breadcrumb = "Dodaj";
        } else {
        	// TODO id from string to long
            //good = goodsManagementEndpointLocal.findById(goodId);
            breadcrumb = "Edytuj";
        }
    }

    public String editGood(String id) {
        return "addEditGood.xhtml?faces-redirect=true&id=" + id;
    }

    public void clear() {
        setGood(new GoodDTO());
    }

    public String saveGood() {
        getGood().setUnit(unitsManagementEndpointLocal.getUnit(getGood().getUnit().getId()));
        getGood().setGroup(goodsGroupsManagementEndpointLocal.getGroup(getGood().getGroup().getId()));
        getGood().setTax(taxesManagementEndpointLocal.getTax(getGood().getTax().getId()));

        if(getGood().getId() != null) {  
        	//  TODO currently we dont need warehouses
        	/*List<WarehouseDTO> warehouses = warehousesEndpoint.getWarehouses();
            Long id = goodsManagementEndpointLocal.add(getGood());
            for (WarehouseDTO warehouseDTO : warehouses) {
                WarehouseGoodDTO warehouseGoodDTO = new WarehouseGoodDTO();
                warehouseGoodDTO.setGoodId(goodsManagementEndpointLocal.findById(id));
                warehouseGoodDTO.setQuantity(0.0);
                warehouseGoodDTO.setWarehouseId(warehouseDTO);
                warehousesGoodsEndpointLocal.add(warehouseGoodDTO);
            }
            */
        } else {
            goodsManagementEndpointLocal.edit(getGood());
        }
        return "goodsTable.xhtml?faces-redirect=true";
    }

    /**
     * @return the good
     */
    public GoodDTO getGood() {
        return good;
    }

    /**
     * @param good the good to set
     */
    public void setGood(GoodDTO good) {
        this.good = good;
    }

    /**
     * @return the breadcrumb
     */
    public String getBreadcrumb() {
        return breadcrumb;
    }

    /**
     * @param breadcrumb the breadcrumb to set
     */
    public void setBreadcrumb(String breadcrumb) {
        this.breadcrumb = breadcrumb;
    }

    public void handlePriceMagNetChange() {
        if (good.getPriceMagNet() != null) {
            good.setPriceMagGross(new BigDecimal(good.getPriceMagNet().doubleValue() * ((100.00 + good.getTax().getValue().doubleValue()) / 100.00)));
        }
    }

    public void handlePriceMagGrossChange() {
        if (good.getPriceMagGross() != null) {
            good.setPriceMagNet(new BigDecimal((good.getPriceMagGross().doubleValue() * 100.00) / (100.00 + good.getTax().getValue().doubleValue())));
        }
    }

    public void handlePriceANetChange() {
        if (good.getPriceANet() != null) {
            good.setPriceAGross(new BigDecimal(good.getPriceANet().doubleValue() * ((100.00 + good.getTax().getValue().doubleValue()) / 100.00)));
        }
    }

    public void handlePriceAGrossChange() {
        if (good.getPriceAGross() != null) {
            good.setPriceANet(new BigDecimal((good.getPriceAGross().doubleValue() * 100.00) / (100.00 + good.getTax().getValue().doubleValue())));
        }
    }

    public void handlePriceBNetChange() {
        if (good.getPriceBNet() != null) {
            good.setPriceBGross(new BigDecimal(good.getPriceBNet().doubleValue() * ((100.00 + good.getTax().getValue().doubleValue()) / 100.00)));
        }
    }

    public void handlePriceBGrossChange() {
        if (good.getPriceBGross() != null) {
            good.setPriceBNet(new BigDecimal((good.getPriceBGross().doubleValue() * 100.00) / (100.00 + good.getTax().getValue().doubleValue())));
        }
    }

    public void handlePriceCNetChange() {
        if (good.getPriceCNet() != null) {
            good.setPriceCGross(new BigDecimal(good.getPriceCNet().doubleValue() * ((100.00 + good.getTax().getValue().doubleValue()) / 100.00)));
        }
    }

    public void handlePriceCGrossChange() {
        if (good.getPriceCGross() != null) {
            good.setPriceCNet(new BigDecimal((good.getPriceCGross().doubleValue() * 100.00) / (100.00 + good.getTax().getValue().doubleValue())));
        }
    }
}
