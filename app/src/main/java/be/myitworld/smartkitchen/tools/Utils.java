package be.myitworld.smartkitchen.tools;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import java.security.SecureRandom;

import be.myitworld.smartkitchen.model.Recipe;

/**
 * Created by Jorciney on 22/05/2016.
 */
public class Utils {
    public static Recipe recipe;
    public static boolean SEARCH_ACTIVE=false;
    public static boolean BACK_PRESSED_TWICE_TO_EXIT=false;




    public static int getRandomColor() {
        SecureRandom rgen = new SecureRandom();
        return Color.HSVToColor(150, new float[]{
                rgen.nextInt(359), 1, 1
        });
    }
    public static void createToast(Context context, String s) {
        Toast.makeText(context, s, Toast.LENGTH_LONG).show();
    }

}
