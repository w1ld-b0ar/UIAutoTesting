package com.example.UIAutoTesting;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

/**
 Created with IntelliJ IDEA. User: w1ld.b0ar Date: 29.06.13 Time: 22:22

 @author Blaschuk Anton (w1ld.b0ar100500@gmail.com) */
public abstract class PictureActivity extends Activity {
    protected abstract int getImageResourceId();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.picture);
        ((ImageView) findViewById(R.id.picture)).setImageResource(getImageResourceId());
    }
}
