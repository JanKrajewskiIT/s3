package pl.lodz.p.project.core.converter.document.items;

import pl.lodz.p.project.core.converter.base.Converter;
import pl.lodz.p.project.core.domain.document.items.Department;
import pl.lodz.p.project.core.dto.document.items.DepartmentDTO;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

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
		entity.setVersion(objectDTO.getVersion());
		entity.setName(objectDTO.getName());
		return entity;
	}

	@Override
	public DepartmentDTO convertEntity(Department entity) {
		DepartmentDTO objectDTO = new DepartmentDTO();
		objectDTO.setId(entity.getId());
		objectDTO.setName(entity.getName());
		objectDTO.setVersion(entity.getVersion());
		return objectDTO;
	}

}
