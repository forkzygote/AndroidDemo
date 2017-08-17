package de.ying.pixabayproj.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.preference.PreferenceManager;
import android.text.TextUtils;

/**
 * Created by yingli on 7/29/17.
 */

public class PreferenceUtil {
    /**
     * Method clear all ShardPreference
     * @param context
     * @param strPref
     */
    public static void clear(Context context, String strPref){
        SharedPreferences settings = null;
        if (TextUtils.isEmpty(strPref))
            settings = PreferenceManager.getDefaultSharedPreferences(context);
        else {
            settings = context.getSharedPreferences(strPref, 0);
        }
        settings.edit().clear().commit();
        PackageInfo pInfo = null;
        try {
            pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        }
        catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        String version = pInfo.versionName;
        PreferenceUtil.setBoolean(context, Constants.SHARED_PREFERENCES, version, true);
    }

    /**
     * Method Remove a Pref by key
     * @param context
     * @param strPref
     * @param strKey
     */
    public static void clearPrefs(Context context, String strPref, String strKey) {
        SharedPreferences settings = null;
        if (TextUtils.isEmpty(strPref))
            settings = PreferenceManager.getDefaultSharedPreferences(context);
        else {
            settings = context.getSharedPreferences(strPref, 0);
        }

        settings.edit().remove(strKey).commit();
    }

    /**
     * Method get String Preference
     * @param context
     * @param strPref
     * @param strKey
     * @param strDefValue
     * @return
     */
    public static String getString(Context context, String strPref,
                                   String strKey, String strDefValue) {
        if (null == context) {
            return strDefValue;
        }

        SharedPreferences settings = null;
        if (TextUtils.isEmpty(strPref))
            settings = PreferenceManager.getDefaultSharedPreferences(context);
        else {
            settings = context.getSharedPreferences(strPref, 0);
        }

        if (null == settings) {
            return strDefValue;
        }

        return settings.getString(strKey, strDefValue);
    }

    /**
     * Method set String preference
     * @param context
     * @param strPref
     * @param strKey
     * @param strValue
     */
    public static void setString(Context context, String strPref,
                                 String strKey, String strValue) {
        if (null == context) {
            return;
        }

        SharedPreferences settings = null;
        if (TextUtils.isEmpty(strPref))
            settings = PreferenceManager.getDefaultSharedPreferences(context);
        else {
            settings = context.getSharedPreferences(strPref, 0);
        }

        if (null == settings) {
            return;
        }

        SharedPreferences.Editor editor = settings.edit();
        editor.putString(strKey, strValue);
        editor.commit();
    }

    /**
     * Method get Int Preference
     * @param context
     * @param strPref
     * @param strKey
     * @param nDefValue
     * @return
     */
    public static int getInt(Context context, String strPref, String strKey,
                             int nDefValue) {
        if (null == context) {
            return nDefValue;
        }

        SharedPreferences settings = null;
        if (TextUtils.isEmpty(strPref))
            settings = PreferenceManager.getDefaultSharedPreferences(context);
        else {
            settings = context.getSharedPreferences(strPref, 0);
        }

        if (null == settings) {
            return nDefValue;
        }

        return settings.getInt(strKey, nDefValue);
    }

    /**
     * Method set Int Preference
     * @param context
     * @param strPref
     * @param strKey
     * @param nValue
     */
    public static void setInt(Context context, String strPref, String strKey,
                              int nValue) {
        if (null == context) {
            return;
        }

        SharedPreferences settings = null;
        if (TextUtils.isEmpty(strPref))
            settings = PreferenceManager.getDefaultSharedPreferences(context);
        else {
            settings = context.getSharedPreferences(strPref, 0);
        }

        if (null == settings) {
            return;
        }

        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(strKey, nValue);
        editor.commit();
    }

    /**
     * MeThod get Boolean Preference
     * @param context
     * @param strPref
     * @param strKey
     * @param bDefValue
     * @return
     */
    public static boolean getBoolean(Context context, String strPref,
                                     String strKey, boolean bDefValue) {
        if (null == context) {
            return bDefValue;
        }

        SharedPreferences settings = null;
        if (TextUtils.isEmpty(strPref))
            settings = PreferenceManager.getDefaultSharedPreferences(context);
        else {
            settings = context.getSharedPreferences(strPref, 0);
        }

        if (null == settings) {
            return bDefValue;
        }

        return settings.getBoolean(strKey, bDefValue);
    }

    /**
     * Method set Boolean Preference
     * @param context
     * @param strPref
     * @param strKey
     * @param bValue
     */
    public static void setBoolean(Context context, String strPref,
                                  String strKey, boolean bValue) {
        if (null == context) {
            return;
        }

        SharedPreferences settings = null;
        if (TextUtils.isEmpty(strPref))
            settings = PreferenceManager.getDefaultSharedPreferences(context);
        else {
            settings = context.getSharedPreferences(strPref, 0);
        }

        if (null == settings) {
            return;
        }

        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(strKey, bValue);
        editor.commit();
    }

    /**
     * Method get Long Preference
     * @param context
     * @param strPref
     * @param strKey
     * @param nDefValue
     * @return
     */
    public static long getLong(Context context, String strPref, String strKey,
                               long nDefValue) {
        if (null == context) {
            return nDefValue;
        }

        SharedPreferences settings = null;
        if (TextUtils.isEmpty(strPref))
            settings = PreferenceManager.getDefaultSharedPreferences(context);
        else {
            settings = context.getSharedPreferences(strPref, 0);
        }

        if (null == settings) {
            return nDefValue;
        }

        return settings.getLong(strKey, nDefValue);
    }

    /**
     * Method set Long preference
     * @param context
     * @param strPref
     * @param strKey
     * @param nValue
     */
    public static void setLong(Context context, String strPref, String strKey,
                               long nValue) {
        if (null == context) {
            return;
        }

        SharedPreferences settings = null;
        if (TextUtils.isEmpty(strPref))
            settings = PreferenceManager.getDefaultSharedPreferences(context);
        else {
            settings = context.getSharedPreferences(strPref, 0);
        }

        if (null == settings) {
            return;
        }

        SharedPreferences.Editor editor = settings.edit();
        editor.putLong(strKey, nValue);
        editor.commit();
    }
}
