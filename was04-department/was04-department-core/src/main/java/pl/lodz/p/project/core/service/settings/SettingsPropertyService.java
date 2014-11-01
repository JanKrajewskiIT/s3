package pl.lodz.p.project.core.service.settings;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Milczu
 */
public interface SettingsPropertyService {

    String findScalarProperty(String propertyKey);

    Integer findScalarIntegerProperty(String propertyKey);

    Double findScalarDoubleProperty(String propertyKey);

    List<String> findListProperty(String propertyKey);

    Map<String, String> findMapProperty(String propertyKey);
    
    void editScalarProperty(String propertyKey, String value);
}
