package pl.lodz.p.project.core.jsf.documents.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import pl.lodz.p.project.core.domain.document.service.BaseDocumentService;
import pl.lodz.p.project.core.dto.account.UserDTO;
import pl.lodz.p.project.core.dto.document.service.BaseServiceDocumentDTO;
import pl.lodz.p.project.core.jsf.base.GUI;
import pl.lodz.p.project.core.jsf.base.Mode;
import pl.lodz.p.project.core.jsf.config.ConstantElements;
import pl.lodz.p.project.core.service.base.ServiceRepository;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

/**
 * Created by milczu on 28.01.15.
 */
public abstract class AbstractServiceTemplateBean<T extends BaseServiceDocumentDTO, E extends BaseDocumentService, S extends ServiceRepository<E, T>> {

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
        return GUI.redirect("/documents/service/serviceDocumentsTable");
    }

    public T getDocument() {
        return document;
    }

    public void setDocument(T document) {
        this.document = document;
    }
}
