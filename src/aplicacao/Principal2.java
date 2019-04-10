package aplicacao;

import java.util.List;
import java.util.Scanner;

import modelo.dao.DaoFactory;
import modelo.dao.DepartmentDao;
import modelo.entidade.Department;

public class Principal2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TESTE 1: Department findById =====");
		
		Department department = departmentDao.findById(1);
				
		System.out.println(department);
			
		System.out.println("\n=== TESTE 2: Department findAll =====");
		
		List <Department> list = departmentDao.findAll();
		
		for (Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TESTE 3: Department insert =====");
		Department newDepartment = new Department (null, "Music");
		departmentDao.insert(newDepartment);
		
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		System.out.println("\n=== TESTE 4: Department update =====");
		department = departmentDao.findById(1);
		department.setName("Food");
		departmentDao.update(department);
		System.out.println("Update completado!");
		
		System.out.println("\n=== TESTE 5: Department delete =====");
		System.out.print("Entre com um id para deletar: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Deletado com sucesso");
		
		sc.close();

	}

}
