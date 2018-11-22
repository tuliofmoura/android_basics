package br.com.tuliofmoura.androidbasics.resolved.product;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import br.com.tuliofmoura.androidbasics.R;
import br.com.tuliofmoura.androidbasics.resolved.model.database.menu.MenuRepository;
import br.com.tuliofmoura.androidbasics.resolved.model.database.menu.Product;
import br.com.tuliofmoura.androidbasics.resolved.order.ResolvedOrderActivity;

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
        // verificamos se existe uma lista de produtos selecionados que foi salva previamente
        // devido a uma destruição forçada desta activity pelo sistema
        if (savedInstanceState != null)
            selectedProducts = (ArrayList<Product>) savedInstanceState.getSerializable(SAVED_STATE_PRODUCTS);
            // caso contrário usamos uma lista nova e vazia
        else
            selectedProducts = new ArrayList<>();
        setContentView(R.layout.resolved_activity_fragment);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, ResolvedProductsFragment.newInstance())
                .commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (!selectedProducts.isEmpty())
            //salvamos a lista de produtos selecionados atualmente
            outState.putSerializable(SAVED_STATE_PRODUCTS, selectedProducts);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.resolved_product_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_send) {
            startActivity(ResolvedOrderActivity.newIntent(this, selectedProducts));
        }
        return true;
    }

    @Override
    public List<Product> getProducts() {
        return MenuRepository.getInstance().findProductsByCategoryId(categoryId);
    }

    @Override
    public boolean isSelected(long productId) {
        boolean result = false;
        //verifica se um produto está na lista de selecionados
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
