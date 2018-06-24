package io.github.vinge1718.weather.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.vinge1718.weather.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.locationEditText) EditText mLocationEditText;
    @BindView(R.id.appName) TextView mAppName;
    @BindView(R.id.checkForeCast) Button mCheckForecast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Typeface dancingScriptFont = Typeface.createFromAsset(getAssets(), "fonts/DancingScript-Regular.otf");
        mAppName.setTypeface(dancingScriptFont);

        mCheckForecast.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v == mCheckForecast){
            Intent intent = new Intent(MainActivity.this, WeatherListActivity.class);
            String mLocation = mLocationEditText.getText().toString();
            intent.putExtra("location", mLocation);
            startActivity(intent);
        }
    }
}
