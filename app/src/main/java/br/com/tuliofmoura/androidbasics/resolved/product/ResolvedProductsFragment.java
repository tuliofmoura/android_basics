package br.com.tuliofmoura.androidbasics.resolved.product;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.tuliofmoura.androidbasics.R;
import br.com.tuliofmoura.androidbasics.resolved.model.database.menu.Product;

public class ResolvedProductsFragment extends Fragment
        implements ProductInteractionListener {

    private OnFragmentInteractionListener listener;

    public ResolvedProductsFragment() {
        // Required empty public constructor
    }

    public static ResolvedProductsFragment newInstance() {
        return new ResolvedProductsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        final RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.resolved_fragment_list, container, false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //TODO instanciar o ResolvedProductAdapter
        //TODO settar adapter na recyclerView
        final ResolvedProductAdapter adapter = new ResolvedProductAdapter(listener.getProducts(), this);
        recyclerView.setAdapter(adapter);
        return recyclerView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            listener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Override
    public boolean isSelected(Long productId) {
        //delega para a Activity (ViewModel) a responsabilidade de saber se um produto está ou não selecionado
        return listener.isSelected(productId);
    }

    @Override
    public void onAddProductClicked(Product productToAdd) {
        //delega para a Activity (ViewModel) a responsabilidade de atualizar a lista de produtos selecionados
        listener.onProductAdded(productToAdd);
    }

    @Override
    public void onRemoveProductClicked(Product productToRemove) {
        //delega para a Activity (ViewModel) a responsabilidade de atualizar a lista de produtos selecionados
        listener.onProductRemoved(productToRemove);
    }

    public interface OnFragmentInteractionListener {

        //TODO criar metodo para forçar activity a devolver a lista de produtos
        List<Product> getProducts();

        boolean isSelected(long productId);

        void onProductAdded(Product addedProduct);

        void onProductRemoved(Product removedProduct);

    }
}
