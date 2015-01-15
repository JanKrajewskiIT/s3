package pl.lodz.p.project.core.domain.document.base;

import pl.lodz.p.project.core.domain.account.User;
import pl.lodz.p.project.core.domain.base.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Jan Krajewski
 */
@MappedSuperclass
public class Document<T extends Serializable> extends BaseEntity<T> {

    private static final long serialVersionUID = 1469119918669875184L;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "symbol")
    private String symbol;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "type")
    private String type;

    @Basic(optional = false)
    @NotNull
    @Column(name = "document_date")
    @Temporal(TemporalType.DATE)
    private Date documentDate;

    @NotNull
    @JoinColumn(name = "issue_person", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User issuePerson;

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

    public User getIssuePerson() {
        return issuePerson;
    }

    public void setIssuePerson(User issuePerson) {
        this.issuePerson = issuePerson;
    }

}
