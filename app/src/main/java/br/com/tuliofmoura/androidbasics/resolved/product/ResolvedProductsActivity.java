package br.com.tuliofmoura.androidbasics.resolved.product;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import br.com.tuliofmoura.androidbasics.R;
import br.com.tuliofmoura.androidbasics.resolved.model.database.menu.MenuRepository;
import br.com.tuliofmoura.androidbasics.resolved.model.database.menu.Product;

public class ResolvedProductsActivity
        extends AppCompatActivity
        implements ResolvedProductsFragment.OnFragmentInteractionListener {

    private static final String EXTRA_CATEGORY_ID = "categoryId";
    private final String SAVED_STATE_PRODUCTS = "savedStateProducts";

    private long categoryId;
    private ArrayList<Product> selectedProducts;

    public static Intent newIntent(Context context, long categoryId) {
        final Intent intent = new Intent(context, ResolvedProductsActivity.class);
        intent.putExtra(EXTRA_CATEGORY_ID, categoryId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.categoryId = getIntent().getExtras().getLong(EXTRA_CATEGORY_ID);
        if (savedInstanceState != null)
            selectedProducts = (ArrayList<Product>) savedInstanceState.getSerializable(SAVED_STATE_PRODUCTS);
        else
            selectedProducts = new ArrayList<>();
        setContentView(R.layout.resolved_activity_list);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.list_fragment_container, ResolvedProductsFragment.newInstance())
                .commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(SAVED_STATE_PRODUCTS, selectedProducts);
    }

    //TODO implementar metodos da interface do fragmento
    //TODO buscar produtos no MenuRepository
    @Override
    public List<Product> getProducts() {
        return MenuRepository.getInstance().findProductsByCategoryId(categoryId);
    }

    @Override
    public boolean isSelected(long productId) {
        boolean result = false;
        for (Product product : selectedProducts) {
            if (product.getId() == productId) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public void onProductAdded(Product addedProduct) {
        selectedProducts.add(addedProduct);
    }

    @Override
    public void onProductRemoved(Product removedProduct) {
        selectedProducts.remove(removedProduct);
    }

}
