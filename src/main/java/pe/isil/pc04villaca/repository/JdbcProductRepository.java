package pe.isil.pc04villaca.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pe.isil.pc04villaca.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcProductRepository  implements ProductRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void create(Product product) {
        final String sql = "insert into student(sku, name, stock, price) values (?, ?, ?, ?)";
        jdbcTemplate.update(sql, product.getSku(), product.getName(), product.getStock(), product.getPrice());

    }

    @Override
    public void update(Product product) {
        final String sql = "update student set (sku, name, stock, price) values (?, ?, ?, ?)";
        jdbcTemplate.update(sql, product.getSku(), product.getName(), product.getStock(), product.getPrice());


    }

    @Override
    public void delete(String sku) {
        final String sql = "delete product where sku=?";
        jdbcTemplate.update(sql, sku);

    }

    @Override
    public List<Product> findAll() {
        final String sql= "select * from product";
        return jdbcTemplate.query(sql, JdbcProductRepository::ProductRowMapper);
    }

    @Override
    public Product findById(String sku) {
        final String sql ="select * from product where sku=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{sku}, JdbcProductRepository::ProductRowMapper);
    }

    private static Product ProductRowMapper(ResultSet resultSet, int i) throws SQLException{
        String  rsSkun = resultSet.getString("sku");
        String  name   = resultSet.getString("name");
        Integer stock  = resultSet.getInt("stock");
        String  price  = resultSet.getString("price");
        return new Product(rsSkun,name,stock,price);

    }
}
