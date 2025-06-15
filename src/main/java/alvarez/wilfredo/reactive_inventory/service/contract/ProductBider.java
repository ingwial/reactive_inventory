package alvarez.wilfredo.reactive_inventory.service.contract;

import alvarez.wilfredo.reactive_inventory.datasource.entity.Product;
import alvarez.wilfredo.reactive_inventory.service.contract.to.ProductTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductBider {
    ProductBider PRODUCT_BIDER = Mappers.getMapper( ProductBider.class );

    @Mapping(target = "id", ignore = true)
    Product bind(ProductTO productTO);

    ProductTO bind(Product product);
}
