package pl.lodz.p.project.core.dto.document.base;

import pl.lodz.p.project.core.dto.account.UserDTO;
import pl.lodz.p.project.core.dto.base.BaseDTO;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Jan Krajewski
 */
public abstract class DocumentDTO<T extends Serializable> extends BaseDTO<T> {

    private String symbol;
    private String type;
    private Date documentDate;
    private UserDTO issuePerson;

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

    public Date getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(Date documentDate) {
        this.documentDate = documentDate;
    }

    public UserDTO getIssuePerson() {
        return issuePerson;
    }

    public void setIssuePerson(UserDTO issuePerson) {
        this.issuePerson = issuePerson;
    }

}
