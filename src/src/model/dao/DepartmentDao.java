package src.model.dao;

import java.util.List;

import src.model.entities.Department;

public interface DepartmentDao {
	public void insert(Department obj);
	public void update(Department obj);
	public void deleteById(Integer id);
	public Department findById(Integer id);
	public List<Department> findAll();
}
