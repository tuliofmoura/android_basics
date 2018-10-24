package br.com.tuliofmoura.androidbasics.resolved.model.database.menu;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import io.realm.annotations.RealmModule;

/**
 * Criado por Tulio Moura em 17/out/2018.
 */
public class MenuRepository {

    private static MenuRepository mInstance;
    private final RealmConfiguration config = new RealmConfiguration.Builder()
            .assetFile("database/menu.realm")
            .readOnly()
            .modules(new MenuRealmModule())
            .build();

    private MenuRepository() {
    }

    public static MenuRepository getInstance() {
        if (mInstance == null)
            mInstance = new MenuRepository();
        return mInstance;
    }

    public List<Category> findAllCategories() {
        final Realm realm = Realm.getInstance(config);
        final RealmResults<Category> results = realm.where(Category.class)
                .findAll();
        final List<Category> resultList = realm.copyFromRealm(results);
        realm.close();
        return resultList;
    }

    public List<Product> findProductsByCategoryId(long categoryId)/*TODO receber e filtrar produtos por categoryId*/ {
        final Realm realm = Realm.getInstance(config);
        final RealmResults<Product> result = realm.where(Product.class)
                .and()
                .equalTo("categoryId", categoryId)
                .findAll();
        final List<Product> resultList = realm.copyFromRealm(result);
        realm.close();
        return resultList;
    }

    /**
     * Usado como schema para o Reino dos Contatos.
     * Define quais as classes fazem desse Reino.
     */
    @RealmModule(classes = {Category.class, Product.class})
    private static class MenuRealmModule {
    }
}
