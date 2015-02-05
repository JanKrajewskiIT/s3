package pl.lodz.p.project.core.jsf.documents.service.action;

import org.slf4j.LoggerFactory;
import pl.lodz.p.project.core.jsf.base.Action;

/**
 * Created by milczu on 05.02.15.
 */
public class CreateProductsRequestFromServiceDocumentAction extends Action {

    private final ProductsRequestCreatable productsRequestCreatable;

    public CreateProductsRequestFromServiceDocumentAction(ProductsRequestCreatable productsRequestCreatable) {
        super("Stwórz zapotrzebowanie serwisowe");
        this.productsRequestCreatable = productsRequestCreatable;
    }

    @Override
    public void call() {
        productsRequestCreatable.createProductsRequest();
    }
}
