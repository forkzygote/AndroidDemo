package de.ying.pixabayproj.data.repository;

import java.util.Map;

import de.ying.pixabayproj.data.model.PixabayMessage;
import rx.Observable;

/**
 * Created by yingli on 7/29/17.
 */

public interface PixabayRepository {

    Observable<PixabayMessage> getImages(Map<String, String> map);

}
