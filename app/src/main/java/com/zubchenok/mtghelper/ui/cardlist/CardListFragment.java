package com.zubchenok.mtghelper.ui.cardlist;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.zubchenok.mtghelper.R;
import com.zubchenok.mtghelper.model.dto.Card;
import com.zubchenok.mtghelper.ui.base.BaseFragment;
import com.zubchenok.mtghelper.util.Const;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CardListFragment extends BaseFragment implements CardListContract.View {
    public static final String TAG = "CARD_LIST_FRAGMENT";

    private CardListPresenter presenter;
    private ArrayList<Card> cards;
    private LayoutInflater layoutInflater;
    @BindView(R.id.rec_card_list)
    public RecyclerView recyclerView;

    public CardListFragment() {
        // Required empty public constructor
    }

    public static CardListFragment newInstance() {
        return new CardListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_card_list, container, false);
        ButterKnife.bind(this, v);

        cards = getArguments().getParcelableArrayList(Const.Extra.CARDS);
        layoutInflater = getActivity().getLayoutInflater();
        presenter = new CardListPresenter(this, cards);
        return v;
    }

    @Override
    public void openCardDetailsActivity(Card card) {
        navigateToCardDetailsFragment(card);
    }

    @Override
    public void setUpAdapterAndView(ArrayList<Card> cards) {
        this.cards = cards;
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(new CardAdapter());
    }

    public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {

        @Override
        public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = layoutInflater.inflate(R.layout.item_card, parent, false);
            return new CardViewHolder(v);
        }

        @Override
        public void onBindViewHolder(final CardViewHolder holder, int position) {
            String imageUrl = cards.get(position).getImageUrl();
            Glide
                    .with(getContext())
                    .load(imageUrl)
                    .listener(new RequestListener<String, GlideDrawable>() {
                        @Override
                        public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                            holder.progressBar.setVisibility(View.GONE);
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                            holder.progressBar.setVisibility(View.GONE);
                            return false;
                        }
                    })
                    .error(R.color.colorAccent)
                    .crossFade()
                    .into(holder.cardImage);
        }

        @Override
        public int getItemCount() {
            return cards.size();
        }

        class CardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            @BindView(R.id.imv_card_item)
            ImageView cardImage;
            @BindView(R.id.prb_card_item)
            ProgressBar progressBar;
            @BindView(R.id.root_card_item)
            ConstraintLayout container;


            public CardViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
                container.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                Card card = cards.get(getAdapterPosition());
                presenter.onCardItemClicked(card);
            }
        }
    }
}
