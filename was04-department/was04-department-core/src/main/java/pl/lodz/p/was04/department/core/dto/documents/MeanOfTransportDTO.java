package pl.lodz.p.was04.department.core.dto.documents;

import java.io.Serializable;

import pl.lodz.p.was04.department.core.domain.documents.MeanOfTransport;

/**
 *
 * @author janiu
 */
public class MeanOfTransportDTO implements Serializable, Comparable<MeanOfTransportDTO> {

	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String transportName;

    public MeanOfTransportDTO(MeanOfTransport meanOfTransport) {
        this.id = meanOfTransport.getId();
        this.transportName = meanOfTransport.getTransportName();
    }

    MeanOfTransportDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransportName() {
        return transportName;
    }

    public void setTransportName(String transportName) {
        this.transportName = transportName;
    }

    @Override
    public int compareTo(MeanOfTransportDTO o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
