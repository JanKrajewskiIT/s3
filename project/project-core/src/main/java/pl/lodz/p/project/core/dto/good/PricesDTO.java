package pl.lodz.p.project.core.dto.good;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author Jan Krajewski
 */
public class PricesDTO implements Serializable {

    @NotNull(message = "Cena A Netto nie może być pusta!")
    private Double priceANet;

    @NotNull(message = "Cena A Brutto nie może być pusta!")
    private Double priceAGross;

    @NotNull(message = "Cena Magazynowa Netto nie może być pusta!")
    private Double priceMagNet;

    @NotNull(message = "Cena Magazynowa  Brutto nie może być pusta!")
    private Double priceMagGross;

    private Double priceBNet;
    private Double priceBGross;
    private Double priceCNet;
    private Double priceCGross;

    public Double getPriceANet() {
        return priceANet;
    }

    public void setPriceANet(Double priceANet) {
        this.priceANet = priceANet;
    }

    public Double getPriceAGross() {
        return priceAGross;
    }

    public void setPriceAGross(Double priceAGross) {
        this.priceAGross = priceAGross;
    }

    public Double getPriceMagNet() {
        return priceMagNet;
    }

    public void setPriceMagNet(Double priceMagNet) {
        this.priceMagNet = priceMagNet;
    }

    public Double getPriceMagGross() {
        return priceMagGross;
    }

    public void setPriceMagGross(Double priceMagGross) {
        this.priceMagGross = priceMagGross;
    }

    public Double getPriceBNet() {
        return priceBNet;
    }

    public void setPriceBNet(Double priceBNet) {
        this.priceBNet = priceBNet;
    }

    public Double getPriceBGross() {
        return priceBGross;
    }

    public void setPriceBGross(Double priceBGross) {
        this.priceBGross = priceBGross;
    }

    public Double getPriceCNet() {
        return priceCNet;
    }

    public void setPriceCNet(Double priceCNet) {
        this.priceCNet = priceCNet;
    }

    public Double getPriceCGross() {
        return priceCGross;
    }

    public void setPriceCGross(Double priceCGross) {
        this.priceCGross = priceCGross;
    }
}
