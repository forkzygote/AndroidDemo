package de.ying.pixabayproj;

/**
 * Created by yingli on 7/29/17.
 *
 * Pixabay is the application class
 */

import android.content.Context;

import de.ying.pixabayproj.base.BaseApplication;

public class Pixabay extends BaseApplication {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    /**
     * provide application context
     * @return
     */
    public static Context getContext() {
        return mContext;
    }
}
