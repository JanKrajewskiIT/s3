package pl.lodz.p.project.core.domain.contractor;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import pl.lodz.p.project.core.domain.base.NamedEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;

/**
 *
 * @author Janiu
 */
@Entity
@Table(name = "contractors")
public class Contractor extends NamedEntity<Long> {
    
    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "symbol")    
    private String symbol;

	@Embedded
	private Address address;
    
    @Size(min = 0, max = 13)    
    @Column(name = "nip") 
    private String nip;
    
    @Column(name = "discount") 
    private Double discount = 0d;

    @Size(min = 0, max = 50)
    @Column(name = "account_number")
    private String accountNumber;

    @Size(max = 60)
    @Column(name = "website")
    private String website;

	@Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Invalid email")
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 40)
	private String email;

    @Column(name = "description") 
    private String description;
    
    @Size(max = 70)
    @Column(name = "representative")
    private String representative;
    
    @Column(name = "is_supplier")
    private Boolean supplier;
    
    @Column(name = "is_company")
    private Boolean company;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contractor")
    private Collection<ContractorContact> contractorsContactsCollection;
    
    @JoinColumn(name = "contractor_group_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ContractorGroup group;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
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
		return supplier;
	}

	public void setSupplier(Boolean supplier) {
		this.supplier = supplier;
	}

	public Boolean isCompany() {
		return company;
	}

	public void setCompany(Boolean company) {
		this.company = company;
	}

	public Collection<ContractorContact> getContractorsContactsCollection() {
		return contractorsContactsCollection;
	}

	public void setContractorsContactsCollection(Collection<ContractorContact> contractorsContactsCollection) {
		this.contractorsContactsCollection = contractorsContactsCollection;
	}

	public ContractorGroup getGroup() {
		return group;
	}

	public void setGroup(ContractorGroup group) {
		this.group = group;
	}
	/*
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

*/
}
