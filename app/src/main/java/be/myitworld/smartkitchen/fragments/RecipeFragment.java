package be.myitworld.smartkitchen.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import be.myitworld.smartkitchen.R;
import be.myitworld.smartkitchen.adapters.MyTabsPagerAdapter;
import be.myitworld.smartkitchen.model.Recipe;

/**
 * Created by Jorciney on 21/05/2016.
 */
public class RecipeFragment extends Fragment implements BaseSliderView.OnSliderClickListener {

    public static Recipe recipe;
    private SliderLayout sliderLayout;
    private Toast mToast;
    private MyTabsPagerAdapter myTabsPagerAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_recipe, container, false);

        //Tab swiper
        myTabsPagerAdapter = new MyTabsPagerAdapter(getActivity().getSupportFragmentManager());
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        viewPager.setAdapter(myTabsPagerAdapter);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.viewpagertab);
        tabLayout.setupWithViewPager(viewPager);


        //Image Slider
        sliderLayout = (SliderLayout) view.findViewById(R.id.recipe_image_slider);
        //set the type of animation
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        //Page indicator
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(5000);
        sliderLayout.addOnPageChangeListener(new ViewPagerEx.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        if (recipe != null) {

            for (String img : recipe.getImages()) {
                DefaultSliderView sliderView = new DefaultSliderView(getActivity().getApplicationContext());
                //Initialize SliderLayout
                sliderView.image(img).error(R.drawable.ic_error).setScaleType(BaseSliderView.ScaleType.Fit);
                sliderLayout.addSlider(sliderView);
            }
        }

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.floating_button_edit_recipe);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        return view;
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
    }

    @Override
    public void onStop() {
        sliderLayout.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getActivity().setTitle("All Recipes");
    }

    private void showToast(String text) {
        if (mToast != null) {
            mToast.cancel();
        }
        mToast = Toast.makeText(getActivity(), text, Toast.LENGTH_LONG);
        mToast.show();
    }

}
