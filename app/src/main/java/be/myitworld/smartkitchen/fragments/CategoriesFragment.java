package be.myitworld.smartkitchen.fragments;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import be.myitworld.smartkitchen.R;
import be.myitworld.smartkitchen.tools.AutofitRecyclerView;
import be.myitworld.smartkitchen.adapters.CatergoryRecyclerViewAdapter;
import be.myitworld.smartkitchen.tools.Manager;

/**
 * Created by Jorciney on 8/05/2016.
 */
public class CategoriesFragment extends Fragment {
    private static RecyclerView recyclerView;
    private static RecyclerView.LayoutManager mLayoutManager;
    public static CatergoryRecyclerViewAdapter recyclerViewAdapter;
    private static AutofitRecyclerView autofitRecyclerView;
    private Paint p = new Paint();
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.categories_layout, container, false);

        //RecyclerView
        recyclerView = (RecyclerView) view.findViewById(R.id.categories_recyclerview);
        recyclerViewAdapter = new CatergoryRecyclerViewAdapter(getContext(), Manager.getInstance().categories);
        recyclerView.setAdapter(recyclerViewAdapter);
        return view;
    }
}
