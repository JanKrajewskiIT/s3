package pl.lodz.p.project.core.jsf.documents.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import pl.lodz.p.project.core.domain.document.service.BaseDocumentService;
import pl.lodz.p.project.core.domain.document.service.ServiceDocumentState;
import pl.lodz.p.project.core.dto.account.UserDTO;
import pl.lodz.p.project.core.dto.document.service.BaseServiceDocumentDTO;
import pl.lodz.p.project.core.jsf.base.Action;
import pl.lodz.p.project.core.jsf.base.GUI;
import pl.lodz.p.project.core.jsf.base.Mode;
import pl.lodz.p.project.core.jsf.config.ConstantElements;
import pl.lodz.p.project.core.service.document.service.BaseService;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by milczu on 28.01.15.
 */
public abstract class AbstractServiceTemplateBean<T extends BaseServiceDocumentDTO, E extends BaseDocumentService, S extends BaseService<E, T>> {

    private static final String SERVICE_DOCUMENTS_TABLE_VIEW_URI = "/documents/service/serviceDocumentsTable";

    @Autowired
    private S service;

    private Mode mode;
    private T document;
    private String issuePerson;

    private final Action clearAction = new Action("Wyczyść", "@form") {
        @Override
        public void call() {
            clear();
        }
    };

    private final Action saveAction = new Action("Zapisz") {
        @Override
        public void call() {
            save();
        }
    };

    private final Action markDocumentAsInProgressAction = new Action("Rozpocznij") {
        @Override
        public void call() {
            markDocumentAsInProgress();
        }
    };

    private final Action markDocumentAsDoneAction = new Action("Zakończ") {
        @Override
        public void call() {
            markDocumentAsDone();
        }
    };

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

    public String save() {
        service.save(document);
        return GUI.redirect(SERVICE_DOCUMENTS_TABLE_VIEW_URI);
    }

    public String markDocumentAsInProgress() {
        service.markDocumentAsInProgress(document.getId());
        return GUI.redirect(SERVICE_DOCUMENTS_TABLE_VIEW_URI);
    }

    public String markDocumentAsDone() {
        service.markDocumentAsDone(document.getId());
        return GUI.redirect(SERVICE_DOCUMENTS_TABLE_VIEW_URI);
    }

    public T getDocument() {
        return document;
    }

    public void setDocument(T document) {
        this.document = document;
    }

    public List<Action> getActions() {
        List<Action> actions = new ArrayList<>();
        actions.add(clearAction);
        actions.add(saveAction);
        if (ServiceDocumentState.NEW == document.getState() && mode == Mode.EDIT) {
            actions.add(markDocumentAsInProgressAction);
        }
        if (ServiceDocumentState.IN_PROGRESS == document.getState()) {
            actions.add(markDocumentAsDoneAction);
        }
        return actions;
    }

    protected Mode getMode() {
        return mode;
    }
}
