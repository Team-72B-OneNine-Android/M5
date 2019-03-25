package onenine.android.View;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import onenine.android.R;
import onenine.android.ViewModel.MarketPlaceActivityViewModel;

public class MarketPlaceActivity extends AppCompatActivity {

    private TextView currentGoodsList;
    private TextView goodsProducedOnPlanet;
    private TextView goodsUsedOnPlanet;
    private MarketPlaceActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        viewModel = ViewModelProviders.of(this).get(MarketPlaceActivityViewModel.class);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_place);

        TextView textView = findViewById(R.id.current_good);
        textView.setText("Goods currently on the ship: ");

        currentGoodsList = findViewById(R.id.current_good_list);
        currentGoodsList.setText(viewModel.getShip().currentGoods());

        TextView textView1 = findViewById(R.id.goodsPro);
        textView1.setText("Goods produced/sold on the current planet: ");

        goodsProducedOnPlanet = findViewById(R.id.goods_produced);
        goodsProducedOnPlanet.setText(viewModel.getPlanet().goodsProduced());

        TextView textView2 = findViewById(R.id.goodsUsed);
        textView2.setText("Goods used/bought on current planet: ");

        goodsUsedOnPlanet = findViewById(R.id.goods_sold);
        goodsUsedOnPlanet.setText(viewModel.getPlanet().goodsUsed());

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
