package alvarez.wilfredo.reactive_inventory.service.impl;

import alvarez.wilfredo.reactive_inventory.datasource.ProductRepository;
import alvarez.wilfredo.reactive_inventory.service.ProductService;
import alvarez.wilfredo.reactive_inventory.service.contract.to.ProductTO;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static alvarez.wilfredo.reactive_inventory.service.contract.ProductBider.PRODUCT_BIDER;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Flux<ProductTO> findAll() {
        return this.productRepository.findAll()
                .map(PRODUCT_BIDER::bind);
    }

    @Override
    public Mono<ProductTO> findById(String id) {
        return this.productRepository.findById(id)
                .map(PRODUCT_BIDER::bind);
    }

    @Override
    public Mono<ProductTO> create(ProductTO productTO) {
        return this.productRepository.save(PRODUCT_BIDER.bind(productTO))
                .map(PRODUCT_BIDER::bind);
    }

    @Override
    public Mono<ProductTO> update(String id, ProductTO productTO) {
        return this.productRepository.findById(id)
                .map(product -> product.withDescription(productTO.getDescription()))
                .flatMap(this.productRepository::save)
                .map(PRODUCT_BIDER::bind)
                .onErrorReturn(productTO);
    }

    @Override
    public Mono<Void> delete(String id) {
        return this.productRepository.findById(id)
                .flatMap(this.productRepository::delete)
                .then();
    }
}
