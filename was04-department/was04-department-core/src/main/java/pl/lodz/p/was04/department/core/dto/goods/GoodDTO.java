package pl.lodz.p.was04.department.core.dto.goods;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import pl.lodz.p.was04.department.core.domain.goods.Good;
import pl.lodz.p.was04.department.core.enums.GoodType;

/**
 *
 * @author Łukasz, milczu, Łukasz Gadomski
 */
public class GoodDTO implements Serializable, Comparable<GoodDTO> {

	private static final long serialVersionUID = 1L;
	
	private Long id;
    @NotNull(message = "Symbol nie może być pusty!")
    private String symbol;
    @NotNull(message = "Nazwa nie może być pusta!")
    private String name;
    private GoodType type = GoodType.Towar;
    private String pkwiu;
    @NotNull(message = "Cena A Netto nie może być pusta!")
    private BigDecimal priceANet;
    @NotNull(message = "Cena A Brutto nie może być pusta!")
    private BigDecimal priceAGross;
    @NotNull(message = "Cena Magazynowa Netto nie może być pusta!")
    private BigDecimal priceMagNet;
    @NotNull(message = "Cena Magazynowa  Brutto nie może być pusta!")
    private BigDecimal priceMagGross;
    private BigDecimal priceBNet;
    private BigDecimal priceBGross;
    private BigDecimal priceCNet;
    private BigDecimal priceCGross;
    private String description;
    private double weight;
    private boolean active = true;
    private Long version = 1L;
    private UnitDTO unit;
    private TaxDTO tax;
    private GoodGroupDTO goodGroup;

    public GoodDTO() {
        unit = new UnitDTO();
        tax = new TaxDTO();
        goodGroup = new GoodGroupDTO();
    }

    public GoodDTO(Good good) {
        this.id = good.getId();
        this.symbol = good.getSymbol();
        this.name = good.getName();
        this.type = good.getType();
        this.pkwiu = good.getPkwiu();
        this.priceANet = good.getPriceANet();
        this.priceAGross = good.getPriceAGross();
        this.priceMagNet = good.getPriceMagNet();
        this.priceMagGross = good.getPriceMagGross();
        this.priceBNet = good.getPriceBNet();
        this.priceBGross = good.getPriceBGross();
        this.priceCNet = good.getPriceCNet();
        this.priceCGross = good.getPriceCGross();
        this.description = good.getDescription();
        this.weight = good.getWeight();
        this.active = good.isActive();
        this.version = good.getVersion();
        this.tax = new TaxDTO(good.getTax());
        this.unit = new UnitDTO(good.getUnit());
        this.goodGroup = new GoodGroupDTO(good.getGoodGroup());

    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * @param symbol the symbol to set
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the type
     */
    public GoodType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(GoodType type) {
        this.type = type;
    }

    /**
     * @return the pkwiu
     */
    public String getPkwiu() {
        return pkwiu;
    }

    /**
     * @param pkwiu the pkwiu to set
     */
    public void setPkwiu(String pkwiu) {
        this.pkwiu = pkwiu;
    }

    /**
     * @return the priceANet
     */
    public BigDecimal getPriceANet() {
        return priceANet;
    }

    /**
     * @param priceANet the priceANet to set
     */
    public void setPriceANet(BigDecimal priceANet) {
        this.priceANet = priceANet;
    }

    /**
     * @return the priceAGross
     */
    public BigDecimal getPriceAGross() {
        return priceAGross;
    }

    /**
     * @param priceAGross the priceAGross to set
     */
    public void setPriceAGross(BigDecimal priceAGross) {
        this.priceAGross = priceAGross;
    }

    /**
     * @return the priceMagNet
     */
    public BigDecimal getPriceMagNet() {
        return priceMagNet;
    }

    /**
     * @param priceMagNet the priceMagNet to set
     */
    public void setPriceMagNet(BigDecimal priceMagNet) {
        this.priceMagNet = priceMagNet;
    }

    /**
     * @return the priceMagGross
     */
    public BigDecimal getPriceMagGross() {
        return priceMagGross;
    }

    /**
     * @param priceMagGross the priceMagGross to set
     */
    public void setPriceMagGross(BigDecimal priceMagGross) {
        this.priceMagGross = priceMagGross;
    }

    /**
     * @return the priceBNet
     */
    public BigDecimal getPriceBNet() {
        return priceBNet;
    }

    /**
     * @param priceBNet the priceBNet to set
     */
    public void setPriceBNet(BigDecimal priceBNet) {
        this.priceBNet = priceBNet;
    }

    /**
     * @return the priceBGross
     */
    public BigDecimal getPriceBGross() {
        return priceBGross;
    }

    /**
     * @param priceBGross the priceBGross to set
     */
    public void setPriceBGross(BigDecimal priceBGross) {
        this.priceBGross = priceBGross;
    }

    /**
     * @return the priceCNet
     */
    public BigDecimal getPriceCNet() {
        return priceCNet;
    }

    /**
     * @param priceCNet the priceCNet to set
     */
    public void setPriceCNet(BigDecimal priceCNet) {
        this.priceCNet = priceCNet;
    }

    /**
     * @return the priceCGross
     */
    public BigDecimal getPriceCGross() {
        return priceCGross;
    }

    /**
     * @param priceCGross the priceCGross to set
     */
    public void setPriceCGross(BigDecimal priceCGross) {
        this.priceCGross = priceCGross;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the weight
     */
    public Double getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    /**
     * @return the active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @param isActive the active to set
     */
    public void setIsActive(boolean isActive) {
        this.active = isActive;
    }

    /**
     * @return the version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     * @return the unit
     */
    public UnitDTO getUnit() {
        return unit;
    }

    /**
     * @param unit the unit to set
     */
    public void setUnit(UnitDTO unit) {
        this.unit = unit;
    }

    /**
     * @return the tax
     */
    public TaxDTO getTax() {
        return tax;
    }

    /**
     * @param tax the tax to set
     */
    public void setTax(TaxDTO tax) {
        this.tax = tax;
    }

    /**
     * @return the goodGroup
     */
    public GoodGroupDTO getGoodGroup() {
        return goodGroup;
    }

    /**
     * @param goodGroup the goodGroup to set
     */
    public void setGoodGroup(GoodGroupDTO goodGroup) {
        this.goodGroup = goodGroup;
    }

    @Override
    public int compareTo(GoodDTO o) {
        return id.compareTo(o.id);
    }

    @Override
    public String toString() {
        return "GoodDTO{" + "id=" + id + ", symbol=" + symbol + ", name=" + name + ", type=" + type + ", pkwiu=" + pkwiu + ", priceANet=" + priceANet + ", priceAGross=" + priceAGross + ", priceMagNet=" + priceMagNet + ", priceMagGross=" + priceMagGross + ", priceBNet=" + priceBNet + ", priceBGross=" + priceBGross + ", priceCNet=" + priceCNet + ", priceCGross=" + priceCGross + ", description=" + description + ", weight=" + weight + ", active=" + active + ", version=" + version + ", unit=" + unit + ", tax=" + tax + ", goodGroup=" + goodGroup + '}';
    }

}
