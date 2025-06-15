package alvarez.wilfredo.reactive_inventory.datasource.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table
public class Product implements Persistable<String> {
    @Id
    private String id;
    private String description;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        if (id == null) {
            this.setId(UUID.randomUUID().toString());
            return true;
        }
        return false;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product withDescription(String description) {
        this.setDescription(description);
        return this;
    }
}
