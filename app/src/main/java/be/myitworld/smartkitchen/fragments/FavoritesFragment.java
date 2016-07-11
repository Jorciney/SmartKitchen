package be.myitworld.smartkitchen.fragments;

import android.graphics.Paint;
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
import be.myitworld.smartkitchen.acitivities.MainActivity;
import be.myitworld.smartkitchen.adapters.FavoritesRecyclerViewAdapter;
import be.myitworld.smartkitchen.tools.AutofitRecyclerView;
import be.myitworld.smartkitchen.tools.Manager;
import be.myitworld.smartkitchen.tools.Utils;

/**
 * Created by Jorciney on 8/05/2016.
 */
public class FavoritesFragment extends Fragment {
    private static RecyclerView recyclerView;
    private static RecyclerView.LayoutManager mLayoutManager;
    public static FavoritesRecyclerViewAdapter recyclerViewAdapter;
    private static AutofitRecyclerView autofitRecyclerView;
    private Paint p = new Paint();
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_favorites_recipes, container, false);
        MainActivity.CURRENT_FRAGMENT = Utils.FRAGMENT_FAVORITES;
        //RecyclerView
        recyclerView = (RecyclerView) view.findViewById(R.id.favorites_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerViewAdapter = new FavoritesRecyclerViewAdapter(getContext(), Manager.getInstance().favorites);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(mLayoutManager);
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        itemAnimator.setAddDuration(1000);
        recyclerView.setItemAnimator(itemAnimator);

        setHasOptionsMenu(true);
        return view;
    }
}
