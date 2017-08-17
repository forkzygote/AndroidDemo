package de.ying.pixabayproj.mvp.Presenter;

import java.util.Map;

import javax.inject.Inject;

import de.ying.pixabayproj.base.BaseAbstractPresenter;
import de.ying.pixabayproj.base.BaseActivity;
import de.ying.pixabayproj.base.BaseSubscriber;
import de.ying.pixabayproj.data.model.PixabayMessage;
import de.ying.pixabayproj.data.service.PixabayService;
import de.ying.pixabayproj.mvp.View.MainView;

public class MainPresenter extends BaseAbstractPresenter<MainView> {

    @Inject
    PixabayService pixabayService;

    @Inject
    public MainPresenter() {
    }

    public void getImage(Map<String, String> map, BaseActivity act) {
        if (!checkNetWork()) {
            mView.noInternet();
            return;
        }
        mView.showLoading();
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

}
