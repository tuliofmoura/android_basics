package br.com.tuliofmoura.androidbasics.todo.product;

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

public class TodoProductsFragment extends Fragment {

    private OnFragmentInteractionListener listener;

    public TodoProductsFragment() {
        // Required empty public constructor
    }

    public static TodoProductsFragment newInstance() {
        return new TodoProductsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.resolved_fragment_list, container, false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //TODO instanciar o TodoProductAdapter
        //TODO settar adapter na recyclerView
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

    public interface OnFragmentInteractionListener {

        //TODO criar metodo para forçar activity a devolver a lista de produtos
    }
}
