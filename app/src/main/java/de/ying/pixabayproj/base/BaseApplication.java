package de.ying.pixabayproj.base;

import android.app.Application;

import de.ying.pixabayproj.injection.Component.ApplicationComponent;
import de.ying.pixabayproj.injection.Component.DaggerApplicationComponent;
import de.ying.pixabayproj.injection.module.ApplicationModule;

public class BaseApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();

    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }

}