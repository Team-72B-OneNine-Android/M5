package onenine.android.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.arch.lifecycle.ViewModelProviders;
import android.widget.TextView;

import onenine.android.Model.Facade;
import onenine.android.R;
import onenine.android.ViewModel.GoodsViewModel;

public class TradeGoodsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GoodsAdapter adapter;
    private GoodsViewModel viewModel;
    private TextView infoHolder;
    private TextView noHave;
    private TextView buy;
    private TextView sell;
    private TextView buyPrice;
    private TextView sellPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trade_goods);

        infoHolder = findViewById(R.id.info_holder);
        infoHolder.setText("Goods");

        noHave = findViewById(R.id.no_have);
        noHave.setText("On Ship");

        buy = findViewById(R.id.buy);
        buy.setText("Buy");

        sell = findViewById(R.id.sell);
        sell.setText("Sell");

        buyPrice = findViewById(R.id.buy_price);
        buyPrice.setText("Buy Price");

        sellPrice = findViewById(R.id.sell_price);
        sellPrice.setText("Sell Price");

        recyclerView = findViewById(R.id.goods_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        viewModel = ViewModelProviders.of(this).get(GoodsViewModel.class);

        adapter = new GoodsAdapter(viewModel.getGame());
        recyclerView.setAdapter(adapter);

    }

    public void onBackButtonPressed(View view) {
        Intent back = new Intent(this, MarketPlaceActivity.class);
        startActivity(back);
    }

}
