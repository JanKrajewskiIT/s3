package pl.lodz.p.project.core.domain.good;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author Jan Krajewski
 */
@Embeddable
public class Prices implements Serializable {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @NotNull
    @Column(name = "price_a_net")
    private Double priceANet;

    @Basic(optional = false)
    @NotNull
    @Column(name = "price_a_gross")
    private Double priceAGross;

    @Basic(optional = false)
    @NotNull
    @Column(name = "price_mag_net")
    private Double priceMagNet;

    @Basic(optional = false)
    @NotNull
    @Column(name = "price_mag_gross")
    private Double priceMagGross;

    @Basic(optional = true)
    @Column(name = "price_b_net")
    private Double priceBNet;

    @Basic(optional = true)
    @Column(name = "price_b_gross")
    private Double priceBGross;

    @Basic(optional = true)
    @Column(name = "price_c_net")
    private Double priceCNet;

    @Basic(optional = true)
    @Column(name = "price_c_gross")
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
