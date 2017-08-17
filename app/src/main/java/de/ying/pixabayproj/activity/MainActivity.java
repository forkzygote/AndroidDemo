package de.ying.pixabayproj.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.ying.pixabayproj.Pixabay;
import de.ying.pixabayproj.R;
import de.ying.pixabayproj.base.BaseMvpActivity;
import de.ying.pixabayproj.common.adapter.PixabayAdapter;
import de.ying.pixabayproj.data.model.Hit;
import de.ying.pixabayproj.data.model.PixabayMessage;
import de.ying.pixabayproj.injection.Component.DaggerPixabayComponent;
import de.ying.pixabayproj.injection.module.PixabayModule;
import de.ying.pixabayproj.mvp.Presenter.MainPresenter;
import de.ying.pixabayproj.mvp.View.MainView;
import de.ying.pixabayproj.utils.Constants;
import de.ying.pixabayproj.utils.PreferenceUtil;

public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainView {

    private static final String SHOW_DIALOG = "SHOW_DIALOG";
    private static final String HIT_POSITION = "HIT_POSITION";
    private static final String QUERY = "QUERY";
    private String queryStr;
    boolean isShowDialog = false;
    int hit_position = 0;
    Context context;
    EditText queryEditText;
    Button mButtonGo;
    RecyclerView mRecyclerView;
    PixabayAdapter mAdapter;
    List<Hit> hitList = new ArrayList<>();
    PixabayAdapter.HitItemListener mItemListener = hitPosition -> showDetailDialog(hitPosition);

    @Override
    protected void injectComponent() {
        DaggerPixabayComponent.builder()
                .applicationComponent(getApplicationComponent())
                .pixabayModule(new PixabayModule()).
                build().
                inject(this);
        mPresenter.setView(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        context = this;
        mRecyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        mAdapter = new PixabayAdapter(hitList, mItemListener);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        queryEditText = (EditText) findViewById(R.id.query_edit);
        mButtonGo = (Button) findViewById(R.id.go_btn);
        mButtonGo.setOnClickListener(view -> {
            queryStr = String.valueOf(queryEditText.getText());
            mPresenter.getImage(setSearchMap(queryStr),this);  // query search
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(queryStr==null) {
            queryStr = "fruit";
            mPresenter.getImage(setSearchMap(queryStr),this);  // query search
        }
    }

    private HashMap<String, String> setSearchMap(String q){
        HashMap<String, String> map = new HashMap<>();
        map.put("image_type", "all");
        map.put("page", "1");
        map.put("q", q);
        map.put("key", Constants.API_KEY);
        return map;
    }

    /**
     * Method serve as Success Callback
     * @param message PixabayMessage
     */
    @Override
    public void getImageSuc(PixabayMessage message) {
        List<Hit> hits = message.getHits();
        hitList.clear();
        hitList.addAll(hits);
        mAdapter.notifyDataSetChanged();
        PreferenceUtil.setString(Pixabay.getContext(), Constants.SHARED_PREFERENCES, Constants.CACHE, message.hits2JSON().toString());
    }

    /**
     * Method for special error handling
     * @param e Throwable
     */
    @Override
    public void getImageFail(Throwable e) {
        showCache();
    }

    /**
     * Method show cache when there is no internet
     */
    @Override
    public void noInternet() {
        showCache();
    }

    /**
     * Method show detail dialog
     * @param position
     */
    @Override
    public void showDetailDialog(int position) {
        isShowDialog = true;
        hit_position = position;
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(context);
        }
        builder.setTitle("Detail")
                .setMessage("Want to see the details?")
                .setPositiveButton(android.R.string.yes, (dialog, which) -> {
                    mPresenter.openHitDetail(position);
                    isShowDialog = false;
                })
                .setNegativeButton(android.R.string.no, (dialog, which) -> {
                    isShowDialog = false;
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    /**
     * Method start DetailActivity
     * @param position
     */
    @Override
    public void openHitDetailUtil(int position){
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(Constants.HIT_POSITION, position);
        startActivity(intent);
    }

    private void showCache(){
        if(hitList.isEmpty()){
            String cache = PreferenceUtil.getString(Pixabay.getContext(), Constants.SHARED_PREFERENCES, Constants.CACHE, "");
            JsonParser parser = new JsonParser();
            JsonElement tradeElement = parser.parse(cache);
            JsonArray hitsJA = tradeElement.getAsJsonArray();
            for (JsonElement hitJE : hitsJA) {
                Hit hit = new Hit();
                hit.setPreviewURL(hitJE.getAsJsonObject().get("previewURL").getAsString());
                hit.setUser(hitJE.getAsJsonObject().get("user").getAsString());
                hit.setTags(hitJE.getAsJsonObject().get("tags").getAsString());
                hitList.add(hit);
            }
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(SHOW_DIALOG, isShowDialog);
        outState.putInt(HIT_POSITION, hit_position);
        outState.putString(QUERY, queryStr);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        queryStr = savedInstanceState.getString(QUERY);
        mPresenter.getImage(setSearchMap(queryStr),this);  // default search
        if(savedInstanceState.getBoolean(SHOW_DIALOG)){
            showDetailDialog(savedInstanceState.getInt(HIT_POSITION, 0));
        }
    }
}

