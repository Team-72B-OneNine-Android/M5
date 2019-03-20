package onenine.android.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import onenine.android.R;

public class ShipYardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ship_yard);
    }

    public void onBackPressed(View view) {
        Intent back = new Intent(this, HomeScreenActivity.class);
        startActivity(back);
    }
}
