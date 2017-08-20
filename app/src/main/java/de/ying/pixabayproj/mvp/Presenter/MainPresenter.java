package de.ying.pixabayproj.mvp.Presenter;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import de.ying.pixabayproj.base.BaseAbstractPresenter;
import de.ying.pixabayproj.base.BaseActivity;
import de.ying.pixabayproj.base.BaseSubscriber;
import de.ying.pixabayproj.data.model.PixabayMessage;
import de.ying.pixabayproj.data.service.PixabayService;
import de.ying.pixabayproj.mvp.View.MainView;
import de.ying.pixabayproj.utils.Constants;

public class MainPresenter extends BaseAbstractPresenter<MainView> {

    @Inject
    PixabayService pixabayService;

    @Inject
    public MainPresenter() {
    }

    public void getImage(String query, BaseActivity act) {
        if (!checkNetWork()) {
            mView.noInternet();
            return;
        }
        mView.showLoading();

        Map<String, String> map = setSearchMap(query);

        pixabayService.execute(new BaseSubscriber<PixabayMessage>(mView) {
            @Override
            public void onNext(PixabayMessage model) {
                mView.getImageSuc(model);
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                mView.getImageFail(e);
            }
        }, pixabayService.getImages(map), act);
    }

    public void openHitDetail(int position) {
        mView.openHitDetailUtil(position);
    }

    private HashMap<String, String> setSearchMap(String q){
        HashMap<String, String> map = new HashMap<>();
        map.put("image_type", "all");
        map.put("page", "1");
        map.put("q", q);
        map.put("key", Constants.API_KEY);
        return map;
    }
}
