package pl.lodz.p.was04.department.core.jsf.goods;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import pl.lodz.p.was04.department.core.dto.documents.WarehouseDTO;
import pl.lodz.p.was04.department.core.dto.goods.GoodDTO;
import pl.lodz.p.was04.department.core.dto.goods.WarehouseGoodDTO;
import pl.lodz.p.was04.department.core.endpoint.documents.WarehousesEndpointLocal;
import pl.lodz.p.was04.department.core.endpoint.goods.GoodsGroupsManagementEndpointLocal;
import pl.lodz.p.was04.department.core.endpoint.goods.GoodsManagementEndpointLocal;
import pl.lodz.p.was04.department.core.endpoint.goods.TaxesManagementEndpointLocal;
import pl.lodz.p.was04.department.core.endpoint.goods.UnitsManagementEndpointLocal;
import pl.lodz.p.was04.department.core.endpoint.goods.WarehousesGoodsEndpointLocal;

/**
 *
 * @author Łukasz
 */
@Named(value = "goodAddEditBean")
@Scope("view")
public class GoodAddEditBean implements Serializable {

    @Autowired
    private GoodsManagementEndpointLocal goodsManagementEndpointLocal;

    @Autowired
    private GoodsGroupsManagementEndpointLocal goodsGroupsManagementEndpointLocal;

    @Autowired
    private TaxesManagementEndpointLocal taxesManagementEndpointLocal;

    @Autowired
    private UnitsManagementEndpointLocal unitsManagementEndpointLocal;

    @Autowired
    private WarehousesEndpointLocal warehousesEndpoint;

    @Autowired
    private WarehousesGoodsEndpointLocal warehousesGoodsEndpointLocal;

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
        getGood().setGoodGroup(goodsGroupsManagementEndpointLocal.getGroup(getGood().getGoodGroup().getId()));
        getGood().setTax(taxesManagementEndpointLocal.getTax(getGood().getTax().getId()));

        //TODO id changed from string to long
        //if (StringUtils.isBlank(getGood().getId())) {
        if(true) {  
        	List<WarehouseDTO> warehouses = warehousesEndpoint.getWarehouses();
            Long id = goodsManagementEndpointLocal.add(getGood());
            for (WarehouseDTO warehouseDTO : warehouses) {
                WarehouseGoodDTO warehouseGoodDTO = new WarehouseGoodDTO();
                warehouseGoodDTO.setGoodId(goodsManagementEndpointLocal.findById(id));
                warehouseGoodDTO.setQuantity(0.0);
                warehouseGoodDTO.setWarehouseId(warehouseDTO);
                warehousesGoodsEndpointLocal.add(warehouseGoodDTO);
            }
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
