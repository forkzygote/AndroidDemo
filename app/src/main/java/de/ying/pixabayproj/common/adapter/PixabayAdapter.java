package de.ying.pixabayproj.common.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.ying.pixabayproj.Pixabay;
import de.ying.pixabayproj.R;
import de.ying.pixabayproj.data.model.Hit;

public class PixabayAdapter extends RecyclerView.Adapter<PixabayAdapter.HitViewHolder>{
    private List<Hit> hitsList;
    HitItemListener hitItemListener;

    public PixabayAdapter(List<Hit> hitsList, HitItemListener hitItemListener) {
        this.hitsList = hitsList;
        this.hitItemListener = hitItemListener;
    }

    @Override
    public HitViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_hit, parent, false);
        return new HitViewHolder(itemView, hitItemListener);
    }

    @Override
    public void onBindViewHolder(HitViewHolder holder, int position) {
        Hit hit = hitsList.get(position);
        holder.userNameTextView.setText(String.format(Pixabay.getContext().getString(R.string.user), hit.getUser()));
        holder.tagsTextView.setText(String.format(Pixabay.getContext().getString(R.string.tags), hit.getTags()));

        Glide.with(Pixabay.getContext()).load(hit.getPreviewURL()).fitCenter().into(holder.thumbNail);
    }

    @Override
    public int getItemCount() {
        return hitsList.size();
    }

    static class HitViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public CardView cardView;
        public ImageView thumbNail;
        public TextView userNameTextView;
        public TextView tagsTextView;
        private HitItemListener mItemListener;

        public HitViewHolder(View itemView, HitItemListener listener) {
            super(itemView);
            mItemListener = listener;
            cardView = (CardView) itemView.findViewById(R.id.cardview);
            thumbNail = (ImageView) itemView.findViewById(R.id.thumbnail);
            userNameTextView = (TextView) itemView.findViewById(R.id.username_label);
            tagsTextView = (TextView) itemView.findViewById(R.id.tags_label);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int hitPosition = getAdapterPosition();
            mItemListener.onHitClick(hitPosition);
        }
    }

    public interface HitItemListener{
        void onHitClick(int hitPosition);
    }
}

