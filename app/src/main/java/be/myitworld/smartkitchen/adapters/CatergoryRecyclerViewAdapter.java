package be.myitworld.smartkitchen.adapters;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import be.myitworld.smartkitchen.R;
import be.myitworld.smartkitchen.acitivities.MainActivity;
import be.myitworld.smartkitchen.fragments.RecipesListFragment;
import be.myitworld.smartkitchen.model.Category;
import be.myitworld.smartkitchen.model.Recipe;
import be.myitworld.smartkitchen.tools.Manager;

/**
 * Created by Jorciney on 26/05/2016.
 */
public class CatergoryRecyclerViewAdapter extends RecyclerView.Adapter<CatergoryRecyclerViewAdapter.CategoryViewHolder> {
    private final Manager manager = Manager.getInstance();
    private Context context;
    public static Category category;
    public FragmentActivity activity;
    public static List<Category> mCategories;

    public CatergoryRecyclerViewAdapter(Context context, List<Category> categories) {
        this.context = context;
        this.mCategories=categories;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_catetory, parent, false);
        CategoryViewHolder myHolder = new CategoryViewHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(final CategoryViewHolder holder, final int position) {
        category = Manager.getInstance().categories.get(position);
        holder.categoryName.get().setText(category.getName());
        Picasso.with(holder.categoryImage.get().getContext()).load(category.getImageUrl()).placeholder(R.drawable.ic_food_ready).error(R.drawable.ic_cooking_plate).fit().centerInside().centerInside().into(holder.categoryImage.get());

        holder.view.get().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                activity = (FragmentActivity) v.getContext();
                activity.setTitle(mCategories.get(position).getName());
                List <Recipe>recipes=new ArrayList<Recipe>();
                recipes.addAll(mCategories.get(position).getRecipes());
                RecipesListFragment.recipes=recipes;
                replaceFragment(RecipesListFragment.class);
            }
        });

    }

    @Override
    public int getItemCount() {
        return Manager.categories.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        private final WeakReference<TextView> categoryName;
        private final WeakReference<ImageView> categoryImage;
        private final WeakReference<CardView> cardView;
        private final WeakReference<LinearLayout> linearLayout;
        private final WeakReference<View> view;


        public CategoryViewHolder(View v) {
            super(v);
            view=new WeakReference<View>(v);
            categoryImage = new WeakReference<ImageView>((ImageView) v.findViewById(R.id.category_imageView));
            categoryName = new WeakReference<TextView>((TextView) v.findViewById(R.id.category_name_text));
            cardView = new WeakReference<CardView>((CardView) v.findViewById(R.id.category_cardView));
            linearLayout = new WeakReference<LinearLayout>((LinearLayout) v.findViewById(R.id.categories_linearlayout));
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
