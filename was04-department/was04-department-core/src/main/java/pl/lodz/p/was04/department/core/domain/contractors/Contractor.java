package pl.lodz.p.was04.department.core.domain.contractors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import pl.lodz.p.was04.department.core.domain.Activable;
import pl.lodz.p.was04.department.core.dto.contractors.ContractorDTO;

/**
 *
 * @author Janiu, milczu
 */
@Entity
@Table(name = "contractors")
public class Contractor implements Serializable, Activable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contractor_id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "symbol")
    private String symbol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "postcode")
    private String postcode;
    @Size(min = 1, max = 40)
    private String city;
    @Size(min = 0, max = 60)
    private String adress;
    @Size(min = 0, max = 13)
    private String nip;
    private BigDecimal discount = BigDecimal.ZERO;
    @Size(min = 0, max = 50)
    @Column(name = "account_number")
    private String accountNumber;
    @Size(max = 60)
    private String website;
    @Size(max = 60)
    private String email;
    private String description;
    @Size(max = 70)
    @Column(name = "representative")
    private String representative;
    @Column(name = "is_supplier")
    private Boolean isSupplier;
    @Column(name = "is_company")
    private Boolean isCompany;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contractor")
    private Collection<ContractorContact> contractorsContactsCollection;
    @JoinColumn(name = "contractor_group_id", referencedColumnName = "contractor_group_id")
    @ManyToOne(optional = false)
    private ContractorGroup contractorGroup;
    
    @Column(name = "is_active")
    private boolean active = true;
    
    @Version
    private Long version = 1L;

    public Contractor() {
    }

    public Contractor(Long id) {
        this.id = id;
    }

    public Contractor(ContractorDTO contractorDTO) {
        this.id = contractorDTO.getId();
        this.symbol = contractorDTO.getSymbol();
        this.name = contractorDTO.getName();
        this.postcode = contractorDTO.getPostCode();
        this.city = contractorDTO.getCity();
        this.adress = contractorDTO.getAdress();
        this.nip = contractorDTO.getNip();
        this.discount = contractorDTO.getDiscount();
        this.accountNumber = contractorDTO.getAccountNumber();
        this.website = contractorDTO.getWebsite();
        this.email = contractorDTO.getEmail();
        this.description = contractorDTO.getDescription();
        this.representative = contractorDTO.getRepresentative();
        this.active = contractorDTO.isActive();
        this.version = contractorDTO.getVersion();
        this.contractorGroup = new ContractorGroup(contractorDTO.getGroup());
        this.isCompany = contractorDTO.getContractorType().equals("Firma");
        this.isSupplier = contractorDTO.getRoleType().equals("Dostawca");         
    }

    @Override
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

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
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

    public Boolean isSupplier() {
        return isSupplier;
    }

    public void setSupplier(Boolean isSupplier) {
        this.isSupplier = isSupplier;
    }

    public Boolean isCompany() {
        return isCompany;
    }

    public void setCompany(Boolean isCompany) {
        this.isCompany = isCompany;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean isActive) {
        this.active = isActive;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public ContractorGroup getContractorGroup() {
        return contractorGroup;
    }

    public void setContractorGroup(ContractorGroup contractorGroup) {
        this.contractorGroup = contractorGroup;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contractor)) {
            return false;
        }
        Contractor other = (Contractor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.lodz.p.was04.headoffice.entity.contractors.Contractors[ id=" + id + " ]";
    }

    public Collection<ContractorContact> getContractorsContactsCollection() {
        return contractorsContactsCollection;
    }

    public void setContractorsContactsCollection(Collection<ContractorContact> contractorsContactsCollection) {
        this.contractorsContactsCollection = contractorsContactsCollection;
    }

	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return false;
	}

}
