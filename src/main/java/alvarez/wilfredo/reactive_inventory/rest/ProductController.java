package alvarez.wilfredo.reactive_inventory.rest;

import alvarez.wilfredo.reactive_inventory.service.ProductService;
import alvarez.wilfredo.reactive_inventory.service.contract.to.ProductTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<Flux<ProductTO>> findAll() {
        return ResponseEntity.ok(this.productService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Mono<ProductTO>> findById(@PathVariable String id) {
        return ResponseEntity.ok(this.productService.findById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<Mono<ProductTO>> update(@PathVariable String id, @RequestBody ProductTO productTO) {
        return ResponseEntity.ok(this.productService.update(id, productTO));
    }

    @PostMapping
    public ResponseEntity<Mono<ProductTO>> create(@RequestBody ProductTO productTO) {
        return ResponseEntity.ok(this.productService.create(productTO));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Mono<Void>> delete(@PathVariable String id) {
        return ResponseEntity.ok(this.productService.delete(id));
    }
}
