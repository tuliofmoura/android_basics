package br.com.tuliofmoura.androidbasics.resolved.order;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.tuliofmoura.androidbasics.R;
import br.com.tuliofmoura.androidbasics.resolved.product.ResolvedProductsFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResolvedOrderFragment extends Fragment {

    public ResolvedOrderFragment() {
        // Required empty public constructor
    }

    public static ResolvedOrderFragment newInstance() {
        return new ResolvedOrderFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootview = inflater.inflate(R.layout.resolved_fragment_order_products, container, false);
        getChildFragmentManager().beginTransaction()
                .replace(R.id.products_fragment_container, ResolvedProductsFragment.newInstance())
                .commit();
        return rootview;
    }

}
