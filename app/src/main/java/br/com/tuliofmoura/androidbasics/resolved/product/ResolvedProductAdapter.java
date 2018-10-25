package br.com.tuliofmoura.androidbasics.resolved.product;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
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
public class ResolvedProductAdapter extends RecyclerView.Adapter<ResolvedProductAdapter.TodoProductViewHolder> {

    private List<Product> products;
    private ProductInteractionListener onProductInteractionListener;

    public ResolvedProductAdapter(List<Product> products, ProductInteractionListener interactionListener) {
        this.products = products;
        this.onProductInteractionListener = interactionListener;
    }

    @NonNull
    @Override
    public TodoProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View rootView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.resolved_item_product, parent, false);
        return new TodoProductViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull final TodoProductViewHolder holder, int position) {
        final Product product = products.get(position);
        holder.nameTextView.setText(product.getName());
        holder.descriptionTextView.setText(product.getProductDescription());
        holder.valueTextView.setText(String.format("R$ %.2f", product.getValue()));
        // se o produto já está selecionado, escondemos o botão de adicionar e mostramos o de remover
        if (onProductInteractionListener.isSelected(product.getId())) {
            holder.addButtonImageView.setVisibility(View.GONE);
            holder.removeButtonImageView.setVisibility(View.VISIBLE);
            holder.removeButtonImageView.setTag(product);
            holder.removeButtonImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final Product productToRemove = (Product) view.getTag();
                    onProductInteractionListener.onRemoveProductClicked(productToRemove);
                    notifyItemChanged(holder.getAdapterPosition());
                }
            });
        }
        // caso contrário, escondemos o de remover e mostramos o de adicionar
        else {
            holder.addButtonImageView.setVisibility(View.VISIBLE);
            holder.removeButtonImageView.setVisibility(View.GONE);
            holder.addButtonImageView.setTag(product);
            holder.addButtonImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final Product productToAdd = (Product) view.getTag();
                    onProductInteractionListener.onAddProductClicked(productToAdd);
                    notifyItemChanged(holder.getAdapterPosition());
                }
            });
        }
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
        ImageView removeButtonImageView;

        TodoProductViewHolder(View view) {
            super(view);
            establishmentIdTextView = view.findViewById(R.id.establishment_id_label);
            nameTextView = view.findViewById(R.id.product_name_label);
            descriptionTextView = view.findViewById(R.id.product_description_label);
            valueTextView = view.findViewById(R.id.product_value_label);
            addButtonImageView = view.findViewById(R.id.add_btn);
            removeButtonImageView = view.findViewById(R.id.remove_btn);
        }
    }
}
