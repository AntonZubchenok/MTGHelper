package com.zubchenok.mtghelper.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class ActivityUtils {

    private static ActivityUtils instance;

    private ActivityUtils() {

    }

    public static synchronized ActivityUtils getInstance() {
        if (instance == null) {
            instance = new ActivityUtils();
        }
        return instance;
    }

    public void addFragmentToActivity(FragmentManager fragmentManager,
                                      Fragment fragment,
                                      int containerResId,
                                      String tag) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(containerResId, fragment, tag);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
