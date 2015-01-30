package pl.lodz.p.project.core.jsf.base;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Jan Krajewski
 */
public class DateUtil {

    private static DateFormat VIEW_FORMAT = new SimpleDateFormat("DD/MM/YYYY");

    public static String getCurrentDateValue() {
        return VIEW_FORMAT.format(getCurrentDate());
    }

    public static Date getCurrentDate() {
        return new Date();
    }
}
