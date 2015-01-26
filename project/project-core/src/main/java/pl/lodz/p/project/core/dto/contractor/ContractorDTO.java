package pl.lodz.p.project.core.dto.contractor;

import com.google.common.collect.ComparisonChain;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import pl.lodz.p.project.core.dto.base.NamedDTO;

/**
 *
 * @author Janiu
 */
public class ContractorDTO extends NamedDTO<Long> implements Comparable<ContractorDTO> {

	private static final long serialVersionUID = 1L;

    private String symbol;
    private String type;
    private String role;
    private AddressDTO address = new AddressDTO();
    private String nip;
    private Double discount = 0d;
    private String accountNumber;
    private String website;
    private String email;
    private String phone;
    private String description;
    private String representative;
    private ContractorGroupDTO group;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public ContractorGroupDTO getGroup() {
        return group;
    }

    public void setGroup(ContractorGroupDTO group) {
        this.group = group;
    }

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@Override
	public int compareTo(ContractorDTO o) {
		return ComparisonChain.start().compare(this.getId(), o.getId()).result();
	}

}
