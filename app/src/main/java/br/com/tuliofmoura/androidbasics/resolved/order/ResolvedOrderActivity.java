package br.com.tuliofmoura.androidbasics.resolved.order;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import br.com.tuliofmoura.androidbasics.R;
import br.com.tuliofmoura.androidbasics.resolved.model.database.menu.Product;
import br.com.tuliofmoura.androidbasics.resolved.product.ResolvedProductsFragment;

public class ResolvedOrderActivity extends AppCompatActivity
        implements ResolvedProductsFragment.OnFragmentInteractionListener {

    private static final String EXTRA_SELECTED_PRODUCTS = "products";

    public static Intent newIntent(Context context, ArrayList<Product> selectedProducts) {
        final Intent intent = new Intent(context, ResolvedOrderActivity.class);
        intent.putExtra(EXTRA_SELECTED_PRODUCTS, selectedProducts);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resolved_activity_fragment);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, ResolvedOrderFragment.newInstance())
                .commit();
    }

    @Override
    public List<Product> getProducts() {
        final Bundle extras = getIntent().getExtras();
        final ArrayList<Product> products = (ArrayList<Product>) extras.getSerializable(EXTRA_SELECTED_PRODUCTS);
        return products;
    }

    @Override
    public boolean isSelected(long productId) {
        return true;
    }

    @Override
    public void onProductAdded(Product addedProduct) {
        //do nothing
    }

    @Override
    public void onProductRemoved(Product removedProduct) {

    }
}
