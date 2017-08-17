package de.ying.pixabayproj.injection.Component;

import dagger.Component;
import de.ying.pixabayproj.activity.MainActivity;
import de.ying.pixabayproj.injection.PerActivity;
import de.ying.pixabayproj.injection.module.ActivityModule;
import de.ying.pixabayproj.injection.module.PixabayModule;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class,
        PixabayModule.class})
public interface PixabayComponent {
    void inject(MainActivity baseActivity);
}
