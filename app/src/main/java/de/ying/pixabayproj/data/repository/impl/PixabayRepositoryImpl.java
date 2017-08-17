package de.ying.pixabayproj.data.repository.impl;

import java.util.Map;

import javax.inject.Inject;

import de.ying.pixabayproj.data.model.PixabayMessage;
import de.ying.pixabayproj.data.net.RetrofitFactory;
import de.ying.pixabayproj.data.net.api.PixabayApi;
import de.ying.pixabayproj.data.repository.PixabayRepository;
import rx.Observable;

/**
 * Created by yingli on 7/29/17.
 */

public class PixabayRepositoryImpl implements PixabayRepository {

    @Inject
    public PixabayRepositoryImpl() {
    }

    @Override
    public Observable<PixabayMessage> getImages(Map<String, String> map) {
        return RetrofitFactory.getInstance().create(PixabayApi.class).getImages(map);
    }

}
