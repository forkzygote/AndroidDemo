package de.ying.pixabayproj.data.net.api;

import java.util.Map;

import de.ying.pixabayproj.data.model.PixabayMessage;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by yingli on 7/29/17.
 */

public interface PixabayApi {
    /**
     * Query for Images in Pixabay
     * @param parameter Map<String, String>
     * @return
     */
    @GET("api/")
    Observable<PixabayMessage> getImages(@QueryMap Map<String, String> parameter);
}
