package pl.lodz.p.project.core.converter.document;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

import pl.lodz.p.project.core.converter.Converter;
import pl.lodz.p.project.core.domain.document.Department;
import pl.lodz.p.project.core.dto.document.DepartmentDTO;

/**
*
* @author Janiu
*/
@Named
@ApplicationScoped
public class DepartmentConverter implements Converter<Department, DepartmentDTO>{

	@Override
	public Department convertDTO(DepartmentDTO objectDTO) {
		Department entity = new Department();
		entity.setId(objectDTO.getId());
		entity.setName(objectDTO.getName());
		return entity;
	}

	@Override
	public DepartmentDTO convertEntity(Department entity) {
		DepartmentDTO objectDTO = new DepartmentDTO();
		objectDTO.setId(entity.getId());
		objectDTO.setName(entity.getName());
		return objectDTO;
	}

}