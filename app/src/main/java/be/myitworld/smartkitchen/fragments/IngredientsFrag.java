package be.myitworld.smartkitchen.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import be.myitworld.smartkitchen.R;
import be.myitworld.smartkitchen.model.Ingredient;
import be.myitworld.smartkitchen.model.Recipe;
import be.myitworld.smartkitchen.tools.Utils;

/**
 * Created by Jorciney on 21/05/2016.
 */
public class IngredientsFrag extends Fragment {
    private View view;
    public static Recipe recipe = Utils.recipe;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.frag_recipe_ingredients_layout, container, false);

        TextView ingredientsText = (TextView) view.findViewById(R.id.recipe_ingredients_content_text);
        String string = "";
        if (RecipeFragment.recipe != null) {
            for (Ingredient i : RecipeFragment.recipe.getIngredients()) {
                string += String.format("<b>%s</b>  %s, %s <br><br>",i.getAmount()==null?"":i.getAmount(), i.getName()==null?"":i.getName(),i.getDescription()==null?"":i.getDescription());
            }
        }
        ingredientsText.setText(Html.fromHtml(string));
        Log.e("RECIPE_ID", RecipeFragment.recipe.getTitle());
        return view;
    }

}
