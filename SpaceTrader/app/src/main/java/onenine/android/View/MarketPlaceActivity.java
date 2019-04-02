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

    /**
     * Creates view for market place
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        MarketPlaceActivityViewModel viewModel = ViewModelProviders.of(this).get(MarketPlaceActivityViewModel.class);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_place);

        TextView textView = findViewById(R.id.current_good);
        textView.setText("Goods currently on the ship: ");

        TextView currentGoodsList = findViewById(R.id.current_good_list);
        currentGoodsList.setText(viewModel.getCurrentGoods());

        TextView textView1 = findViewById(R.id.goodsPro);
        textView1.setText("Goods produced/sold on the current planet: ");

        TextView goodsProducedOnPlanet = findViewById(R.id.goods_produced);
        goodsProducedOnPlanet.setText(viewModel.getGoodsProduced());

        TextView textView2 = findViewById(R.id.goodsUsed);
        textView2.setText("Goods used/bought on current planet: ");

        TextView goodsUsedOnPlanet = findViewById(R.id.goods_sold);
        goodsUsedOnPlanet.setText(viewModel.getGoodsUsed());

    }

    /**
     * Switches view back to home screen activity and takes player to home screen
     * @param view
     */
    public void onBackButtonPressed(View view) {
        Intent back = new Intent(this, HomeScreenActivity.class);
        startActivity(back);
    }

    /**
     * Switches view to trade goods activity
     *
     * @param view
     */
    public void onTradeGoodsButtonPressed(View view) {
        Intent tradeGoods = new Intent(this, TradeGoodsActivity.class);
        startActivity(tradeGoods);
    }
}
