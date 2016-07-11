package be.myitworld.smartkitchen.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import be.myitworld.smartkitchen.R;
import be.myitworld.smartkitchen.acitivities.MainActivity;
import be.myitworld.smartkitchen.tools.Utils;

/**
 * Created by Jorciney on 8/05/2016.
 */
public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        MainActivity.CURRENT_FRAGMENT= Utils.FRAGMENT_HOME;
        View view = inflater.inflate(R.layout.content_main, container, false);
        return view;
    }
}
