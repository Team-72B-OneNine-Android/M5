package onenine.android.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;

import onenine.android.Model.Facade;
import onenine.android.Model.Goods;
import onenine.android.Model.Ship;
import onenine.android.R;

public class MarketPlaceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_place);

//        TextView textView = findViewById(R.id.current_good);
//        textView.setText("Goods currently on the ship: ");



    }

    public void onBackButtonPressed(View view) {
        Intent back = new Intent(this, HomeScreenActivity.class);
        startActivity(back);
    }


    public void onTradeGoodsButtonPressed(View view) {
        Intent tradeGoods = new Intent(this, TradeGoodsActivity.class);
        startActivity(tradeGoods);
    }
}
