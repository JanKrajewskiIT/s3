package pl.lodz.p.was04.department.core.dao.settings;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Milczu
 */
public interface SettingsDao {

    String findScalar(String propertyKey);
    
    List<String> findList(String propertyKey);
    
    Map<String, String> findMap(String propertyKey);
    
    void updateScalarProperty(String propertyKey, String value);
}
