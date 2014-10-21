package pl.lodz.p.was04.department.core.dto.contractors;

import java.io.Serializable;
import java.math.BigDecimal;

import pl.lodz.p.was04.department.core.domain.contractors.Contractor;

/**
 *
 * @author Janiu
 */
public class ContractorDTO implements Serializable, Comparable<ContractorDTO> {

	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String symbol;
    private String name;
    private String contractorType;
    private String roleType;
    private String postCode;
    private String city;
    private String adress;
    private String nip;
    private BigDecimal discount = BigDecimal.ZERO;
    private String accountNumber;
    private String website;
    private String email;
    private String description;
    private String representative;
    private Boolean isActive = true;
    private Long version = 1L;
    private ContractorGroupDTO group;

    public ContractorDTO(Contractor contractor) {
        this.id = contractor.getId();
        this.symbol = contractor.getSymbol();
        this.name = contractor.getName();
        this.postCode = contractor.getPostcode();
        this.city = contractor.getCity();
        this.adress = contractor.getAdress();
        this.nip = contractor.getNip();
        this.discount = contractor.getDiscount();
        this.accountNumber = contractor.getAccountNumber();
        this.website = contractor.getWebsite();
        this.email = contractor.getEmail();
        this.description = contractor.getDescription();
        this.representative = contractor.getRepresentative();
        this.isActive = contractor.isActive();
        this.version = contractor.getVersion();
        this.group = new ContractorGroupDTO(contractor.getContractorGroup());
        if (contractor.isCompany()) {
            this.contractorType = "Firma";
        } else {
            this.contractorType = "Osoba fizyczna";
        }
        if (contractor.isSupplier()) {
            this.roleType = "Dostawca";
        } else {
            this.roleType = "Nabywca";
        }
    }

    public ContractorDTO() {
        group = new ContractorGroupDTO();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContractorType() {
        return contractorType;
    }

    public void setContractorType(String contractorType) {
        this.contractorType = contractorType;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRepresentative() {
        return representative;
    }

    public void setRepresentative(String representative) {
        this.representative = representative;
    }

    public Boolean isActive() {
        return isActive;
    }

    public void setActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public ContractorGroupDTO getGroup() {
        return group;
    }

    public void setGroup(ContractorGroupDTO group) {
        this.group = group;
    }

    @Override
    public int compareTo(ContractorDTO o) {
        if (id != null) {
            return id.compareTo(o.getId());
        }
        return 0;
    }

    @Override
    public String toString() {
        return name;
    }

}
