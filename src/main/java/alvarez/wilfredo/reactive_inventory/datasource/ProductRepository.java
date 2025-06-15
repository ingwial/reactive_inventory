package alvarez.wilfredo.reactive_inventory.datasource;

import alvarez.wilfredo.reactive_inventory.datasource.entity.Product;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends R2dbcRepository<Product, String> {
}
