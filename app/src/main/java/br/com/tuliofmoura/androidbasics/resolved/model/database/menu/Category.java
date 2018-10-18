package br.com.tuliofmoura.androidbasics.resolved.model.database.menu;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Criado por Tulio Moura em 11/out/2018.
 */
public class Category extends RealmObject {

    @PrimaryKey
    private long id;

    @Required
    private String name;

    @Required
    private String categoryDescription;

    public Category() {
    }

    public Category(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.categoryDescription = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }
}
