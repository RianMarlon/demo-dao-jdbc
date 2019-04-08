package modelo.dao;

import java.util.List;

import modelo.entidade.Department;
import modelo.entidade.Seller;

public interface SellerDao {

	void insert (Seller obj);
	void update (Seller obj);
	void deleteById (Integer id);
	Seller findById (Integer id);
	List<Seller> findAll ();
	List<Seller> findByDepartment (Department department);

}
