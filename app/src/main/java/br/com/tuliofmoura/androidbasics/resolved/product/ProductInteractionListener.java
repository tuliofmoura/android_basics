package br.com.tuliofmoura.androidbasics.resolved.product;

import br.com.tuliofmoura.androidbasics.resolved.model.database.menu.Product;

/**
 * Criado por Tulio Moura em 24/out/2018.
 * Para o caso de adicionar ou remover produtos da lista de selecionados, apenas um click listener
 * não consegue resolver o problema, pois, além do clique, precisamos saber qual ação está sendo
 * gerada pelo clique. Além disso, precisamos também saber o status (selecionado ou não) do produto
 * para atualizarmos o estado das views no adapter.
 */
public interface ProductInteractionListener {

    boolean isSelected(Long productId);

    void onAddProductClicked(Product productToAdd);

    void onRemoveProductClicked(Product productToRemove);
}
