package be.myitworld.smartkitchen.acitivities;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import be.myitworld.smartkitchen.R;
import be.myitworld.smartkitchen.fragments.RecipesListFragment;
import be.myitworld.smartkitchen.fragments.CategoriesFragment;
import be.myitworld.smartkitchen.fragments.FavoritesFragment;
import be.myitworld.smartkitchen.fragments.HomeFragment;
import be.myitworld.smartkitchen.fragments.RecipeFragment;
import be.myitworld.smartkitchen.tools.Manager;
import be.myitworld.smartkitchen.tools.RootActivity;
import be.myitworld.smartkitchen.tools.Utils;

public class MainActivity extends RootActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static Class fragmentClass = RecipesListFragment.class;
    private Fragment fragment;
    public static String CURRENT_FRAGMENT = "";
    public static int MENU_POSITION;


    @Override
    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        replaceFragment (fragmentClass);

        Toolbar toolbar = (Toolbar) findViewById (R.id.toolbar);
        setSupportActionBar (toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById (R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle (
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener (toggle);
        toggle.syncState ();

        NavigationView navigationView = (NavigationView) findViewById (R.id.nav_view);
        navigationView.setNavigationItemSelectedListener (this);
    }


    @Override
    public void onBackPressed () {

        DrawerLayout drawer = (DrawerLayout) findViewById (R.id.drawer_layout);
        if (drawer.isDrawerOpen (GravityCompat.START)) {
            drawer.closeDrawer (GravityCompat.START);
        }
        if (Utils.BACK_PRESSED_TWICE_TO_EXIT || CURRENT_FRAGMENT.equals (Utils.FRAGMENT_RECIPELIST_RECIPE)
                || CURRENT_FRAGMENT.equals (Utils.FRAGMENT_CATEGORY_RECIPELIST) && MENU_POSITION == 2
                || CURRENT_FRAGMENT.equals (Utils.FRAGMENT_FAVORITES_RECIPE)) {
            if (CURRENT_FRAGMENT.equals (Utils.FRAGMENT_CATEGORY_RECIPELIST) && MENU_POSITION == 2) {
                CURRENT_FRAGMENT = Utils.FRAGMENT_CATEGORIES;
            }
            if (CURRENT_FRAGMENT.equals (Utils.FRAGMENT_RECIPELIST_RECIPE) && MENU_POSITION == 2) {
                CURRENT_FRAGMENT = Utils.FRAGMENT_CATEGORY_RECIPELIST;
            }
            if (CURRENT_FRAGMENT.equals (Utils.FRAGMENT_RECIPELIST_RECIPE) && MENU_POSITION == 5) {
                CURRENT_FRAGMENT = Utils.FRAGMENT_ALL_RECIPES_LIST;
            }
            if (CURRENT_FRAGMENT.equals (Utils.FRAGMENT_FAVORITES_RECIPE) && MENU_POSITION == 3) {
                CURRENT_FRAGMENT = Utils.FRAGMENT_FAVORITES;
            }
            super.onBackPressed ();
            MainActivity.fragmentClass = null;
            return;
        }
        if (CURRENT_FRAGMENT.equals (Utils.FRAGMENT_CATEGORIES) && MENU_POSITION == 2
                || CURRENT_FRAGMENT.equals (Utils.FRAGMENT_FAVORITES) && MENU_POSITION == 3
                || CURRENT_FRAGMENT.equals (Utils.FRAGMENT_RECIPELIST) && MENU_POSITION == 1
                || CURRENT_FRAGMENT.equals (Utils.FRAGMENT_ALL_RECIPES_LIST) && MENU_POSITION == 5
                || CURRENT_FRAGMENT == Utils.FRAGMENT_FAVORITES && MENU_POSITION == 3) {
            Utils.BACK_PRESSED_TWICE_TO_EXIT = true;
            Utils.createToast (this, "Press back again to exit the app.");
            new Handler ().postDelayed (new Runnable () {

                @Override
                public void run () {

                    Utils.BACK_PRESSED_TWICE_TO_EXIT = false;
                }
            }, 2000);
        }
    }

    @SuppressWarnings ("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected (MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId ();

        if (id == R.id.nav_home) {
            fragmentClass = HomeFragment.class;
            MENU_POSITION = 0;
        } else if (id == R.id.nav_by_ingredients) {
            MENU_POSITION = 1;
        } else if (id == R.id.nav_by_category) {
            fragmentClass = CategoriesFragment.class;
            MENU_POSITION = 2;
        } else if (id == R.id.nav_favorites) {
            fragmentClass = FavoritesFragment.class;
            MENU_POSITION = 3;
        } else if (id == R.id.nav_worlds_best) {
            MENU_POSITION = 4;
        } else if (id == R.id.nav_all_recipes) {
            RecipesListFragment.recipes = Manager.getInstance ().recipes;
            fragmentClass = RecipesListFragment.class;
            MENU_POSITION = 5;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById (R.id.drawer_layout);
        drawer.closeDrawer (GravityCompat.START);

        // Insert the fragment by replacing any existing fragment-
        replaceFragment (fragmentClass);
        // Highlight the selected item, update the title, and close the drawer
        setTitle (item.getTitle ());

        return true;
    }

    public void replaceFragment (Class fragmentClass) {

        try {
            this.fragmentClass = fragmentClass;
            fragment = (Fragment) fragmentClass.newInstance ();
            FragmentManager fragmentManager = getSupportFragmentManager ();
            if (fragmentClass.getName ().equals ("be.myitworld.smartkitchen.fragments.RecipeFragment") || CURRENT_FRAGMENT == Utils.FRAGMENT_CATEGORY_RECIPELIST
                    && fragmentClass == RecipesListFragment.class) {
                fragmentManager.beginTransaction ().setCustomAnimations (R.anim.anim_slide_in_left, R.anim.anim_slide_out_right, R.anim.anim_slide_in_left, R.anim.anim_slide_out_right).replace (R.id.main_frameLayoutContent, fragment).addToBackStack (null).commit ();
            } else {
                fragmentManager.beginTransaction ().setCustomAnimations (R.anim.anim_slide_in_left, R.anim.anim_slide_out_left, R.anim.anim_slide_in_right, R.anim.anim_slide_out_right).replace (R.id.main_frameLayoutContent, fragment).commit ();
            }
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }

    @Override
    protected void onDestroy () {

        super.onDestroy ();
    }
}
