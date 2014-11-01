package pl.lodz.p.project.core.jsf.settings;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import pl.lodz.p.project.core.dto.document.PaymentMethodDTO;
import pl.lodz.p.project.core.service.document.DocumentNumeratorService;
import pl.lodz.p.project.core.service.document.DocumentSettingsService;
import pl.lodz.p.project.core.service.document.PaymentMethodsService;

/**
 *
 * @author milczu
 */
@Named(value = "settingsDocumentsPageBean")
@Scope("request")
public class SettingsDocumentsPageBean implements Serializable {
 
	private static final long serialVersionUID = 1L;

	@Autowired
    private DocumentNumeratorService documentNumeratorEndpoint;
    
    @Autowired
    private PaymentMethodsService paymentMethodsManagentEndpoint;
    
    @Autowired
    private DocumentSettingsService documentSettingsEnpoint;
    
    private String currentDocumentSymbolFormat;
    private String documentFormatSelection;
    private List<String> availableDocumentsSymbolFormats;
    
    private List<PaymentMethodDTO> paymentMethods;
    private PaymentMethodDTO newPaymentMethod = new PaymentMethodDTO();
    
    private String currentDefaultDocumentPlace;
    private String newDefaultDocumentPlace;

    @PostConstruct
    public void init() {
        currentDocumentSymbolFormat = documentNumeratorEndpoint.currentFormat();
        availableDocumentsSymbolFormats = documentNumeratorEndpoint.availableFormats();
        currentDefaultDocumentPlace = documentSettingsEnpoint.findDefaultDocumentPlace();
        documentFormatSelection = currentDocumentSymbolFormat == null ? StringUtils.EMPTY : currentDocumentSymbolFormat;
        newDefaultDocumentPlace = currentDefaultDocumentPlace == null ? StringUtils.EMPTY : currentDefaultDocumentPlace;
        loadPaymentMethods();
    }
    
    private void loadPaymentMethods() {
        paymentMethods = paymentMethodsManagentEndpoint.getPaymentMethods();
    }
    
    public String getCurrentDocumentSymbolFormat() {
        System.out.println("current: " + currentDocumentSymbolFormat);
        return currentDocumentSymbolFormat;
    }

    public List<String> getAvailableDocumentsSymbolFormats() {
        System.out.println("available: " + availableDocumentsSymbolFormats);
        return availableDocumentsSymbolFormats;
    }
    
    public List<PaymentMethodDTO> getPaymentMethods() {
        return paymentMethods;
    }

    public PaymentMethodDTO getNewPaymentMethod() {
        return newPaymentMethod;
    }
    
    public void onPaymentMethodEdit(RowEditEvent event) {
        PaymentMethodDTO editedPaymentMethod = (PaymentMethodDTO) event.getObject();
        paymentMethodsManagentEndpoint.edit(editedPaymentMethod);
        loadPaymentMethods();

        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Zapisano metodę płatności: ", editedPaymentMethod.getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void removePaymentMethod(PaymentMethodDTO paymentMethod) {
        paymentMethodsManagentEndpoint.remove(paymentMethod);
        loadPaymentMethods();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usunięto metodę płatności: ", paymentMethod.getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void saveNewPaymentMethod() {
        System.out.println("Zapisz: " + newPaymentMethod);
        paymentMethodsManagentEndpoint.add(newPaymentMethod);
        loadPaymentMethods();
        newPaymentMethod = new PaymentMethodDTO();
    }

    public String getDocumentFormatSelection() {
        return documentFormatSelection;
    }

    public void saveDocumentSymbolFormat(String newDocumentSymbolFormat) {
        System.out.println("Zapisz format numeracji: " + newDocumentSymbolFormat);
        documentNumeratorEndpoint.updateDocumentFormat(newDocumentSymbolFormat);
        currentDocumentSymbolFormat = newDocumentSymbolFormat;
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Zapisano", null);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public String getCurrentDefaultDocumentPlace() {
        return currentDefaultDocumentPlace;
    }

    public String getNewDefaultDocumentPlace() {
        return newDefaultDocumentPlace;
    }
    
    public void saveDocumentDefaultPlace(String newDocumentDefaultPlace) {
        System.out.println("Zapisz nowe miejsce wystawienia: " + newDocumentDefaultPlace);
        documentSettingsEnpoint.updateDefaultDocumentPlace(newDocumentDefaultPlace);
        currentDefaultDocumentPlace = newDocumentDefaultPlace;
    }

    public void setDocumentFormatSelection(String documentFormatSelection) {
        this.documentFormatSelection = documentFormatSelection;
    }

    public void setNewDefaultDocumentPlace(String newDefaultDocumentPlace) {
        this.newDefaultDocumentPlace = newDefaultDocumentPlace;
    }
}
