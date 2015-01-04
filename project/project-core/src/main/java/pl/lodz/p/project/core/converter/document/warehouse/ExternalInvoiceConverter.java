package pl.lodz.p.project.core.converter.document.warehouse;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pl.lodz.p.project.core.converter.Converter;
import pl.lodz.p.project.core.converter.contractor.ContractorConverter;
import pl.lodz.p.project.core.converter.document.TransportMeanConverter;
import pl.lodz.p.project.core.domain.contractor.Contractor;
import pl.lodz.p.project.core.domain.document.TransportMean;
import pl.lodz.p.project.core.domain.document.warehouse.ExternalInvoice;
import pl.lodz.p.project.core.dto.contractor.ContractorDTO;
import pl.lodz.p.project.core.dto.document.TransportMeanDTO;
import pl.lodz.p.project.core.dto.document.warehouse.ExternalInvoiceDTO;

/**
 * 
 * @author Jan Krajewski
 *
 */
@Named
@ApplicationScoped
public class ExternalInvoiceConverter implements Converter<ExternalInvoice, ExternalInvoiceDTO> {

	@Inject
	private ContractorConverter contractorConverter;
	
	@Inject
	private TransportMeanConverter transportMeanConverter;
	
	@Override
	public ExternalInvoice convertDTO(ExternalInvoiceDTO objectDTO) {
		Contractor contractor = contractorConverter.convertDTO(objectDTO.getContractor());
		TransportMean transportMean = transportMeanConverter.convertDTO(objectDTO.getTransportMean());
		
		ExternalInvoice entity = new ExternalInvoice();
		entity.setId(objectDTO.getId());
		entity.setVersion(objectDTO.getVersion());
		entity.setSymbol(objectDTO.getSymbol());
		entity.setTotal(objectDTO.getTotal());
		entity.setDocumentDate(objectDTO.getDocumentDate());
		entity.setDeliverPerson(objectDTO.getDeliverPerson());
		entity.setIssuePerson(objectDTO.getIssuePerson());
		entity.setReceivePerson(objectDTO.getReceivePerson());
		entity.setOrderSymbol(objectDTO.getOrderSymbol());		
		entity.setContractor(contractor);
		entity.setTransportMean(transportMean);
		return entity;
	}

	@Override
	public ExternalInvoiceDTO convertEntity(ExternalInvoice entity) {
		ContractorDTO contractor = contractorConverter.convertEntity(entity.getContractor());
		TransportMeanDTO transportMean = transportMeanConverter.convertEntity(entity.getTransportMean());
		
		ExternalInvoiceDTO objectDTO = new ExternalInvoiceDTO();
		objectDTO.setId(entity.getId());
		objectDTO.setVersion(entity.getVersion());
		objectDTO.setSymbol(entity.getSymbol());
		objectDTO.setTotal(entity.getTotal());
		objectDTO.setDocumentDate(entity.getDocumentDate());
		objectDTO.setDeliverPerson(entity.getDeliverPerson());
		objectDTO.setIssuePerson(entity.getIssuePerson());
		objectDTO.setReceivePerson(entity.getReceivePerson());
		objectDTO.setOrderSymbol(entity.getOrderSymbol());
		objectDTO.setContractor(contractor);
		objectDTO.setTransportMean(transportMean);
		return objectDTO;
	}

}
