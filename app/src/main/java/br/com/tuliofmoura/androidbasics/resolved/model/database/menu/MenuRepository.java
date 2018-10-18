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
        Realm realm = Realm.getInstance(config);
        RealmResults<Category> results = realm.where(Category.class)
                .findAll();
        List<Category> resultList = realm.copyFromRealm(results);
        realm.close();
        return resultList;
    }

    /**
     * Usado como schema para o Reino dos Contatos.
     * Define quais as classes fazem desse Reino.
     */
    @RealmModule(classes = {Category.class})
    private static class MenuRealmModule {
    }
}
