package be.myitworld.smartkitchen.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import be.myitworld.smartkitchen.R;
import be.myitworld.smartkitchen.acitivities.MainActivity;
import be.myitworld.smartkitchen.fragments.RecipeFragment;
import be.myitworld.smartkitchen.model.Recipe;
import be.myitworld.smartkitchen.tools.Manager;
import be.myitworld.smartkitchen.tools.Utils;


/**
 * Created by Jorciney on 8/05/2016.
 */
public class RecipesListRecyclerViewAdapter extends RecyclerView.Adapter<RecipesListRecyclerViewAdapter.AllRecipesViewHolder> implements StickyRecyclerHeadersAdapter {
    private final Manager manager = Manager.getInstance();
    private Context context;
    public static Recipe recipe;
    public FragmentActivity activity;
    public static List<Recipe> mRecipes;
    public static List<Recipe> recipes;

    public RecipesListRecyclerViewAdapter(Context context, List<Recipe> recipes) {
        this.mRecipes=recipes;
        this.recipes=recipes;
        this.context=context;
    }

    /**
     * Recycle Viewer ViewHolder
     */
    public static class AllRecipesViewHolder extends RecyclerView.ViewHolder {
        private final WeakReference<CardView> cardView;
        private final WeakReference<ImageView> imageView;
        private final WeakReference<TextView> timeTextView;
        private final WeakReference<TextView> portionTextView;
        private final WeakReference<TextView> titleTextView;
        private final WeakReference<ImageButton> favoriteButton;
        private final WeakReference<LinearLayout> layout;
        private final WeakReference<View> view;

        AllRecipesViewHolder(View v) {
            super(v);
            view = new WeakReference<View>(v);
            cardView = new WeakReference<CardView>((CardView) v.findViewById(R.id.recipeslist_cardView));
            imageView = new WeakReference<ImageView>((ImageView) v.findViewById(R.id.recipeslist_row_image));
            timeTextView = new WeakReference<TextView>((TextView) v.findViewById(R.id.recipeslist_row_time));
            portionTextView = new WeakReference<TextView>((TextView) v.findViewById(R.id.recipeslist_row_portions));
            titleTextView = new WeakReference<TextView>((TextView) v.findViewById(R.id.recipeslist_row_title));
            favoriteButton = new WeakReference<ImageButton>((ImageButton) v.findViewById(R.id.recipeslist_favorite_imagebutton));
            layout = new WeakReference<LinearLayout>((LinearLayout) v.findViewById(R.id.recipeslist_maintext_layout1));
        }
    }


    @Override
    public AllRecipesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recipeslist_recyclerview, parent, false);
        AllRecipesViewHolder viewHolder = new AllRecipesViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final AllRecipesViewHolder allRecipesViewHolder, final int position) {
        if (position % 2 == 0) {
            allRecipesViewHolder.cardView.get().setBackgroundColor(Color.parseColor("#FFE4E2E2"));
        } else {
            allRecipesViewHolder.cardView.get().setBackgroundColor(Color.WHITE);
        }
        if (mRecipes != null) {
            recipe = mRecipes.get(position);
            if (recipe.getTime() != null)
                allRecipesViewHolder.timeTextView.get().setText(recipe.getTime());
            if (recipe.getPortions() > 0)
                allRecipesViewHolder.portionTextView.get().setText(recipe.getPortions() + "");
            if (recipe.getTitle() != null)
                allRecipesViewHolder.titleTextView.get().setText(recipe.getTitle());
            try {
                Picasso.with(allRecipesViewHolder.imageView.get().getContext()).load(recipe.getImages().get(1)).placeholder(R.drawable.loading).error(R.drawable.ic_error).fit().centerInside().centerInside().into(allRecipesViewHolder.imageView.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(Manager.getInstance().favorites.contains(mRecipes.get(position))) {
            allRecipesViewHolder.favoriteButton.get().setImageResource(R.drawable.ic_star_favorite_yellow_filled);
        }else{
            allRecipesViewHolder.favoriteButton.get().setImageResource(R.drawable.ic_star_favorite_gray_64);
        }
        allRecipesViewHolder.layout.get().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.CURRENT_FRAGMENT = Utils.FRAGMENT_RECIPELIST_RECIPE;
                RecipeFragment.recipe = mRecipes.get(position);
                activity = (FragmentActivity) v.getContext();
                activity.setTitle(mRecipes.get(position).getTitle());
                replaceFragment();
            }
        });
        allRecipesViewHolder.favoriteButton.get().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Manager.getInstance().favorites.contains(mRecipes.get(position))) {
                    allRecipesViewHolder.favoriteButton.get().setImageResource(R.drawable.ic_star_favorite_yellow_filled);
                    Manager.getInstance().favorites.add(mRecipes.get(position));
                }else{
                    allRecipesViewHolder.favoriteButton.get().setImageResource(R.drawable.ic_star_favorite_gray_64);
                    Manager.getInstance().favorites.remove(mRecipes.get(position));
                }
            }
        });
    }

    private void replaceFragment() {
        if (getContext() == null)
            return;
        if (getContext() instanceof MainActivity) {
            MainActivity mainActivity = (MainActivity) getContext();
            mainActivity.replaceFragment(RecipeFragment.class);
        }
    }

    public void removeItem(int position) {
        this.recipes.remove(position);
        this.mRecipes = this.recipes;
        notifyDataSetChanged();
    }

    //Remove for when the search is active
    public void removeItemOnSearch(int position) {
        Recipe a = mRecipes.get(position);
        for (int i = 0; i <  this.recipes.size(); i++) {
            if ( this.recipes.get(i) == a) {
                this.recipes.remove(i);
            }
        }
        mRecipes.remove(position);
        notifyDataSetChanged();
    }

    public void addItem(Recipe recipeItem) {
        mRecipes.add(recipeItem);
        notifyDataSetChanged();
    }

    @Override
    public long getHeaderId(int position) {
        return mRecipes.get(position).getTitle().charAt(0);
    }

    @Override
    public RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_recipeslist_view_section_header, parent, false);
        return new RecyclerView.ViewHolder(view) {
        };
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder, int position) {
        TextView textView = (TextView) holder.itemView;
        textView.setText(String.valueOf(mRecipes.get(position).getTitle().charAt(0)));
        //holder.itemView.setBackgroundColor(Utils.getRandomColor());
    }

    /**
     * getItemCount
     */
    @Override
    public int getItemCount() {
        if (mRecipes != null)
            return mRecipes.size();
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

    public void setFilter(List<Recipe> recipes) {
        mRecipes = new ArrayList<>();
        mRecipes.addAll(recipes);
        notifyDataSetChanged();
    }
}