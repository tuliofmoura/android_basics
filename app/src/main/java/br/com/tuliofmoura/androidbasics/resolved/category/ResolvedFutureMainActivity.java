package br.com.tuliofmoura.androidbasics.resolved.category;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import br.com.tuliofmoura.androidbasics.R;
import br.com.tuliofmoura.androidbasics.resolved.model.Category;

public class ResolvedFutureMainActivity
        extends AppCompatActivity
        implements ResolvedCategoriesFragment.OnFragmentInteractionListener {

    public static Intent newIntent(Context context) {
        return new Intent(context, ResolvedFutureMainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resolved_activity_future_main);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.list_fragment_container, ResolvedCategoriesFragment.newInstance())
                .commit();
    }

    @Override
    public List<Category> getCategories() {
        return mountCategoryList();
    }

    private List<Category> mountCategoryList() {
        final List<Category> list = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            Category category;
            switch (i) {
                case 1:
                    category = new Category(1L, "Espressos", "Blends especiais");
                    break;
                case 2:
                    category = new Category(2L, "Bebidas Quentes", "Espressos, Cappuccino, Café...");
                    break;
                case 3:
                    category = new Category(3L, "Bebidas Geladas", "Choccoccino, Café, Mocha...");
                    break;
                case 4:
                    category = new Category(4L, "Chocolates e Milk Shakes", "Chocolates quentes, gelados e shakes");
                    break;
                case 5:
                    category = new Category(5L, "Combinados", "Os melhores combos Social Café");
                    break;
                case 6:
                    category = new Category(6L, "Cafés Alcoólicos", "Cafés com licores e whisky");
                    break;
                case 7:
                    category = new Category(7L, "Bebidas", "Chás, água, sucos e refrigerantes");
                    break;
                case 8:
                    category = new Category(8L, "Happy Hour", "Cervejas e porções");
                    break;
                case 9:
                    category = new Category(9L, "Queijos e Vinhos", "Tintos e brancos, tábuas e frisantes");
                    break;
                case 10:
                    category = new Category(10L, "Lanches", "Pães de queijo, sanduíches, salgados...");
                    break;
                case 11:
                    category = new Category(11L, "Sobremesas", "Saladas de fruta, bolos, tortas...");
                    break;
                default:
                    category = new Category(12L, "Promoções", "Todo dia é dia de promoção");
                    break;
            }
            list.add(category);
        }
        return list;
    }
}
