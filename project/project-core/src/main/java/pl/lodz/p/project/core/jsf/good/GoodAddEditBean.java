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
        good.setUnit(units.isEmpty() ? null : units.get(0));
        return good;
    }

    public void clear() {
        setGood(createNew());
    }

    public String saveGood() {
        good.setUnit(unitService.getOneById(getGood().getUnit().getId()));
        good.setGroup(goodsGroupsService.getOneById(getGood().getGroup().getId()));
        good.setTax(taxService.getOneById(getGood().getTax().getId()));

        goodService.save(good);
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
        if (good.getPrices().getPriceMagNet() != null) {
            good.getPrices().setPriceMagGross(good.getPrices().getPriceMagNet() * ((100.00 + good.getTax().getValue().doubleValue()) / 100.00));
        }
    }

    public void handlePriceMagGrossChange() {
        if (good.getPrices().getPriceMagGross() != null) {
            good.getPrices().setPriceMagNet((good.getPrices().getPriceMagGross() * 100.00) / (100.00 + good.getTax().getValue().doubleValue()));
        }
    }

    public void handlePriceANetChange() {
        if (good.getPrices().getPriceANet() != null) {
            good.getPrices().setPriceAGross(good.getPrices().getPriceANet() * ((100.00 + good.getTax().getValue().doubleValue()) / 100.00));
        }
    }

    public void handlePriceAGrossChange() {
        if (good.getPrices().getPriceAGross() != null) {
            good.getPrices().setPriceANet((good.getPrices().getPriceAGross() * 100.00) / (100.00 + good.getTax().getValue().doubleValue()));
        }
    }

    public void handlePriceBNetChange() {
        if (good.getPrices().getPriceBNet() != null) {
            good.getPrices().setPriceBGross(good.getPrices().getPriceBNet() * ((100.00 + good.getTax().getValue().doubleValue()) / 100.00));
        }
    }

    public void handlePriceBGrossChange() {
        if (good.getPrices().getPriceBGross() != null) {
            good.getPrices().setPriceBNet((good.getPrices().getPriceBGross() * 100.00) / (100.00 + good.getTax().getValue()));
        }
    }

    public void handlePriceCNetChange() {
        if (good.getPrices().getPriceCNet() != null) {
            good.getPrices().setPriceCGross(good.getPrices().getPriceCNet() * ((100.00 + good.getTax().getValue().doubleValue()) / 100.00));
        }
    }

    public void handlePriceCGrossChange() {
        if (good.getPrices().getPriceCGross() != null) {
            good.getPrices().setPriceCNet((good.getPrices().getPriceCGross() * 100.00) / (100.00 + good.getTax().getValue()));
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
