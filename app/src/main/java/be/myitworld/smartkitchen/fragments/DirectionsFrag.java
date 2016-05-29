package be.myitworld.smartkitchen.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import be.myitworld.smartkitchen.R;
import be.myitworld.smartkitchen.fragments.RecipeFragment;

/**
 * Created by Jorciney on 21/05/2016.
 */
public class DirectionsFrag extends Fragment {
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.frag_recipe_directions_layout, container, false);

        TextView directionsText= (TextView)view.findViewById(R.id.recipe_directions_content_text);
        if (RecipeFragment.recipe != null) {
            directionsText.setText(RecipeFragment.recipe.getDirections());
        }
        return view;
    }
}
