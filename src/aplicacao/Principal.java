package aplicacao;

import modelo.dao.DaoFactory;
import modelo.dao.SellerDao;
import modelo.entidade.Seller;

public class Principal {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		Seller seller = sellerDao.findById(3);
				
		System.out.println(seller);

	}
}
