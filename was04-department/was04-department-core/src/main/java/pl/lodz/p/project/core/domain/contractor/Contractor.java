package pl.lodz.p.project.core.domain.contractor;

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

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import pl.lodz.p.project.core.domain.Activable;

/**
 *
 * @author Janiu
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
        
    @Size(min = 1, max = 40)    
    @Column(name = "city") 
    private String city;
    
    @Size(min = 0, max = 60)  
    @Column(name = "adress")   
    private String adress;
    
    @Size(min = 0, max = 13)    
    @Column(name = "nip") 
    private String nip;
    
    @Column(name = "discount") 
    private BigDecimal discount = BigDecimal.ZERO;

    @Size(min = 0, max = 50)
    @Column(name = "account_number")
    private String accountNumber;
    
    @Size(max = 60)
    @Column(name = "website") 
    private String website;
    
    @Size(max = 60)
    @Column(name = "email") 
    private String email;

    @Column(name = "description") 
    private String description;
    
    @Size(max = 70)
    @Column(name = "representative")
    private String representative;
    
    @Column(name = "is_supplier")
    private boolean supplier;
    
    @Column(name = "is_company")
    private boolean company;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contractor")
    private Collection<ContractorContact> contractorsContactsCollection;
    
    @JoinColumn(name = "contractor_group_id", referencedColumnName = "contractor_group_id")
    @ManyToOne(optional = false)
    private ContractorGroup group;
    
    @JoinColumn(name = "postal_code_id", referencedColumnName = "postal_code_id")
    @ManyToOne(optional = false)
    private PostalCode postalCode;    

	@Basic(optional = false)
	@NotNull    
    @Column(name = "is_active")
    private boolean active = true;
    
    @Version
    private Long version = 1L;
    
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

	public PostalCode getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(PostalCode postalCode) {
		this.postalCode = postalCode;
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

	public boolean isSupplier() {
		return supplier;
	}

	public void setSupplier(boolean supplier) {
		this.supplier = supplier;
	}

	public boolean isCompany() {
		return company;
	}

	public void setCompany(boolean company) {
		this.company = company;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Collection<ContractorContact> getContractorsContactsCollection() {
		return contractorsContactsCollection;
	}

	public void setContractorsContactsCollection(
			Collection<ContractorContact> contractorsContactsCollection) {
		this.contractorsContactsCollection = contractorsContactsCollection;
	}

	public ContractorGroup getGroup() {
		return group;
	}

	public void setGroup(ContractorGroup group) {
		this.group = group;
	}
	
    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object object) {
        return EqualsBuilder.reflectionEquals(this, object);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@Override
	public boolean isNew() {
		return id == null;
	}

}
