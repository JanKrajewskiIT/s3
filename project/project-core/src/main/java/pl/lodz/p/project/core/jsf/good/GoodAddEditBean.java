package pl.lodz.p.project.core.jsf.good;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import pl.lodz.p.project.core.dto.good.GoodDTO;
import pl.lodz.p.project.core.dto.good.GoodGroupDTO;
import pl.lodz.p.project.core.dto.good.TaxDTO;
import pl.lodz.p.project.core.dto.good.UnitDTO;
import pl.lodz.p.project.core.enums.GoodType;
import pl.lodz.p.project.core.service.good.GoodGroupService;
import pl.lodz.p.project.core.service.good.GoodService;
import pl.lodz.p.project.core.service.good.TaxService;
import pl.lodz.p.project.core.service.good.UnitService;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Łukasz
 */
@Named(value = "goodAddEditBean")
@Scope("request")
public class GoodAddEditBean implements Serializable {

    private static final long serialVersionUID = -5504508900103108521L;

    @Autowired
    private GoodService goodService;

    @Autowired
    private GoodGroupService goodsGroupsService;

    @Autowired
    private TaxService taxService;

    @Autowired
    private UnitService unitService;

    private List<UnitDTO> units;
    private List<TaxDTO> taxes;
    private List<GoodGroupDTO> goodsGroups;

    private GoodDTO good;
    private String breadcrumb;

    @PostConstruct
    public void init() {
        units = unitService.getAll();
        taxes = taxService.getAll();
        goodsGroups = goodsGroupsService.getAll();

        String goodId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        if (StringUtils.isBlank(goodId)) {
            good = createNew();
            breadcrumb = "Dodaj";
        } else {
            // TODO id from string to long

            breadcrumb = "Edytuj";
        }
    }

    public String editGood(String id) {
        return "addEditGood.xhtml?faces-redirect=true&id=" + id;
    }

    protected GoodDTO createNew() {
        GoodDTO good = new GoodDTO();
        good.setType(GoodType.GOOD);
        good.setTax(taxes.isEmpty() ? null : taxes.get(0));
        good.setGroup(goodsGroups.isEmpty() ? null : goodsGroups.get(0));
        good.setUnit(units.isEmpty() ? null : units.get(0));
        return good;
    }

    public void clear() {
        setGood(createNew());
    }

    public String saveGood() {
        getGood().setUnit(unitService.getOneById(getGood().getUnit().getId()));
        getGood().setGroup(goodsGroupsService.getOneById(getGood().getGroup().getId()));
        getGood().setTax(taxService.getOneById(getGood().getTax().getId()));

        if (getGood().getId() != null) {
            //  TODO currently we dont need warehouses
            /*List<WarehouseDTO> warehouses = warehousesEndpoint.getWarehouses();
            Long id = .add(getGood());
            for (WarehouseDTO warehouseDTO : warehouses) {
                WarehouseGoodDTO warehouseGoodDTO = new WarehouseGoodDTO();
                warehouseGoodDTO.setGoodId(.findById(id));
                warehouseGoodDTO.setQuantity(0.0);
                warehouseGoodDTO.setWarehouseId(warehouseDTO);
                warehousesGoodsEndpointLocal.add(warehouseGoodDTO);
            }
            */
        } else {
            goodService.save(getGood());
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

    public List<UnitDTO> getUnits() {
        return units;
    }

    public List<TaxDTO> getTaxes() {
        return taxes;
    }

    public List<GoodGroupDTO> getGoodsGroups() {
        return goodsGroups;
    }
}
