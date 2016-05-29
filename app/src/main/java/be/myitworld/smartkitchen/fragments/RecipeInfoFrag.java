package be.myitworld.smartkitchen.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import be.myitworld.smartkitchen.R;

/**
 * Created by Jorciney on 22/05/2016.
 */
public class RecipeInfoFrag extends Fragment {
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.frag_recipe_info_layout, container, false);

        TextView directionsText = (TextView) view.findViewById(R.id.recipe_info_content_text);
        String str = "";
        if (RecipeFragment.recipe != null) {
            str = String.format("<b>Portions:</b>&emsp;&emsp;&emsp;%s<br><br><b>Prep time:</b>&emsp;&emsp;%s<br><br><b>Author: </b>&emsp;&emsp;&emsp;%s", RecipeFragment.recipe.getPortions(), RecipeFragment.recipe.getTime(), RecipeFragment.recipe.getAuthor());
        }
        directionsText.setText(Html.fromHtml(str));
        return view;
    }
}
