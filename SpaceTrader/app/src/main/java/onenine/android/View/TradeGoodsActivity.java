package onenine.android.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.arch.lifecycle.ViewModelProviders;
import onenine.android.R;
import onenine.android.ViewModel.GoodsViewModel;

public class TradeGoodsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GoodsAdapter adapter;
    private GoodsViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trade_goods);

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

    public void onSellClicked(View view) {

    }

    public void onBuyClicked() {

    }

}
