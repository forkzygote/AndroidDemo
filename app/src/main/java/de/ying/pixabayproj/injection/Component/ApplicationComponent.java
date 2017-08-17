package de.ying.pixabayproj.injection.Component;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import de.ying.pixabayproj.base.BaseActivity;
import de.ying.pixabayproj.injection.module.ApplicationModule;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);

    Context context();
}
