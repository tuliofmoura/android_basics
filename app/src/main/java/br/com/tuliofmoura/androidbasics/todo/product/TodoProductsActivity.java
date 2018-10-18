package br.com.tuliofmoura.androidbasics.todo.product;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import br.com.tuliofmoura.androidbasics.R;
import br.com.tuliofmoura.androidbasics.resolved.model.database.menu.MenuRepository;
import br.com.tuliofmoura.androidbasics.resolved.model.database.menu.Product;

public class TodoProductsActivity
        extends AppCompatActivity
        implements TodoProductsFragment.OnFragmentInteractionListener {

    private static final String EXTRA_CATEGORY_ID = "categoryId";

    private long categoryId;

    public static Intent newIntent(Context context, long categoryId) {
        final Intent intent = new Intent(context, TodoProductsActivity.class);
        intent.putExtra(EXTRA_CATEGORY_ID,categoryId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.categoryId = getIntent().getExtras().getLong(EXTRA_CATEGORY_ID);
        setContentView(R.layout.resolved_activity_list);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.list_fragment_container, TodoProductsFragment.newInstance())
                .commit();
    }

    @Override
    public List<Product> getProducts() {
        return MenuRepository.getInstance().findProductsByCategoryId(categoryId);
    }
}
