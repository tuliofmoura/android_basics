package br.com.tuliofmoura.androidbasics.resolved.category;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.tuliofmoura.androidbasics.R;
import br.com.tuliofmoura.androidbasics.resolved.model.database.menu.Category;

/**
 * Criado por Tulio Moura em 11/out/2018.
 */
public class ResolvedCategoryAdapter extends RecyclerView.Adapter<ResolvedCategoryAdapter.ResolvedCategoryViewHolder> {

    private List<Category> categoryList;

    public ResolvedCategoryAdapter(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public ResolvedCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View rootView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.resolved_item_category, parent, false);
        return new ResolvedCategoryViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull ResolvedCategoryViewHolder holder, int position) {
        final Category category = categoryList.get(position);
        holder.nameTextView.setText(category.getName());
        holder.descriptionTextView.setText(category.getCategoryDescription());
        final int categoryIconResId = holder.iconImageView.getResources().getIdentifier(
                "ic_category_" + category.getId(),
                "drawable",
                holder.iconImageView.getContext().getPackageName()
        );
        holder.iconImageView.setImageResource(categoryIconResId);
    }

    @Override
    public int getItemCount() {
        return categoryList != null ? categoryList.size() : 0;
    }

    class ResolvedCategoryViewHolder extends RecyclerView.ViewHolder {

        TextView nameTextView;
        TextView descriptionTextView;
        ImageView iconImageView;

        ResolvedCategoryViewHolder(View view) {
            super(view);
            nameTextView = view.findViewById(R.id.category_title);
            descriptionTextView = view.findViewById(R.id.category_description);
            iconImageView = view.findViewById(R.id.category_icon);
        }
    }
}
