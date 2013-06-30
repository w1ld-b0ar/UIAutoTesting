package com.example.UIAutoTesting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.HashMap;
import java.util.Map;

public class RootActivity extends Activity {
    private static final String TAG = "RootActivity";
    private static final Map<Integer, Class> buttonToActivityMap = new HashMap<Integer, Class>(){
        {
            put(R.id.first_button, FirstActivity.class);
            put(R.id.second_button, SecondActivity.class);
            put(R.id.third_button, ThirdActivity.class);
        }
    };

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        for (Integer viewId : buttonToActivityMap.keySet()) {
            findViewById(viewId).setOnClickListener(new OnClickListenerMovingToOtherActivity(buttonToActivityMap.get(viewId)));
        }
    }

    private class OnClickListenerMovingToOtherActivity implements View.OnClickListener {
        private final Class classOfActivityToBeMovedTo;

        private OnClickListenerMovingToOtherActivity(Class classOfActivityToBeMovedTo) {
            this.classOfActivityToBeMovedTo = classOfActivityToBeMovedTo;
        }

        @Override
        public void onClick(View view) {
            Log.d(TAG, "starting " + classOfActivityToBeMovedTo.getSimpleName());
            startActivity(new Intent(RootActivity.this, classOfActivityToBeMovedTo));
        }
    }
}
