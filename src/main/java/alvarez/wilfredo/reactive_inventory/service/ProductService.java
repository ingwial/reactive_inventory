package alvarez.wilfredo.reactive_inventory.service;

import alvarez.wilfredo.reactive_inventory.service.contract.to.ProductTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    Flux<ProductTO> findAll();
    Mono<ProductTO> findById(String id);
    Mono<ProductTO> create(ProductTO productTO);
    Mono<ProductTO> update(String id, ProductTO productTO);
    Mono<Void> delete(String id);
}
