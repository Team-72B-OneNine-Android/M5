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

/**
 * Class that represents the view for the trade goods activity
 */
public class TradeGoodsActivity extends AppCompatActivity {

    private GoodsViewModel viewModel;
    private TextView creditsAvailable;
    private TextView cargoSpaceAvailable;

    /**
     * Creates the view
     *
     * @param savedInstanceState the saved instance of game
     */
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

        RecyclerView recyclerView = findViewById(R.id.goods_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        viewModel = ViewModelProviders.of(this).get(GoodsViewModel.class);

        GoodsAdapter adapter = new GoodsAdapter(viewModel.getGame(), this);
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

    /**
     * Switches the view back to market place activity and takes player to market place
     *
     * @param view the view
     */
    public void onBackButtonPressed(View view) {
        Intent back = new Intent(this, MarketPlaceActivity.class);
        startActivity(back);

    }

    /**
     * Displays the updated credits for the player once he or she buys or sells an item
     */
    public void updateCreditsAvailable() {
        creditsAvailable.setText(String.valueOf(viewModel.getCredits()));
    }

    /**
     * Displays the updated cargo space available for the player once he or she buys or sells an item
     */
    public void updateCargoSpaceAvailable() {
        cargoSpaceAvailable.setText(String.valueOf(viewModel.getCargoSpaceAvailable()));
    }

}
