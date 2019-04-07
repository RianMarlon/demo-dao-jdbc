package modelo.dao.IMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import modelo.dao.SellerDao;
import modelo.entidade.Department;
import modelo.entidade.Seller;

public class SellerDaoJDBC implements SellerDao {
	
	private Connection conn;
	
	public SellerDaoJDBC (Connection conn) {
		this.conn = conn;
		
	}

	@Override
	public void insert(Seller Seller) {

	}

	@Override
	public void update(Seller Seller) {

	}

	@Override
	public void deleteById(Integer id) {

	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs =  null;
		
		try  {
			st = conn.prepareStatement(
					"SELECT Seller.*,department.Name as DepName "
					+ "FROM Seller INNER JOIN department "
					+ "ON Seller.DepartmentId = department.Id "
					+ "WHERE Seller.Id = ?"
					);
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if (rs.next()) {
				Department dep = instantiateDepartment(rs);
				
				Seller obj = instantiateSeller (rs, dep);				
				return obj;
			}
			
			return null;
			
		}
		catch (SQLException e)  {
			throw new DbException (e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	private Seller instantiateSeller (ResultSet rs, Department dep) throws SQLException {
		Seller obj = new Seller ();
		obj.setId(rs.getInt("Id"));
		obj.setName(rs.getString("Name"));
		obj.setEmail(rs.getString("Email"));
		obj.setBirthDate(rs.getDate("BirthDate"));
		obj.setBaseSalary(rs.getDouble("BaseSalary"));
		obj.setDepartment(dep);
		
		return obj;
	}

	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department dep = new Department();
		dep.setId(rs.getInt("DepartmentId"));			
		dep.setName(rs.getString("DepName"));
		
		return dep;
	}

	@Override
	public List<Seller> findAll() {
		
		return null;
	}

}
