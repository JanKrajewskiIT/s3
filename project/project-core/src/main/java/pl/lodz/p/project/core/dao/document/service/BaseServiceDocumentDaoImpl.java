package pl.lodz.p.project.core.dao.document.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.lodz.p.project.core.domain.document.service.ServiceDocument;
import pl.lodz.p.project.core.domain.document.service.ServiceDocumentState;
import pl.lodz.p.project.core.domain.document.service.ServiceDocumentType;
import pl.lodz.p.project.core.dto.account.UserDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by milczu on 20.01.15.
 */
@Repository
@Transactional
public class BaseServiceDocumentDaoImpl implements BaseServiceDocumentDao {

    private static final ServiceDocumentRowMapper SERVICE_DOCUMENT_ROW_MAPPER = new ServiceDocumentRowMapper();

    @Autowired
    private JdbcOperations jdbcOperations;

    @Override
    public List<ServiceDocument> findAll() {
        return jdbcOperations.query("SELECT * from service_repair_orders", SERVICE_DOCUMENT_ROW_MAPPER);
    }
}

class ServiceDocumentRowMapper implements RowMapper<ServiceDocument> {

    @Override
    public ServiceDocument mapRow(final ResultSet rs, int i) throws SQLException {
        final String symbol = rs.getString("symbol");
        final String type = rs.getString("type");
        final Date documentDate = rs.getDate("document_date");
        final String strServiceDocumentType = rs.getString("service_document_type");
        final String strState = rs.getString("state");
        final Long id = rs.getLong("id");


        return new ServiceDocument() {
            @Override
            public Long getId() {
                return id;
            }

            @Override
            public String getSymbol() {
                return symbol;
            }

            @Override
            public String getType() {
                return type;
            }

            @Override
            public Date getDocumentDate() {
                return documentDate;
            }

            @Override
            public UserDTO getIssuePerson() {
                // TODO
                UserDTO user = new UserDTO();
                user.setId(1L);
                user.setFirstName("Admin");
                user.setSecondName("Admiński");
                return user;
            }

            @Override
            public ServiceDocumentType getServiceDocumentType() {
                return ServiceDocumentType.valueOf(strServiceDocumentType);
            }

            @Override
            public ServiceDocumentState getState() {
                return ServiceDocumentState.valueOf(strState);
            }
        };
    }
}
