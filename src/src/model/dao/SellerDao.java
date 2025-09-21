package src.model.dao;

import java.util.List;

import src.model.entities.Department;
import src.model.entities.Seller;

public interface SellerDao {
	public void insert(Seller obj);
	public void update(Seller obj);
	public void deleteById(Integer id);
	public Seller findById(Integer id);
	public List<Seller> findAll();
	List<Seller> findByDepartment(Department department);
}
