package pl.lodz.p.was04.department.core.dto.documents;

import java.io.Serializable;

import pl.lodz.p.was04.department.core.domain.documents.Department;

/**
 *
 * @author janiu
 */
public class DepartmentDTO implements Serializable, Comparable<DepartmentDTO> {

	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String departmentName;

    public DepartmentDTO() {
    }

    public DepartmentDTO(Department department) {
        this.id = department.getId();
        this.departmentName = department.getDepartmentName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public int compareTo(DepartmentDTO o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
