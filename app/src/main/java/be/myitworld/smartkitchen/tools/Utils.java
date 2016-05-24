package be.myitworld.smartkitchen.tools;

import android.app.Activity;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;

import java.security.SecureRandom;

import be.myitworld.smartkitchen.model.Recipe;

/**
 * Created by Jorciney on 22/05/2016.
 */
public class Utils {
    public static Recipe recipe;
    public static boolean SEARCH_ACTIVE=false;




    public static int getRandomColor() {
        SecureRandom rgen = new SecureRandom();
        return Color.HSVToColor(150, new float[]{
                rgen.nextInt(359), 1, 1
        });
    }
}
