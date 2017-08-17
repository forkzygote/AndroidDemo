package de.ying.pixabayproj.base;

/**
 * Created by yingli on 7/29/17.
 */

public interface BaseView {
    void showLoading();
    void hideLoading();
    void onError(String msg);
    void onSuccess(String msg);
    void onThrowable(Throwable e);
}
