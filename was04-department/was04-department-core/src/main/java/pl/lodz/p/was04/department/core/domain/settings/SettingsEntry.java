package pl.lodz.p.was04.department.core.domain.settings;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import pl.lodz.p.was04.department.core.dto.setting.SettingsPropertyType;

/**
 *
 * @author Milczu
 */
@Entity
@Table(name = "settings")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = SettingsEntry.QUERY_FIND_BY_KEY, query = "SELECT s FROM SettingsEntry s WHERE s.propertyKey = :propertyKey and s.type = :type")})
public class SettingsEntry implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String QUERY_FIND_BY_KEY = "SettingsEntry.findByKey";
    public static final String QUERY_UPDATE_SCALAR = "SettingsEntry.updateScalar";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "property_key")
    private String propertyKey;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private SettingsPropertyType type;

    @Column(name = "key")
    private String key;

    @Column(name = "value")
    private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPropertyKey() {
        return propertyKey;
    }

    public void setPropertyKey(String propertyKey) {
        this.propertyKey = propertyKey;
    }

    public SettingsPropertyType getType() {
        return type;
    }

    public void setType(SettingsPropertyType type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object object) {
        return EqualsBuilder.reflectionEquals(this, object);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
