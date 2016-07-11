package be.myitworld.smartkitchen.adapters;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.lang.ref.WeakReference;
import java.util.List;

import be.myitworld.smartkitchen.R;
import be.myitworld.smartkitchen.acitivities.MainActivity;
import be.myitworld.smartkitchen.fragments.RecipeFragment;
import be.myitworld.smartkitchen.model.Recipe;
import be.myitworld.smartkitchen.tools.Manager;
import be.myitworld.smartkitchen.tools.Utils;

/**
 * Created by Jorciney on 26/05/2016.
 */
public class FavoritesRecyclerViewAdapter extends RecyclerView.Adapter<FavoritesRecyclerViewAdapter.FavoriteViewHolder> {
    private final Manager manager = Manager.getInstance();
    private Context context;
    private WeakReference<List<Recipe>> favorites;
    private WeakReference<Recipe> recipe;
    private FragmentActivity activity;
    private WeakReference<List<Recipe>> mFavorites;

    public FavoritesRecyclerViewAdapter(final Context context, final List<Recipe> recipes) {
        this.context = context;
        this.mFavorites = new WeakReference<List<Recipe>>(recipes);
        this.favorites = new WeakReference<List<Recipe>>(recipes);
    }

    @Override
    public FavoriteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_favorites_recyclerview, parent, false);
        FavoriteViewHolder myHolder = new FavoriteViewHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(final FavoriteViewHolder holder, final int position) {
        recipe=new WeakReference<Recipe>(Manager.getInstance().favorites.get(position));
        holder.recipeTitle.get().setText(recipe.get().getTitle());
        holder.recipeTime.get().setText(recipe.get().getTime());
        holder.recipePortions.get().setText(recipe.get().getPortions()+"");
        Picasso.with(holder.recipeImage.get().getContext()).load(recipe.get().getImages().get(1)).placeholder(R.drawable.ic_food_ready).error(R.drawable.ic_cooking_plate).fit().centerInside().centerInside().into(holder.recipeImage.get());

        holder.view.get().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.CURRENT_FRAGMENT = Utils.FRAGMENT_FAVORITES_RECIPE;
                RecipeFragment.recipe = mFavorites.get().get(position);
                activity = (FragmentActivity) v.getContext();
                activity.setTitle(mFavorites.get().get(position).getTitle());
                replaceFragment(RecipeFragment.class);
            }
        });

    }

    @Override
    public int getItemCount() {
        return Manager.getInstance().favorites.size();
    }

    public class FavoriteViewHolder extends RecyclerView.ViewHolder {
        private final WeakReference<TextView> recipeTitle;
        private final WeakReference<ImageView> recipeImage;
        private final WeakReference<CardView> cardView;
        private final WeakReference<TextView> recipeTime;
        private final WeakReference<TextView> recipePortions;
        private final WeakReference<View> view;


        public FavoriteViewHolder(View v) {
            super(v);
            view = new WeakReference<View>(v);
            recipeTitle = new WeakReference<TextView>((TextView) v.findViewById(R.id.favorite_recipe_title));
            recipeTime = new WeakReference<TextView>((TextView) v.findViewById(R.id.favorite_recipe_time));
            recipePortions = new WeakReference<TextView>((TextView) v.findViewById(R.id.favorite_recipe_portions));
            cardView = new WeakReference<CardView>((CardView) v.findViewById(R.id.favorite_cardview));
            recipeImage = new WeakReference<ImageView>((ImageView) v.findViewById(R.id.favorites_recipe_image));
        }
    }

    private void replaceFragment(final Class mClass) {
        if (context == null)
            return;
        if (context instanceof MainActivity) {
            MainActivity mainActivity = (MainActivity) context;
            mainActivity.replaceFragment(mClass);
        }
    }
}
