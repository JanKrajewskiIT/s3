package pl.lodz.p.project.core.dto.document.base;

import java.util.Arrays;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;

import pl.lodz.p.project.core.dto.document.base.DocumentFormat.DocumentFormatItem;

/**
 *
 * @author Milczu
 */
public class DocumentSymbolBuilder {

    public DocumentSymbolBuilder() {
        DateTimeZone.setDefault(DateTimeZone.forID("CET")); // TODO move to better place
    }

    public String buildFirst(String documentType, DocumentFormat documentFormat) {
        return buildSymbolWithNumber(1L, documentType, documentFormat);
    }

    protected String buildSymbolWithNumber(long number, String documentType, DocumentFormat documentFormat) {
        DateTime now = DateTime.now();
        String[] documentFortmatPatternItems = documentFormat.getPattern().split("/");

        StringBuilder symbolBuilder = new StringBuilder();
        for (String documentFormatItem : documentFortmatPatternItems) {
            symbolBuilder.append("/");
            if (documentFormatItem.equals(DocumentFormatItem.PREFIKS.toString())) {
                symbolBuilder.append(documentType);
            } else if (documentFormatItem.equals(DocumentFormatItem.NR.toString())) {
                symbolBuilder.append(number);
            } else if(documentFormatItem.equals(DocumentFormatItem.MM.toString())) {
                symbolBuilder.append(String.format("%02d", now.get(DateTimeFieldType.monthOfYear())));
            } else if(documentFormatItem.equals(DocumentFormatItem.RRRR.toString())) {
                symbolBuilder.append(now.get(DateTimeFieldType.year()));
            }
        }

        return symbolBuilder.toString().substring(1);
    }

    /**
     *
     * @param previousSymbol must be in pattern given in documentFormat
     * @param documentType type of document
     * @param documentFormat document format
     * @return
     */
    public String buildNext(String previousSymbol, String documentType, DocumentFormat documentFormat) {
        if (hasActualDateValues(previousSymbol, documentFormat)) {
            // increment
            List<String> previousSymbolValues = Arrays.asList(previousSymbol.split("/"));
            List<String> patternElements = Arrays.asList(documentFormat.getPattern().split("/"));
            int indexOfNR = patternElements.indexOf(DocumentFormatItem.NR.toString());
            long previousNumber = Long.parseLong(previousSymbolValues.get(indexOfNR));
            
            return buildSymbolWithNumber(previousNumber+1, documentType, documentFormat);
        } else {
            return buildFirst(documentType, documentFormat);
        }
    }

    protected boolean hasActualDateValues(String previousSymbol, DocumentFormat documentFormat) {
        LocalDate today = LocalDate.now();

        List<String> previousSymbolValues = Arrays.asList(previousSymbol.split("/"));
        List<String> patternElements = Arrays.asList(documentFormat.getPattern().split("/"));
        if (documentFormat.isMonth()) {
            int indexOfMonth = patternElements.indexOf(DocumentFormatItem.MM.toString());
            int monthInPreviousSymbol = Integer.parseInt(previousSymbolValues.get(indexOfMonth));

            if (monthInPreviousSymbol != today.getMonthOfYear()) {
                return false;
            }
        }

        int indexOfYear = patternElements.indexOf(DocumentFormatItem.RRRR.toString());
        int yearInPreviousSymbol = Integer.parseInt(previousSymbolValues.get(indexOfYear));

        return yearInPreviousSymbol == today.getYear();
    }
}
