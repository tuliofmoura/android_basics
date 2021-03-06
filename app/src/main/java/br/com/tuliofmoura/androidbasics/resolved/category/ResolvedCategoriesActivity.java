package br.com.tuliofmoura.androidbasics.resolved.category;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import br.com.tuliofmoura.androidbasics.R;
import br.com.tuliofmoura.androidbasics.resolved.model.database.menu.Category;
import br.com.tuliofmoura.androidbasics.resolved.model.database.menu.MenuRepository;
import br.com.tuliofmoura.androidbasics.resolved.product.ResolvedProductsActivity;

public class ResolvedCategoriesActivity
        extends AppCompatActivity
        implements ResolvedCategoriesFragment.OnFragmentInteractionListener {

    public static Intent newIntent(Context context) {
        return new Intent(context, ResolvedCategoriesActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resolved_activity_fragment);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, ResolvedCategoriesFragment.newInstance())
                .commit();
    }

    @Override
    public List<Category> getCategories() {
        return MenuRepository.getInstance().findAllCategories();
    }

    @Override
    public void onCategoryClicked(Category category) {
        //TODO start activity ResolvedProductsActivity.newIntent
        startActivity(ResolvedProductsActivity.newIntent(this, category.getId()));
    }
}
