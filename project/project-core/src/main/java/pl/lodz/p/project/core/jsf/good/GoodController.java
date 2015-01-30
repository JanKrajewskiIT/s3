package pl.lodz.p.project.core.jsf.good;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import pl.lodz.p.project.core.dto.good.*;
import pl.lodz.p.project.core.enums.GoodType;
import pl.lodz.p.project.core.jsf.base.EditObjectController;
import pl.lodz.p.project.core.service.base.ServiceRepository;
import pl.lodz.p.project.core.service.good.GoodService;

import javax.inject.Named;

/**
 * @author Jan Krajewski
 */
@Named
@Scope("view")
public class GoodController extends EditObjectController<GoodDTO> {

    @Autowired
    private GoodService service;

    @Override
    protected void createNew() {
        setSourceObject(new GoodDTO());
        getSourceObject().setGroup(new GoodGroupDTO());
        getSourceObject().setType(GoodType.GOOD);
        getSourceObject().setTax(new TaxDTO());
        getSourceObject().setUnit(new UnitDTO());
        getSourceObject().setPrices(new PricesDTO());
        getSourceObject().setQuantity(100.0);
    }

    @Override
    public ServiceRepository getService() {
        return service;
    }

    public void handlePriceMagNetChange() {
        if (getSourceObject().getPrices().getPriceMagNet() != null) {
            getSourceObject().getPrices().setPriceMagGross(getSourceObject().getPrices().getPriceMagNet() * ((100.00 + getSourceObject().getTax().getValue().doubleValue()) / 100.00));
        }
    }

    public void handlePriceMagGrossChange() {
        if (getSourceObject().getPrices().getPriceMagGross() != null) {
            getSourceObject().getPrices().setPriceMagNet((getSourceObject().getPrices().getPriceMagGross() * 100.00) / (100.00 + getSourceObject().getTax().getValue().doubleValue()));
        }
    }

    public void handlePriceANetChange() {
        if (getSourceObject().getPrices().getPriceANet() != null) {
            getSourceObject().getPrices().setPriceAGross(getSourceObject().getPrices().getPriceANet() * ((100.00 + getSourceObject().getTax().getValue().doubleValue()) / 100.00));
        }
    }

    public void handlePriceAGrossChange() {
        if (getSourceObject().getPrices().getPriceAGross() != null) {
            getSourceObject().getPrices().setPriceANet((getSourceObject().getPrices().getPriceAGross() * 100.00) / (100.00 + getSourceObject().getTax().getValue().doubleValue()));
        }
    }

    public void handlePriceBNetChange() {
        if (getSourceObject().getPrices().getPriceBNet() != null) {
            getSourceObject().getPrices().setPriceBGross(getSourceObject().getPrices().getPriceBNet() * ((100.00 + getSourceObject().getTax().getValue().doubleValue()) / 100.00));
        }
    }

    public void handlePriceBGrossChange() {
        if (getSourceObject().getPrices().getPriceBGross() != null) {
            getSourceObject().getPrices().setPriceBNet((getSourceObject().getPrices().getPriceBGross() * 100.00) / (100.00 + getSourceObject().getTax().getValue()));
        }
    }

    public void handlePriceCNetChange() {
        if (getSourceObject().getPrices().getPriceCNet() != null) {
            getSourceObject().getPrices().setPriceCGross(getSourceObject().getPrices().getPriceCNet() * ((100.00 + getSourceObject().getTax().getValue().doubleValue()) / 100.00));
        }
    }

    public void handlePriceCGrossChange() {
        if (getSourceObject().getPrices().getPriceCGross() != null) {
            getSourceObject().getPrices().setPriceCNet((getSourceObject().getPrices().getPriceCGross() * 100.00) / (100.00 + getSourceObject().getTax().getValue()));
        }
    }

}
