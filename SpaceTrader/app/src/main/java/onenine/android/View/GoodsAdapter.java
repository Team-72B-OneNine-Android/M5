package onenine.android.View;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

import onenine.android.Model.Game;
import onenine.android.Model.Goods;
import onenine.android.Model.Player;
import onenine.android.Model.Ship;
import onenine.android.R;

public class GoodsAdapter extends RecyclerView.Adapter<GoodsAdapter.GoodsViewHolder> {

    private HashMap<Goods, Integer> goods;
    private Goods[] goodsList;
    private Game game;
    private Player player;
    private Ship ship;
    private TradeGoodsActivity activity;

    public GoodsAdapter (Game game, TradeGoodsActivity activity) {
        this.game = game;
        this.player = this.game.getPlayer();
        this.ship = this.player.getShip();
        this.goods = this.ship.getTradeGoods();
        this.goodsList = Goods.values();
        this.activity = activity;
    }

    @NonNull
    @Override
    public GoodsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.goods_item, parent, false);

        return new GoodsViewHolder(itemView);
    }

    public void onBindViewHolder(@NonNull GoodsViewHolder holder, int position) {

        holder.goodName.setText(goodsList[position].getName());
        holder.numberHave.setText(String.valueOf(goods.get(goodsList[position])));
        holder.buyButton.setText("Buy");
        holder.sellButton.setText("Sell");
        holder.goodBuyPrice.setText(goodsList[position].buyStringPrice());
        holder.goodSellPrice.setText(goodsList[position].sellStringPrice());

    }


    class GoodsViewHolder extends RecyclerView.ViewHolder {

        private TextView goodName;
        private TextView numberHave;
        private Button buyButton;
        private Button sellButton;
        private TextView goodBuyPrice;
        private TextView goodSellPrice;

        public GoodsViewHolder(@NonNull final View itemView) {

            super(itemView);
            goodName = itemView.findViewById(R.id.good_name);
            numberHave = itemView.findViewById(R.id.good_number_have);
            buyButton = itemView.findViewById(R.id.buy_button);
            sellButton = itemView.findViewById(R.id.sell_button);
            goodBuyPrice = itemView.findViewById(R.id.good_buy_price);
            goodSellPrice = itemView.findViewById(R.id.good_sell_price);
            buyButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Goods currentGood = goodsList[position];
                    if (currentGood.canBuy()) {
                        if (player.getCredits() >= currentGood.getPrice() &&
                        ship.cargoSpaceAvailable()) {
                            goods.put(currentGood, goods.get(currentGood) + 1);
                            player.changeCredits(-currentGood.getPrice());
                            ship.setCargoUsed(ship.getCargoUsed() + 1);
                            numberHave.setText(String.valueOf(goods.get(goodsList[getAdapterPosition()])));
                            activity.updateCreditsAvailable();
                            activity.updateCargoSpaceAvailable();
                        } else if (!ship.cargoSpaceAvailable()) {
                            Toast.makeText(itemView.getContext(), "There is no more cargo space",
                                    Toast.LENGTH_LONG).show();
                        } else if (player.getCredits() < currentGood.getPrice()) {
                            Toast.makeText(itemView.getContext(), "Not enough credits to " +
                                    "buy this good", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(itemView.getContext(), "This good is not " +
                                "produced on the current planet", Toast.LENGTH_LONG).show();
                    }
                }
            });
            sellButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Goods currentGood = goodsList[position];
                    if (currentGood.canSell()) {
                        if (goods.get(currentGood) > 0) {
                            goods.put(currentGood, goods.get(currentGood) - 1);
                            player.changeCredits(currentGood.getPrice());
                            ship.setCargoUsed(ship.getCargoUsed() - 1);
                            numberHave.setText(String.valueOf(goods.get(goodsList[getAdapterPosition()])));
                            activity.updateCreditsAvailable();
                            activity.updateCargoSpaceAvailable();
                        } else {
                            Toast.makeText(itemView.getContext(), "There is no '" + currentGood.getName()
                            + "' on the ship", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(itemView.getContext(), "this good is not used on the " +
                                "current planet", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

    public int getItemCount() {
        return this.goods.size();
    }

    public HashMap<Goods, Integer> getGoods() {
        return goods;
    }

    public void setGoods(HashMap<Goods, Integer> goods) {
        this.goods = goods;
    }

    public Goods[] getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(Goods[] goodsList) {
        this.goodsList = goodsList;
    }

}
