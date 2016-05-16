package be.myitworld.smartkitchen.tools;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import be.myitworld.smartkitchen.R;
import be.myitworld.smartkitchen.model.Recipe;


/**
 * Created by Jorciney on 8/05/2016.
 */
public class AllRecipesRecyclerViewAdapter extends RecyclerView.Adapter<AllRecipesRecyclerViewAdapter.AllRecipesViewHolder> {
    private final Manager manager = Manager.getInstance();
    private Context context;


    public AllRecipesRecyclerViewAdapter() {
    }

    /**
     * Recycle Viewer ViewHolder
     */
    public static class AllRecipesViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        private ImageView imageView;
        private TextView timeTextView;
        private TextView portionTextView;
        private TextView titleTextView;
        private TextView descTextView;

        AllRecipesViewHolder(View v) {
            super(v);
            cardView = (CardView) v.findViewById(R.id.allrecipes_cardView);
            imageView = (ImageView) v.findViewById(R.id.allrecipes_row_image);
            timeTextView = (TextView) v.findViewById(R.id.allrecipes_row_time);
            portionTextView = (TextView) v.findViewById(R.id.allrecipes_row_portions);
            titleTextView = (TextView) v.findViewById(R.id.allrecipes_row_title);
            descTextView = (TextView) v.findViewById(R.id.allrecipes_row_desc);
        }

    }

    @Override
    public AllRecipesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_allrecipes_recyclerview, parent, false);
        AllRecipesViewHolder viewHolder = new AllRecipesViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AllRecipesViewHolder allRecipesViewHolder, int position) {
        if (position % 2 == 0) {
            allRecipesViewHolder.cardView.setBackgroundColor(Color.parseColor("#FFE4E2E2"));
        } else {
            allRecipesViewHolder.cardView.setBackgroundColor(Color.WHITE);
        }
        if (Manager.recipes != null) {
            Recipe recipe = manager.recipes.get(position);
            if (recipe.getTime() != null)
                allRecipesViewHolder.timeTextView.setText(recipe.getTime());
            if (recipe.getDescription() != null)
                allRecipesViewHolder.descTextView.setText(recipe.getDescription());
            if (recipe.getPortions() > 0)
                allRecipesViewHolder.portionTextView.setText(recipe.getPortions() + "");
            if (recipe.getTitle() != null)
                allRecipesViewHolder.titleTextView.setText(recipe.getTitle());
            try {
                Picasso.with(allRecipesViewHolder.imageView.getContext()).load(recipe.getImages().get(1)).placeholder(R.drawable.loading).error(R.drawable.ic_error).fit().centerInside().centerInside().into(allRecipesViewHolder.imageView);
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }

    /**
     * getItemCount
     */
    @Override
    public int getItemCount() {
        if (Manager.recipes != null)
            return Manager.recipes.size();
        else return 100;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}