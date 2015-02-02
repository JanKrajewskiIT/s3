package pl.lodz.p.project.core.jsf.documents.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import pl.lodz.p.project.core.domain.document.service.BaseDocumentService;
import pl.lodz.p.project.core.domain.document.service.ServiceDocumentState;
import pl.lodz.p.project.core.dto.account.UserDTO;
import pl.lodz.p.project.core.dto.document.service.BaseServiceDocumentDTO;
import pl.lodz.p.project.core.jsf.base.Action;
import pl.lodz.p.project.core.jsf.base.ClearAction;
import pl.lodz.p.project.core.jsf.base.ClearableForm;
import pl.lodz.p.project.core.jsf.base.GUI;
import pl.lodz.p.project.core.jsf.base.Mode;
import pl.lodz.p.project.core.jsf.base.SaveAction;
import pl.lodz.p.project.core.jsf.base.SaveableForm;
import pl.lodz.p.project.core.jsf.config.ConstantElements;
import pl.lodz.p.project.core.jsf.documents.service.action.DocumentStateChangeable;
import pl.lodz.p.project.core.jsf.documents.service.action.MarkDocumentAsInDoneAction;
import pl.lodz.p.project.core.jsf.documents.service.action.MarkDocumentAsInProgressAction;
import pl.lodz.p.project.core.service.document.service.BaseService;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by milczu on 28.01.15.
 */
public abstract class AbstractServiceTemplateBean<T extends BaseServiceDocumentDTO, E extends BaseDocumentService, S extends BaseService<E, T>> implements ClearableForm, SaveableForm, DocumentStateChangeable {

    private static final String SERVICE_DOCUMENTS_TABLE_VIEW_URI = "/documents/service/serviceDocumentsTable";

    @Autowired
    private S service;

    private Mode mode;
    private T document;
    private String issuePerson;

    @Autowired
    private ConstantElements constantElements;

    @PostConstruct
    public void init() {
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        if (StringUtils.isBlank(id)) {
            mode = Mode.CREATE;
            document = createNew();
        } else {
            mode = Mode.EDIT;
            document = service.getOneById(Long.parseLong(id));
        }
        issuePerson = document.getIssuePerson() == null ? null : document.getIssuePerson().getFirstName() + " " + document.getIssuePerson().getSecondName();
    }

    @Override
    public void clear() {
        document = createNew();
    }

    protected abstract T createNew();

    protected UserDTO currentUser() {
        return constantElements.getUser();
    }

    public String getIssuePerson() {
        return issuePerson;
    }

    @Override
    public void save() {
        service.save(document);
        GUI.redirect(SERVICE_DOCUMENTS_TABLE_VIEW_URI);
    }

    @Override
    public void markDocumentAsInProgress() {
        service.markDocumentAsInProgress(document.getId());
        GUI.redirect(SERVICE_DOCUMENTS_TABLE_VIEW_URI);
    }

    @Override
    public void markDocumentAsDone() {
        service.markDocumentAsDone(document.getId());
        GUI.redirect(SERVICE_DOCUMENTS_TABLE_VIEW_URI);
    }

    public T getDocument() {
        return document;
    }

    public void setDocument(T document) {
        this.document = document;
    }

    public List<Action> getActions() {
        List<Action> actions = new ArrayList<>();
        actions.add(new SaveAction(this));
        actions.add(new ClearAction(this));
        if (ServiceDocumentState.NEW == document.getState() && mode == Mode.EDIT) {
            actions.add(new MarkDocumentAsInProgressAction(this));
        } else if (ServiceDocumentState.IN_PROGRESS == document.getState()) {
            actions.add(new MarkDocumentAsInDoneAction(this));
        }
        return actions;
    }

    protected Mode getMode() {
        return mode;
    }
}
