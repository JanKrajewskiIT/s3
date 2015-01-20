package pl.lodz.p.project.core.dto.document.service;

import com.google.common.collect.ComparisonChain;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import pl.lodz.p.project.core.domain.document.service.ServiceDocument;
import pl.lodz.p.project.core.domain.document.service.ServiceDocumentState;
import pl.lodz.p.project.core.domain.document.service.ServiceDocumentType;
import pl.lodz.p.project.core.dto.document.base.DocumentDTO;

public class BaseServiceDocumentDTO extends DocumentDTO<Long> implements ServiceDocument, Comparable<BaseServiceDocumentDTO> {

    private final ServiceDocumentType serviceDocumentType;
    private ServiceDocumentState state;

    public BaseServiceDocumentDTO(ServiceDocumentType serviceDocumentType) {
        this.serviceDocumentType = serviceDocumentType;
    }

    public ServiceDocumentType getServiceDocumentType() {
        return serviceDocumentType;
    }

    public ServiceDocumentState getState() {
        return state;
    }

    public void setState(ServiceDocumentState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    @Override
    public int compareTo(BaseServiceDocumentDTO o) {
        return ComparisonChain.start().compare(this.getId(), o.getId()).result();
    }

}
