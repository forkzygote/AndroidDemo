package de.ying.pixabayproj.data.service;

import java.util.Map;

import de.ying.pixabayproj.base.BaseService;
import de.ying.pixabayproj.data.model.PixabayMessage;
import rx.Observable;

/**
 * Created by yingli on 7/29/17.
 */

public abstract class PixabayService extends BaseService{

    public abstract Observable<PixabayMessage> getImages(Map<String, String> map);

}
