package pe.isil.pc04villaca.repository;


import org.springframework.stereotype.Repository;
import pe.isil.pc04villaca.model.Product;

@Repository
public interface ProductRepository extends BaseRepository<Product, String> {
}
