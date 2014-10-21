package pl.lodz.p.was04.department.core.jsf.primefaces;

import java.io.IOException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.roweditor.RowEditorRenderer;

public class BootstrapRowEditorRenderer extends RowEditorRenderer {
    
    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();

        writer.startElement("div", null);
        writer.writeAttribute("id", component.getClientId(context), null);
        writer.writeAttribute("class", DataTable.ROW_EDITOR_CLASS, null);

        // Edit
        writer.startElement("a", null);
        writer.writeAttribute("class", "ui-icon-pencil btn btn-success btn-xs", null);
        writer.writeAttribute("href", "#", null);
        
        writer.startElement("i", null);
        writer.writeAttribute("class", "glyphicon glyphicon-pencil", null);
        writer.endElement("i");
        writer.append(" ");
        writer.writeText("Edytuj", null);
        
        writer.endElement("a");

        // Save
        writer.startElement("a", null);
        writer.writeAttribute("class", "ui-icon-check btn btn-success btn-xs", null);
        writer.writeAttribute("href", "#", null);
        
        writer.startElement("i", null);
        writer.writeAttribute("class", "glyphicon glyphicon-ok", null);
        writer.endElement("i");
        writer.append(" ");
        writer.writeText("Zapisz", null);

        writer.endElement("a");

        // Cancel
        writer.startElement("a", null);
        writer.writeAttribute("class", "ui-icon-close btn btn-warning btn-xs", null);
        writer.writeAttribute("href", "#", null);
        
        writer.startElement("i", null);
        writer.writeAttribute("class", "glyphicon glyphicon-remove", null);
        writer.endElement("i");
        writer.append(" ");
        writer.writeText("Anuluj", null);

        writer.endElement("a");

        
        writer.endElement("div");
    }
}
