package pl.lodz.p.project.core.jsf.contractor;

import org.springframework.beans.factory.annotation.Autowired;
import pl.lodz.p.project.core.dto.contractor.PostalCodeDTO;
import pl.lodz.p.project.core.service.contractor.PostalCodeService;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by janiu on 26.01.15.
 */
@Named
@ViewScoped
public class PostalCodeListController implements Serializable {

    @Autowired
    private PostalCodeService service;

    private List<PostalCodeDTO> items;

    @PostConstruct
    private void init() {
        items = service.getAll();
    }

    public PostalCodeDTO retrievePostalCode(String code) {
        for(PostalCodeDTO postalCode : items) {
            if(postalCode.getCode().equals(code)) {
                return postalCode;
            }
        }
        return null;
    }

    public List<PostalCodeDTO> getItems() {
        return items;
    }

    public void setItems(List<PostalCodeDTO> items) {
        this.items = items;
    }
}
