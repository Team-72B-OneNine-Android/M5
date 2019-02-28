package onenine.android.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import onenine.android.R;

public class TradeGoodsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trade_goods);
    }

    public void onBackButtonPressed(View view) {
        Intent back = new Intent(this, MarketPlaceActivity.class);
        startActivity(back);
    }
}
