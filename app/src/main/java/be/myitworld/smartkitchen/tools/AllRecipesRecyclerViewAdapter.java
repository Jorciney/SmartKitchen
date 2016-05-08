package be.myitworld.smartkitchen.tools;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import be.myitworld.smartkitchen.R;

/**
 * Created by Jorciney on 8/05/2016.
 */
public class AllRecipesRecyclerViewAdapter extends RecyclerView.Adapter<AllRecipesRecyclerViewAdapter.AllRecipesViewHolder> {

    public AllRecipesRecyclerViewAdapter() {
    }

    /**
     * Recycle Viewer ViewHolder
     */
    public static class AllRecipesViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        private ImageView imageView;

        AllRecipesViewHolder(View v) {
            super(v);

            cardView = (CardView) v.findViewById(R.id.allrecipes_cardView);
        }

    }

    @Override
    public AllRecipesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_allrecipes_recyclerview, parent, false);
        AllRecipesViewHolder viewHolder = new AllRecipesViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AllRecipesViewHolder energyViewHolder, int position) {
        if(position %2==0){
            energyViewHolder.cardView.setBackgroundColor(Color.parseColor("#FFE4E2E2"));
        }else{
            energyViewHolder.cardView.setBackgroundColor(Color.WHITE);
        }
    }

    /**
     * getItemCount
     */
    @Override
    public int getItemCount() {
        return 100;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}