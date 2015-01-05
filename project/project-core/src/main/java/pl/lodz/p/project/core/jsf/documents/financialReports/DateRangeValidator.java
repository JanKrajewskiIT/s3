package pl.lodz.p.project.core.jsf.documents.financialReports;

import org.primefaces.component.inputtext.InputText;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.Date;

@FacesValidator("dateRangeValidator")
public class DateRangeValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value == null) {
            return;
        }

        //Leave the null handling of startDate to required="true"
        Object startDateValue = component.getAttributes().get("startDateComponent");
        if (startDateValue==null) {
            return;
        }

        Date startDate = (Date)((InputText)startDateValue).getValue();
        Date endDate = (Date)value;
        if (endDate.before(startDate)) {
            throw new ValidatorException(new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "Start date may not be after end date.", null));
        }
    }
}
