package be.myitworld.smartkitchen.tools;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;
import java.util.Locale;

import be.myitworld.smartkitchen.R;

/**
 * Created by Jorciney on 8/05/2016.
 */
public class RootActivity extends AppCompatActivity {


    int onStartCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        onStartCount = 1;
        if (savedInstanceState == null) // 1st time
        {
            this.overridePendingTransition(R.anim.anim_slide_in_left,
                    R.anim.anim_slide_out_left);
        } else // already created so reverse animation
        {
            onStartCount = 2;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (onStartCount > 1) {
//            this.overridePendingTransition(R.anim.anim_slide_in_right,
//                    R.anim.anim_slide_out_right);

            this.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);


        } else if (onStartCount == 1) {
            onStartCount++;
        }
    }


    private void createToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }

    private void setNewIntent(Class intentClass) {
        Intent intent = new Intent(this, intentClass);
        startActivity(intent);
    }

}

