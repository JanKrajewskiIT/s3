package pl.lodz.p.was04.department.core.dto.documents;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import pl.lodz.p.was04.department.core.domain.documents.WarehouseDocument;
import pl.lodz.p.was04.department.core.dto.UserDTO;
import pl.lodz.p.was04.department.core.dto.contractors.ContractorDTO;

/**
 *
 * @author janiu
 */
public class WarehouseDocumentDTO implements Serializable, Comparable<WarehouseDocumentDTO> {

	private static final long serialVersionUID = 1L;
	
	private String symbol;
    private String type;
    private Date documentDate;
    private Date warehouseDate;
    private BigDecimal total = new BigDecimal(BigInteger.ZERO);
    private String waybillNumber;
    private boolean warehouseResult;
    private WarehouseDTO warehouse;
    private UserDTO issuePerson;
    private MeanOfTransportDTO transport;
    private String documentPlace;
    private DepartmentDTO department;
    private ContractorDTO contractor;
    private ContractorDTO receivePerson;

    public WarehouseDocumentDTO() {
        department = new DepartmentDTO();
        transport = new MeanOfTransportDTO();
    }

    public WarehouseDocumentDTO(WarehouseDocument warehouseDocument) {
        this.contractor = new ContractorDTO(warehouseDocument.getContractorId());
        this.department = new DepartmentDTO(warehouseDocument.getDepartmentId());
        this.documentDate = warehouseDocument.getDocumentDate();
        this.documentPlace = warehouseDocument.getDocumentPlace();
        this.issuePerson = new UserDTO(warehouseDocument.getIssuePerson());
        this.receivePerson = new ContractorDTO(warehouseDocument.getReceivePerson());
        this.symbol = warehouseDocument.getId().getSymbol();
        this.total = warehouseDocument.getTotal();
        this.transport = new MeanOfTransportDTO(warehouseDocument.getTransportId());
        this.type = warehouseDocument.getType();
        this.warehouse = new WarehouseDTO(warehouseDocument.getWarehouses());
        this.warehouseDate = warehouseDocument.getWarehouseDate();
        this.warehouseResult = warehouseDocument.getWarehouseResult();
        this.waybillNumber = warehouseDocument.getWaybillNumber();
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(Date documentDate) {
        this.documentDate = documentDate;
    }

    public Date getWarehouseDate() {
        return warehouseDate;
    }

    public void setWarehouseDate(Date warehouseDate) {
        this.warehouseDate = warehouseDate;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getWaybillNumber() {
        return waybillNumber;
    }

    public void setWaybillNumber(String waybillNumber) {
        this.waybillNumber = waybillNumber;
    }

    public boolean isWarehouseResult() {
        return warehouseResult;
    }

    public void setWarehouseResult(boolean warehouseResult) {
        this.warehouseResult = warehouseResult;
    }

    public WarehouseDTO getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(WarehouseDTO warehouse) {
        this.warehouse = warehouse;
    }

    public UserDTO getIssuePerson() {
        return issuePerson;
    }

    public void setIssuePerson(UserDTO issuePerson) {
        this.issuePerson = issuePerson;
    }

    public MeanOfTransportDTO getTransport() {
        return transport;
    }

    public void setTransport(MeanOfTransportDTO transport) {
        this.transport = transport;
    }

    public String getDocumentPlace() {
        return documentPlace;
    }

    public void setDocumentPlace(String documentPlace) {
        this.documentPlace = documentPlace;
    }

    public DepartmentDTO getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDTO department) {
        this.department = department;
    }

    public ContractorDTO getContractor() {
        return contractor;
    }

    public void setContractor(ContractorDTO contractor) {
        this.receivePerson = contractor;
        this.contractor = contractor;
    }

    public ContractorDTO getReceivePerson() {
        return receivePerson;
    }

    public void setReceivePerson(ContractorDTO receivePerson) {
        this.receivePerson = receivePerson;
    }

    @Override
    public int compareTo(WarehouseDocumentDTO o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
