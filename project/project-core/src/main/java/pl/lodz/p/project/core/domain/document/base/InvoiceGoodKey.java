package pl.lodz.p.project.core.domain.document.base;

import pl.lodz.p.project.core.domain.good.Good;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import java.io.Serializable;

/**
 * @author Jan Krajewski
 */
@Embeddable
public class InvoiceGoodKey<T extends Document> implements Serializable {

    @ManyToOne
    @PrimaryKeyJoinColumn(name="INVOICE_ID", referencedColumnName="ID")
    private T invoice;

    @ManyToOne
    @PrimaryKeyJoinColumn(name="GOOD_ID", referencedColumnName="ID")
    private Good good;

    public T getInvoice() {
        return invoice;
    }

    public void setInvoice(T invoice) {
        this.invoice = invoice;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

}
