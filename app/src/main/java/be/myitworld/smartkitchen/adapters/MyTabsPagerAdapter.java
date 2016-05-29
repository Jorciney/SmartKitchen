package be.myitworld.smartkitchen.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import java.util.ArrayList;
import be.myitworld.smartkitchen.fragments.DirectionsFrag;
import be.myitworld.smartkitchen.fragments.IngredientsFrag;
import be.myitworld.smartkitchen.fragments.RecipeInfoFrag;

/**
 * Created by Jorciney on 22/05/2016.
 */
public class MyTabsPagerAdapter extends FragmentStatePagerAdapter {
    private ArrayList<String> stringArray=new ArrayList<>();

    public MyTabsPagerAdapter(FragmentManager fm) {
        super(fm);
        stringArray.add("INGREDIENTS");
        stringArray.add("DIRECTIONS");
        stringArray.add("INFO");
    }

    public MyTabsPagerAdapter(FragmentManager fm, ArrayList<String> stringArray, ArrayList<String> urlArray) {
        super(fm);
        this.stringArray = stringArray;
    }


    @Override
    public Fragment getItem(int p) {
        switch (p) {
            case 0:
                return new IngredientsFrag();
            case 1:
                return new DirectionsFrag();
            case 2:
                return new RecipeInfoFrag();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        //return "PAGE " + (position + 1);
        return stringArray.get(position);
    }
}
