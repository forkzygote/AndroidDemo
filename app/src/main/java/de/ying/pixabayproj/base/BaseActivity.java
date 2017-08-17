package de.ying.pixabayproj.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import de.ying.pixabayproj.common.AppManager;
import de.ying.pixabayproj.injection.Component.ApplicationComponent;
import de.ying.pixabayproj.injection.module.ActivityModule;

/**
 * Base BaseActivity
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getAppManager().addActivity(this);
        this.getApplicationComponent().inject(this);
    }

    @Override
    protected void onDestroy() {
        AppManager.getAppManager().finishActivity(this);
        super.onDestroy();
    }

    /**
     * Get the Main Application component for dependency injection.
     */
    protected ApplicationComponent getApplicationComponent() {
        return ((BaseApplication) getApplication()).getApplicationComponent();
    }

    /**
     * Get an Activity module for dependency injection.
     */
    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    private ProgressDialog progressDialog;

    public void showLoading(String msg) {

        this.runOnUiThread(() -> {
            if (progressDialog == null) {
                progressDialog = new ProgressDialog(BaseActivity.this);
            }
            progressDialog.setMessage(msg);
            progressDialog.show();
        });
    }

    public void showLoading() {
        this.runOnUiThread(() -> {
            if (progressDialog == null) {
                progressDialog = new ProgressDialog(BaseActivity.this);
            }
            progressDialog.setMessage("");
            progressDialog.show();
        });

    }

    public void hideLoading() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }
}

