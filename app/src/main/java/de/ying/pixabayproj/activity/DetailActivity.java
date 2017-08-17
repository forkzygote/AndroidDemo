package de.ying.pixabayproj.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import de.ying.pixabayproj.R;
import de.ying.pixabayproj.base.BaseCompatActivity;
import de.ying.pixabayproj.utils.Constants;
import de.ying.pixabayproj.utils.PreferenceUtil;

public class DetailActivity extends BaseCompatActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_detail;
    }

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        int position = this.getIntent().getExtras().getInt(Constants.HIT_POSITION);
        String hitsStr = PreferenceUtil.getString(this, Constants.SHARED_PREFERENCES, Constants.CACHE, "");
        JsonParser parser = new JsonParser();
        JsonElement tradeElement = parser.parse(hitsStr);
        JsonArray hitsJA = tradeElement.getAsJsonArray();

        ImageView biggerImageView = (ImageView) findViewById(R.id.bigger_image);
        TextView userNameTextView = (TextView) findViewById(R.id.username_label);
        TextView tagsTextView = (TextView) findViewById(R.id.tags_label);
        TextView likesTextView = (TextView) findViewById(R.id.likes_label);
        TextView favoritesTextView = (TextView) findViewById(R.id.favorites_label);
        TextView commentsTextView = (TextView) findViewById(R.id.comments_label);

        Glide.with(this).load(hitsJA.get(position).getAsJsonObject().get("webformatURL").getAsString()).fitCenter().into(biggerImageView);
        userNameTextView.setText(String.format(getString(R.string.user), hitsJA.get(position).getAsJsonObject().get("user").getAsString()));
        tagsTextView.setText(String.format(getString(R.string.tags), hitsJA.get(position).getAsJsonObject().get("tags").getAsString()));
        likesTextView.setText(String.format(getString(R.string.likes), hitsJA.get(position).getAsJsonObject().get("likes").getAsInt()));
        favoritesTextView.setText(String.format(getString(R.string.favorite), hitsJA.get(position).getAsJsonObject().get("favorites").getAsInt()));
        commentsTextView.setText(String.format(getString(R.string.comments), hitsJA.get(position).getAsJsonObject().get("comments").getAsInt()));
    }

}
