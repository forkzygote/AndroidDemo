package de.ying.pixabayproj.mvp.View;

import de.ying.pixabayproj.base.BaseView;
import de.ying.pixabayproj.data.model.PixabayMessage;

public interface MainView extends BaseView {
    void getImageSuc(PixabayMessage pixabayMessage);
    void getImageFail(Throwable e);
    void noInternet();
    void openHitDetailUtil(int position);

    void showDetailDialog(int position);
}
