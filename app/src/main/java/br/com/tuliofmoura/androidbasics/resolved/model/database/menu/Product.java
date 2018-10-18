package br.com.tuliofmoura.androidbasics.resolved.model.database.menu;

import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.Required;

/**
 * Criado por Tulio Moura em 17/out/2018.
 */
public class Product extends RealmObject {

    @Index
    private long id;

    private String establishmentId;

    @Index
    private long categoryId;

    @Required
    private String name;

    private String productDescription;

    private Double value;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEstablishmentId() {
        return establishmentId;
    }

    public void setEstablishmentId(String establishmentId) {
        this.establishmentId = establishmentId;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
