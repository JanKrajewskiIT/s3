package pl.lodz.p.project.core.converter.document.warehouse;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import pl.lodz.p.project.core.converter.account.UserConverter;
import pl.lodz.p.project.core.converter.base.Converter;
import pl.lodz.p.project.core.converter.contractor.ContractorConverter;
import pl.lodz.p.project.core.converter.document.items.TransportMeanConverter;
import pl.lodz.p.project.core.domain.account.User;
import pl.lodz.p.project.core.domain.contractor.Contractor;
import pl.lodz.p.project.core.domain.document.items.TransportMean;
import pl.lodz.p.project.core.domain.document.warehouse.ExternalInvoice;
import pl.lodz.p.project.core.domain.document.warehouse.ExternalInvoiceGood;
import pl.lodz.p.project.core.dto.account.UserDTO;
import pl.lodz.p.project.core.dto.contractor.ContractorDTO;
import pl.lodz.p.project.core.dto.document.items.TransportMeanDTO;
import pl.lodz.p.project.core.dto.document.warehouse.ExternalInvoiceDTO;
import pl.lodz.p.project.core.dto.document.warehouse.ExternalInvoiceGoodDTO;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

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

	@Inject
	private UserConverter userConverter;

	@Inject
	private ExternalInvoiceGoodConverter invoiceGoodConverter;

	@Override
	public ExternalInvoice convertDTO(ExternalInvoiceDTO objectDTO) {
		Contractor contractor = contractorConverter.convertDTO(objectDTO.getContractor());
		TransportMean transportMean = transportMeanConverter.convertDTO(objectDTO.getTransportMean());
		User issuePerson = userConverter.convertDTO(objectDTO.getIssuePerson());
		List<ExternalInvoiceGood> invoiceGoodList = Lists.transform(objectDTO.getGoodList(), new InvoiceGoodDTOConverter());

		ExternalInvoice entity = new ExternalInvoice();
		entity.setId(objectDTO.getId());
		entity.setVersion(objectDTO.getVersion());
		entity.setSymbol(objectDTO.getSymbol());
		entity.setType(objectDTO.getType());
		entity.setTotal(objectDTO.getTotal());
		entity.setDocumentDate(objectDTO.getDocumentDate());
		entity.setDeliverPerson(objectDTO.getDeliverPerson());
		entity.setIssuePerson(issuePerson);
		entity.setReceivePerson(objectDTO.getReceivePerson());
		entity.setAnnotation(objectDTO.getAnnotation());
		entity.setOrderSymbol(objectDTO.getOrderSymbol());		
		entity.setContractor(contractor);
		entity.setTransportMean(transportMean);
		entity.setGoodList(invoiceGoodList);
		return entity;
	}

	@Override
	public ExternalInvoiceDTO convertEntity(ExternalInvoice entity) {
		ContractorDTO contractor = contractorConverter.convertEntity(entity.getContractor());
		TransportMeanDTO transportMean = transportMeanConverter.convertEntity(entity.getTransportMean());
		UserDTO issuePerson = userConverter.convertEntity(entity.getIssuePerson());
		List<ExternalInvoiceGoodDTO> invoiceGoodList = Lists.transform(entity.getGoodList(), new InvoiceGoodConverter());

		ExternalInvoiceDTO objectDTO = new ExternalInvoiceDTO();
		objectDTO.setId(entity.getId());
		objectDTO.setVersion(entity.getVersion());
		objectDTO.setSymbol(entity.getSymbol());
		objectDTO.setType(entity.getType());
		objectDTO.setTotal(entity.getTotal());
		objectDTO.setDocumentDate(entity.getDocumentDate());
		objectDTO.setDeliverPerson(entity.getDeliverPerson());
		objectDTO.setIssuePerson(issuePerson);
		objectDTO.setReceivePerson(entity.getReceivePerson());
		objectDTO.setAnnotation(entity.getAnnotation());
		objectDTO.setOrderSymbol(entity.getOrderSymbol());
		objectDTO.setContractor(contractor);
		objectDTO.setTransportMean(transportMean);
		objectDTO.setGoodList(invoiceGoodList);
		return objectDTO;
	}

	private class InvoiceGoodConverter implements Function<ExternalInvoiceGood, ExternalInvoiceGoodDTO> {
		@Override
		public ExternalInvoiceGoodDTO apply(ExternalInvoiceGood input) {
			return invoiceGoodConverter.convertEntity(input);
		}
	}

	private class InvoiceGoodDTOConverter implements Function<ExternalInvoiceGoodDTO, ExternalInvoiceGood> {
		@Override
		public ExternalInvoiceGood apply(ExternalInvoiceGoodDTO input) {
			return invoiceGoodConverter.convertDTO(input);
		}
	}
}
