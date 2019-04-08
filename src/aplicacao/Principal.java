package aplicacao;

import java.util.Date;
import java.util.List;

import modelo.dao.DaoFactory;
import modelo.dao.SellerDao;
import modelo.entidade.Department;
import modelo.entidade.Seller;

public class Principal {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TESTE 1: Seller findById =====");
		
		Seller seller = sellerDao.findById(3);
				
		System.out.println(seller);
		
		System.out.println("\n=== TESTE 2: Seller findByDepartment =====");
		Department department = new Department (2, null);
		List <Seller> list = sellerDao.findByDepartment(department);
		
		list.forEach(System.out::println);
		
		System.out.println("\n=== TESTE 3: Seller findAll =====");
		list = sellerDao.findAll();
		
		list.forEach(System.out::println);
		
		System.out.println("\n=== TESTE 3: Seller insert =====");
		Seller newSeller = new Seller (null, "Greg", "greg@gamil.com",  new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		
		System.out.println("Inserted! New id = " + newSeller.getId());
		
	}
}
