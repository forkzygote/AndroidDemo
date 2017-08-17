package de.ying.pixabayproj.injection.module;

import dagger.Module;
import dagger.Provides;
import de.ying.pixabayproj.data.repository.PixabayRepository;
import de.ying.pixabayproj.data.repository.impl.PixabayRepositoryImpl;
import de.ying.pixabayproj.data.service.PixabayService;
import de.ying.pixabayproj.data.service.impl.PixabayServiceImpl;

@Module
public class PixabayModule {

    /**
     * Expose the PixabayService to dependents in the graph.
     */
    @Provides
    PixabayService providePixabayService(PixabayServiceImpl service){
        return service;
    }


    /**
     * Expose the PixabayRepository to dependents in the graph.
     */
    @Provides
    PixabayRepository providePixabayRepository(PixabayRepositoryImpl repository){
        return repository;
    }
}
