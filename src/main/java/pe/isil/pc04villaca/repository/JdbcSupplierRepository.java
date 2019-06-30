package pe.isil.pc04villaca.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pe.isil.pc04villaca.model.Supplier;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcSupplierRepository implements SupplierRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void create(Supplier supplier) {
        final String sql ="insert into supplier(ruc, name, contactName, contactMobilePhone) values(?, ?, ?, ?)";
        jdbcTemplate.update(sql, supplier.getRuc(), supplier.getName(), supplier.getContactEmail(), supplier.getContactMobilePhone());

    }

    @Override
    public void update(Supplier supplier) {
        final String sql ="insert into supplier(ruc, name, contactName, contactMobilePhone) values(?, ?, ?, ?)";
        jdbcTemplate.update(sql, supplier.getRuc(), supplier.getName(), supplier.getContactEmail(), supplier.getContactMobilePhone());
    }

    @Override
    public void delete(String ruc) {
        final String sql ="delete supplier where ruc=?";
        jdbcTemplate.update(sql,ruc);

    }

    @Override
    public List<Supplier> findAll() {
        final String sql = "select * from supplier";
        return jdbcTemplate.query(sql, JdbcSupplierRepository::SupplierRowMapper);
    }

    @Override
    public Supplier findById(String ruc) {
        final String sql= "select * from supplier where ruc=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{ruc},JdbcSupplierRepository::SupplierRowMapper);
    }

    private static Supplier SupplierRowMapper(ResultSet resultSet, String ruc) throws SQLException{
        String rsRuc = resultSet.getString("ruc");
        String name = resultSet.getString("name");
        String contactEmail = resultSet.getString("contactEmail");
        String contactMobilePhone = resultSet.getString("contactMobilePhone");
        return new Supplier(rsRuc,name,contactEmail,contactMobilePhone);
    }
}
