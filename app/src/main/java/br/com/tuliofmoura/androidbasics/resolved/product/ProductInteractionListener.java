package br.com.tuliofmoura.androidbasics.resolved.product;

import br.com.tuliofmoura.androidbasics.resolved.model.database.menu.Product;

/**
 * Criado por Tulio Moura em 24/out/2018.
 */
public interface ProductInteractionListener {

    boolean isSelected(Long productId);

    void onAddProductClicked(Product productToAdd);

    void onRemoveProductClicked(Product productToRemove);
}
