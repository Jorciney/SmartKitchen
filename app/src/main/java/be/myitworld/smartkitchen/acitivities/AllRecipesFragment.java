package be.myitworld.smartkitchen.acitivities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import be.myitworld.smartkitchen.R;
import be.myitworld.smartkitchen.tools.AllRecipesRecyclerViewAdapter;

/**
 * Created by Jorciney on 8/05/2016.
 */
public class AllRecipesFragment extends Fragment {
    private static RecyclerView recyclerView;
    private static RecyclerView.LayoutManager mLayoutManager;
    public static AllRecipesRecyclerViewAdapter recyclerViewAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.layout_all_recipes, container, false);

        //RecyclerView
        recyclerView = (RecyclerView) view.findViewById(R.id.all_recipes_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerViewAdapter = new AllRecipesRecyclerViewAdapter();
        mLayoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(mLayoutManager);
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        itemAnimator.setAddDuration(1000);
        recyclerView.setItemAnimator(itemAnimator);


        return view;
    }
}
