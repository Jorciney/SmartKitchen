package be.myitworld.smartkitchen.tools;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import be.myitworld.smartkitchen.R;
import be.myitworld.smartkitchen.model.Category;
import be.myitworld.smartkitchen.model.Recipe;

/**
 * Created by Jorciney on 26/05/2016.
 */
public class CatergoryRecyclerViewAdapter extends RecyclerView.Adapter<CatergoryRecyclerViewAdapter.CategoryViewHolder> {
    private final Manager manager = Manager.getInstance();
    private Context context;
    public static Category category;
    public FragmentActivity activity;
    public static List<Recipe> mCategories;

    public CatergoryRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_catetory, parent, false);
        CategoryViewHolder myHolder = new CategoryViewHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        category = Manager.getInstance().categories.get(position);
        holder.categoryName.setText(category.getName());
        Picasso.with(holder.categoryImage.getContext()).load(category.getImageUrl()).placeholder(R.drawable.ic_food_ready).error(R.drawable.ic_cooking_plate).fit().centerInside().centerInside().into(holder.categoryImage);
//        holder.linearLayout.setBackgroundColor(Utils.getRandomColor());
    }

    @Override
    public int getItemCount() {
        return Manager.categories.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        private TextView categoryName;
        private ImageView categoryImage;
        private CardView cardView;
        private LinearLayout linearLayout;

        public CategoryViewHolder(View v) {
            super(v);
            categoryImage = (ImageView) v.findViewById(R.id.category_imageView);
            categoryName = (TextView) v.findViewById(R.id.category_name_text);
            cardView=(CardView)v.findViewById(R.id.category_cardView);
            linearLayout=(LinearLayout)v.findViewById(R.id.categories_linearlayout);
        }
    }
}
