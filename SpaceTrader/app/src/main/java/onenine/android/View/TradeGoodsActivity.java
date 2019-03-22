package onenine.android.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.arch.lifecycle.ViewModelProviders;
import android.widget.TextView;

import onenine.android.R;
import onenine.android.ViewModel.GoodsViewModel;

public class TradeGoodsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GoodsAdapter adapter;
    private GoodsViewModel viewModel;
    private TextView creditsAvailable;
    private TextView cargoSpaceAvailable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trade_goods);

        TextView infoHolder = findViewById(R.id.info_holder);
        infoHolder.setText("Goods");

        TextView noHave = findViewById(R.id.no_have);
        noHave.setText("On Ship");

        TextView buy = findViewById(R.id.buy);
        buy.setText("Buy");

        TextView sell = findViewById(R.id.sell);
        sell.setText("Sell");

        TextView buyPrice = findViewById(R.id.buy_price);
        buyPrice.setText("Buy Price");

        TextView sellPrice = findViewById(R.id.sell_price);
        sellPrice.setText("Sell Price");

        recyclerView = findViewById(R.id.goods_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        viewModel = ViewModelProviders.of(this).get(GoodsViewModel.class);

        adapter = new GoodsAdapter(viewModel.getGame(), this);
        recyclerView.setAdapter(adapter);

        TextView credits = findViewById(R.id.info);
        credits.setText("Credits Available: ");

        creditsAvailable = findViewById(R.id.credits_available);
        creditsAvailable.setText(String.valueOf(viewModel.getCredits()));

        TextView cargoSpace = findViewById(R.id.cargo_space);
        cargoSpace.setText("Cargo Space Available: ");

        cargoSpaceAvailable = findViewById(R.id.cargo_space_available);
        cargoSpaceAvailable.setText(String.valueOf(viewModel.getCargoSpaceAvailable()));

    }

    public void onBackButtonPressed(View view) {
        Intent back = new Intent(this, MarketPlaceActivity.class);
        startActivity(back);

    }

    public void updateCreditsAvailable() {
        creditsAvailable.setText(String.valueOf(viewModel.getCredits()));
    }

    public void updateCargoSpaceAvailable() {
        cargoSpaceAvailable.setText(String.valueOf(viewModel.getCargoSpaceAvailable()));
    }

}
