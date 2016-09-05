package pl.dawidfiruzek.retrofitexample;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by Dawid Firuzek on 05.09.16.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if(BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}
