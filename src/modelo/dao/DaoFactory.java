package modelo.dao;

import db.DB;
import modelo.dao.IMPL.DepartmentDaoJDBC;
import modelo.dao.IMPL.SellerDaoJDBC;

public class DaoFactory {
	
	public static SellerDao createSellerDao () {
		return new SellerDaoJDBC(DB.getConnection());
		
	}
	
	public static DepartmentDao createDepartmentDao () {
		return new DepartmentDaoJDBC(DB.getConnection());
	}

}
