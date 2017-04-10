package daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import interfaces.CompanyInterface;
import model.Company;

public class CompanyDAO extends DefaultDAO implements CompanyInterface {
    
    private final static String QUERY_FIND_COMPANIES = "SELECT * FROM " + Company.TABLE_NAME;    
    private final static String QUERY_FIND_COMPANY_BY_ID = "SELECT * FROM " + Company.TABLE_NAME + " WHERE id = ? ";
    private final static String QUERY_ADD_COMPANY = "INSERT INTO " + Company.TABLE_NAME + " (id, name) values (?, ?)";
    private final static String QUERY_UPDATE_COMPANY = "UPDATE " + Company.TABLE_NAME + " SET name = ? WHERE id = ?";
    private final static String QUERY_DELETE_COMPANY = "DELETE FROM " + Company.TABLE_NAME + " WHERE id = ? ";

	@Override
	public List<Company> listCompanies() {
		List<Company> companies = new ArrayList<>();
		
		try {
            con = getConnexion();
            stmt = con.prepareStatement(QUERY_FIND_COMPANIES);

            final ResultSet rset = stmt.executeQuery();

            while (rset.next()) {
                Company company = new Company(rset.getInt("id"), rset.getString("name"));
                companies.add(company);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
		
		return companies;
	}

	@Override
	public Company getCompany(int id) {
		Company company = null;
		
		try {
            con = getConnexion();
            stmt = con.prepareStatement(QUERY_FIND_COMPANY_BY_ID);
            stmt.setInt(1, id);
            final ResultSet rset = stmt.executeQuery();

            if (rset.next()) {
                company = new Company(rset.getInt("id"), rset.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
		
		return company;
	}

	@Override
	public boolean addCompany(int id, String name) {
		boolean add = false;
		
		try {
            con = getConnexion();
            stmt = con.prepareStatement(QUERY_ADD_COMPANY);
            stmt.setInt(1, id);
            stmt.setString(2, name);
            
            int res = stmt.executeUpdate();
            add = true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
		
		return add;
	}

	@Override
	public boolean updateCompany(int id, String name) {
		boolean add = false;
		
		try {
            con = getConnexion();
            stmt = con.prepareStatement(QUERY_UPDATE_COMPANY);
            stmt.setString(1, name);
            stmt.setInt(2, id);
            
            int res = stmt.executeUpdate();
            add = true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
		
		return add;
	}

	@Override
	public boolean deleteCompany(int id) {
		boolean delete = false;
		
		try {
            con = getConnexion();
            stmt = con.prepareStatement(QUERY_DELETE_COMPANY);
            stmt.setInt(1, id);
            int res = stmt.executeUpdate();
            delete = true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
		
		return delete;
	}
	
}
