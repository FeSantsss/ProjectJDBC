package src.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Seller implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String email;
	private java.util.Date birthDate;
	private Double baseSalary;
	private Department department;
	
	public Seller() {
	}

	public Seller(Integer id, String name, String email, java.util.Date birthDate, Double baseSalary,
			Department department) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public Seller(String name2, String email2, Date birthDateUtil, double baseSalary2, int departmentId) {
		this.name = name2;
		this.email = email2;
		this.birthDate = birthDateUtil;
		this.baseSalary = baseSalary2;
		this.department = new Department(departmentId, null);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public java.util.Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(java.util.Date birthDate) {
		this.birthDate = birthDate;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartmentId() {
		return department;
	}

	public void setDepartmentId(Department departmentId) {
		this.department = departmentId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(baseSalary, birthDate, department, email, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seller other = (Seller) obj;
		return Objects.equals(baseSalary, other.baseSalary) && Objects.equals(birthDate, other.birthDate)
				&& Objects.equals(department, other.department) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "id: " + id + " - name: " + name + " - email: " + email + " - birthDate: " + birthDate
				+ " - baseSalary: " + String.format("%.2f", baseSalary) + " - department: " + department.getId();
	}

}
