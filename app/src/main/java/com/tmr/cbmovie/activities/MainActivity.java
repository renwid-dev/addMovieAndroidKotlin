package com.tmr.cbmovie.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;

import com.tmr.cbmovie.R;
import com.tmr.cbmovie.fragment.FragmentFavorite;
import com.tmr.cbmovie.fragment.FragmentMovie;
import com.tmr.cbmovie.fragment.FragmentTV;
import com.tmr.cbmovie.utils.BottomBarBehavior;
import com.gauravk.bubblenavigation.BubbleNavigationLinearView;
import com.gauravk.bubblenavigation.listener.BubbleNavigationChangeListener;
/**
 * Created by temanrendy
 */
public class MainActivity extends AppCompatActivity {

    Fragment fragment = null;
    ImageView imgNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary));
        }

        imgNotification = findViewById(R.id.imgNotification);
        imgNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });

//        BubbleNavigationLinearView navigationBar = findViewById(R.id.navigatorBar);

//        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) navigationBar.getLayoutParams();
//        layoutParams.setBehavior(new BottomBarBehavior());
//
//        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new FragmentMovie()).commit();

//        navigationBar.setNavigationChangeListener(new BubbleNavigationChangeListener() {
//            @Override
//            public void onNavigationChanged(View view, int position) {
//                switch (position) {
//                    case 0:
//                        fragment = new FragmentMovie();
//                        break;
//                    case 1:
//                        fragment = new FragmentTV();
//                        break;
//                    case 2:
//                        fragment = new FragmentFavorite();
//                        break;
//                }
////                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).commit();
//            }
//        });
    }

    public static void setWindowFlag(Activity activity, final int bits, boolean on) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams winParams = window.getAttributes();
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        window.setAttributes(winParams);
    }
}
