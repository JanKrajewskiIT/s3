package pl.lodz.p.was04.department.core.manager.settings;

import java.util.List;
import java.util.Map;

/**
 *
 * @author milczu
 */
public interface SettingsPropertyManagerLocal {

    String findScalarProperty(String propertyKey);

    Integer findScalarIntegerProperty(String propertyKey);

    Double findScalarDoubleProperty(String propertyKey);

    List<String> findListProperty(String propertyKey);

    Map<String, String> findMapProperty(String propertyKey);
    
    void editScalarProperty(String propertyKey, String value);
}
