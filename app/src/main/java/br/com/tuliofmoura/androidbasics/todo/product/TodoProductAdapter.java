package br.com.tuliofmoura.androidbasics.todo.product;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.tuliofmoura.androidbasics.R;
import br.com.tuliofmoura.androidbasics.resolved.model.database.menu.Product;

/**
 * Criado por Tulio Moura em 11/out/2018.
 */
public class TodoProductAdapter extends RecyclerView.Adapter<TodoProductAdapter.TodoProductViewHolder> {

    private List<Product> products;
    //TODO onclickLister

    public TodoProductAdapter(List<Product> products /*TODO receber parametro onclickListener*/) {
        this.products = products;
    }

    @NonNull
    @Override
    public TodoProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
        //TODO inflar todo_item_product
    }

    @Override
    public void onBindViewHolder(@NonNull TodoProductViewHolder holder, int position) {
        Product product = products.get(position);
        holder.establishmentIdTextView.setText(product.getEstablishmentId());
        //TODO fazer isso para cada elemento do viewHolder
    }

    @Override
    public int getItemCount() {
        return products != null ? products.size() : 0;
    }

    class TodoProductViewHolder extends RecyclerView.ViewHolder {

        TextView establishmentIdTextView;
        TextView nameTextView;
        TextView descriptionTextView;
        TextView valueTextView;
        ImageView addButtonImageView;

        TodoProductViewHolder(View view) {
            super(view);
            //TODO fazer findViewById para cada view
            establishmentIdTextView = view.findViewById(R.id.establishment_id_label);
        }
    }
}
