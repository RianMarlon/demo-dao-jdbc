package aplicacao;

import java.util.Date;

import modelo.entidade.Department;
import modelo.entidade.Seller;

public class Principal {

	public static void main(String[] args) {
		
		Department obj = new Department (1, "Books");
		System.out.println(obj);
		
		Seller seller = new Seller (21, "Bob", "bob@gemail.com", new Date(), 3000.0, obj);
		
		System.out.println(seller);

	}
}
