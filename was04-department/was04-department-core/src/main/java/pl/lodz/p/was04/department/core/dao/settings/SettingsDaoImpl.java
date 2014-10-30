package pl.lodz.p.was04.department.core.dao.settings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.lodz.p.was04.department.core.domain.settings.SettingsEntry;
import pl.lodz.p.was04.department.core.dto.setting.SettingsPropertyType;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

/**
 *
 * @author Milczu
 */
@Repository
@Transactional
public class SettingsDaoImpl implements SettingsDao {

    private final SettingsEntryToValueTransformer settingsEntryToValueTransformer = new SettingsEntryToValueTransformer();

    @PersistenceContext
    private EntityManager entityManager;

	@Override
	@Transactional(readOnly = true)
    public String findScalar(String propertyKey) {
        SettingsEntry settingsEntry = createFindQuery(propertyKey, SettingsPropertyType.SCALAR).getSingleResult();
        return settingsEntryToValueTransformer.apply(settingsEntry);
    }

	@Override
	@Transactional(readOnly = true)
    public List<String> findList(String propertyKey) {
        List<SettingsEntry> settingsEntries = createFindQuery(propertyKey, SettingsPropertyType.LIST).getResultList();
        return Lists.transform(settingsEntries, settingsEntryToValueTransformer);
    }

	@Override
	@Transactional(readOnly = true)
    public Map<String, String> findMap(String propertyKey) {
        List<SettingsEntry> settingsEntries = createFindQuery(propertyKey, SettingsPropertyType.MAP).getResultList();
        Map<String, String> map = new HashMap<>();
        for(SettingsEntry settingsEntry : settingsEntries) {
            map.put(settingsEntry.getKey(), settingsEntry.getValue());
        }
        return map;
    }

	@Transactional(readOnly = true)
    private TypedQuery<SettingsEntry> createFindQuery(String propertyKey, SettingsPropertyType type) {
        return entityManager.createNamedQuery(SettingsEntry.QUERY_FIND_BY_KEY, SettingsEntry.class).setParameter("propertyKey", propertyKey).setParameter("type", type);
    }

	@Override
	@Transactional(readOnly = true)
    public void updateScalarProperty(String propertyKey, String value) {
    	/* TODO CriteriaBuilder critBuilder = em.getCriteriaBuilder();
        CriteriaUpdate<SettingsEntry> criteriaUpdate = critBuilder.createCriteriaUpdate(SettingsEntry.class);
        Root<SettingsEntry> root = criteriaUpdate.from(SettingsEntry.class);
        criteriaUpdate.set("value", value);
        criteriaUpdate.where(critBuilder.equal(root.get("propertyKey"), propertyKey));
        em.createQuery(criteriaUpdate).executeUpdate(); */
    }
}

class SettingsEntryToValueTransformer implements Function<SettingsEntry, String> {

    @Override
    public String apply(SettingsEntry input) {
        return input == null ? null : input.getValue();
    }

}
