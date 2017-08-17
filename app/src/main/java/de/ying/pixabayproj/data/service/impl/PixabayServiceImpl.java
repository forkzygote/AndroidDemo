package de.ying.pixabayproj.data.service.impl;

import java.util.Map;

import javax.inject.Inject;

import de.ying.pixabayproj.data.model.PixabayMessage;
import de.ying.pixabayproj.data.repository.PixabayRepository;
import de.ying.pixabayproj.data.service.PixabayService;
import rx.Observable;

/**
 * Created by yingli on 7/29/17.
 */

public class PixabayServiceImpl extends PixabayService {

    @Inject
    PixabayRepository pixabayRepository;

    @Inject
    public PixabayServiceImpl(){}

    @Override
    public Observable<PixabayMessage> getImages(Map<String, String> map) {
        return pixabayRepository.getImages(map);
    }

}
