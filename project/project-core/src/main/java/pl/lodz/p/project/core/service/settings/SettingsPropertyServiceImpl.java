package pl.lodz.p.project.core.service.settings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.lodz.p.project.core.dao.settings.SettingsDao;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Milczu
 */
@Component
public class SettingsPropertyServiceImpl implements SettingsPropertyService {

    @Autowired
    private SettingsDao settingsDao;
    
    @Override
    public String findScalarProperty(String propertyKey) {
        return settingsDao.findScalar(propertyKey);
    }

    @Override
    public Integer findScalarIntegerProperty(String propertyKey) {
        String stringValue = findScalarProperty(propertyKey);
        return stringValue == null ? null : Integer.parseInt(stringValue);
    }

    @Override
    public Double findScalarDoubleProperty(String propertyKey) {
        String stringValue = findScalarProperty(propertyKey);
        return stringValue == null ? null : Double.parseDouble(stringValue);
    }

    @Override
    public List<String> findListProperty(String propertyKey) {
        return settingsDao.findList(propertyKey);
    }

    @Override
    public Map<String, String> findMapProperty(String propertyKey) {
        return settingsDao.findMap(propertyKey);
    }

    @Override
    public void editScalarProperty(String propertyKey, String value) {
        settingsDao.updateScalarProperty(propertyKey, value);
    }
    
}
